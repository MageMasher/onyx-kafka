(defproject org.onyxplatform/onyx-kafka "0.11.0.0-SNAPSHOT"
  :description "Onyx plugin for Kafka"
  :url "https://github.com/onyx-platform/onyx-kafka"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories {"snapshots" {:url "https://clojars.org/repo"
                              :username :env
                              :password :env
                              :sign-releases false}
                 "releases" {:url "https://clojars.org/repo"
                             :username :env
                             :password :env
                             :sign-releases false}}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 ^{:voom {:repo "git@github.com:onyx-platform/onyx.git" :branch "master"}}
                 [org.onyxplatform/onyx "0.11.0-20170912_214607-ga7694ad"]
                 [org.apache.kafka/kafka_2.11 "0.11.0.0"]
                 [org.apache.kafka/kafka-clients "0.11.0.0"]
                 [com.stuartsierra/component "0.2.3"]
                 [cheshire "5.7.0"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.9.0"]
                                  [com.gfredericks/test.chuck "0.2.7"]
                                  [zookeeper-clj "0.9.3" :exclusions [io.netty/netty org.apache.zookeeper/zookeeper]]
                                  [aero "0.2.0"]
                                  [prismatic/schema "1.0.5"]] 
                   :plugins [[lein-set-version "0.4.1"]
                             [lein-update-dependency "0.1.2"]
                             [lein-pprint "1.1.1"]]
                   :global-vars  {*warn-on-reflection* true
                                  *assert* false
                                  *unchecked-math* :warn-on-boxed}
                   :java-opts ^:replace ["-server"
                                         "-XX:+UseG1GC"
                                         "-XX:-OmitStackTraceInFastThrow"
                                         "-Xmx2g"
                                         "-Daeron.client.liveness.timeout=50000000000"
                                         "-XX:+UnlockCommercialFeatures" 
                                         "-XX:+FlightRecorder"
                                         "-XX:+UnlockDiagnosticVMOptions"
                                         "-XX:StartFlightRecording=duration=240s,filename=localrecording.jfr"]}})
