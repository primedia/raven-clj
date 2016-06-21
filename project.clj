(defproject com.rentpath/raven-clj "1.0.4-SNAPSHOT"
  :description "Sentry clojure client"
  :url "http://github.com/sethtrain/raven-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[cheshire "5.0.1"]
                 [clj-http "0.6.4"]
                 [org.clojure/clojure "1.5.1"]]
  :repositories [["releases" {:url "http://nexus.idg.primedia.com/nexus/content/repositories/primedia"
                              :sign-releases false
                              :username [:gpg :env/nexus_username]
                              :password [:gpg :env/nexus_password]}]])
