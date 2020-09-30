(ns babashka.impl.postal
  {:no-doc true}
  (:require [postal.core :as postal]
            [sci.core :as sci]))

(def pns (sci/create-ns 'postal.core nil))

(def postal-namespace
  {:obj pns
   'send-message (sci/new-var 'send-message
                              (fn [& args]
                                (System/setProperty "postal.version" "2.0.3")
                                (apply postal/send-message args))
                              (assoc (meta #'postal/send-message)
                                     :ns pns))})
