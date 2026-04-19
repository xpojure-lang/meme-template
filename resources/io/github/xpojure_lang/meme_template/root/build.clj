(ns build
  (:require [clojure.tools.build.api :as b]))

(def lib '{{top/ns}}/{{main/ns}})
(def version "0.1.0")
(def class-dir "target/classes")
(def jar-file (format "target/%s-%s.jar" (name lib) version))
(def basis (delay (b/create-basis {:project "deps.edn"})))

(defn clean [_]
  (b/delete {:path "target"}))

(defn jar [_]
  (clean nil)
  (b/process {:command-args ["bb" "meme" "transpile" "src"]})
  (b/compile-clj {:basis     @basis
                  :src-dirs  ["target/meme"]
                  :class-dir class-dir})
  (b/write-pom {:class-dir class-dir
                :lib       lib
                :version   version
                :basis     @basis
                :src-dirs  ["src"]})
  (b/copy-dir {:src-dirs   ["src" "target/meme"]
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file  jar-file}))
