(ns tie.tyt.select)

(defn select [& args]  
  (let [group-map (group-by fn? args)
        fns (get group-map true)
        cols (get group-map false)]
    (when (or (empty? fns) (empty? cols))
      (throw (IllegalArgumentException. 
               "You must pass in at least one function and at least one collection.")))
    (apply (apply juxt fns) cols)))