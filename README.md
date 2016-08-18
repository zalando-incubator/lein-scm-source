# lein-scm-source


[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.zalando.stups/lein-scm-source/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.zalando.stups/lein-scm-source)

A Leiningen plugin to generate a `scm-source.json` file according to the [STUPS documentation](http://stups.readthedocs.org/en/latest/user-guide/application-development.html#docker).

## Usage

Put `[org.zalando.stups/lein-scm-source "0.3.0"]` into the `:plugins` vector of your project.clj.

    $ lein scm-source

## License

Copyright © 2015 Zalando SE

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
