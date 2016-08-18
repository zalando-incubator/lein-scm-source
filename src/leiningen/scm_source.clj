(ns leiningen.scm-source
  (:require [clojure.java.shell :as sh]
            [clojure.string :as string]
            [clojure.data.json :as json]
            [clojure.java.io :as io]
            [leiningen.core.main :as main]))

(defn exec
  "Execute a shell command and return its output. Throws an exception on error."
  [& cmd]
  (let [result (apply sh/sh cmd)]
    (when-not (zero? (:exit result))
      (throw (IllegalStateException. (str (apply string/join " " cmd) " exited with " (:exit result) ": " (:err result)))))
    (string/trim (:out result))))

(defn- write [target-path content]
  (let [f (io/file target-path "scm-source.json")]
    (io/make-parents f)
    (spit f content)
    (main/info "Wrote" (.getCanonicalPath f))))

(defn scm-source
  "Generates the 'scm-source.json' according to the STUPS documentation."
  [project & args]
  (->> {:revision (exec "git" "rev-parse" "HEAD")
        :url      (str "git:" (exec "git" "config" "--get" "remote.origin.url"))
        :status   (exec "git" "status" "--porcelain")
        :author   (exec "id" "-un")}
       (json/write-str)
       (write (:target-path project))))
