(ns lm-complete.core
  (:gen-class))

(use '[clojure.tools.cli :only [cli]])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; Process command-line arguments.

  (cli args
       ["-p" "--port" "Listen on this port" :parse-fn #(Integer. %)
        :assoc-fn (fn [previous key val]
                    (assoc previous key
                           (if-let [oldval (get previous key)]
                             (merge oldval val)
                             (hash-set val))))]
       ["-h" "--host" "The hostname" :default "localhost"]
       ["-v" "--[no-]verbose" :default true]
       ["-l" "--log-directory" :default "/some/path"]))
