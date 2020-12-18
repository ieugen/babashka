(ns babashka.profile
  (:require [babashka.main :as main]))

(comment)

;; clojure -J-XX:+UnlockDiagnosticVMOptions -J-XX:+DebugNonSafepoints -J-D-Djdk.attach.allowAttachSelf -J-Dclojure.compiler.direct-linking=true -M:profile tmp/meander.clj

(require '[clj-async-profiler.core :as prof])

(defn -main [& options]
  (future (apply main/main options))
  (Thread/sleep 2000)
  (prn (prof/profile-for 10))
  (shutdown-agents))
