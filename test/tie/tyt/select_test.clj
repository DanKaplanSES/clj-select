(ns tie.tyt.select-test
  (:require [midje.sweet :refer :all])
  (:require [tie.tyt.select :refer :all]))

(fact "about `select`"
      (select) => (throws Exception "You must pass in at least one function and at least one collection.")
      (select 1) => (throws Exception "You must pass in at least one function and at least one collection.")
      (select +) => (throws Exception "You must pass in at least one function and at least one collection.")
      (select (partial filter odd?) [1 2 3]) => [[1 3]]
      (select (partial filter odd?) (partial filter even?) [1 2 3]) => [[1 3] [2]]
      (select (partial map +) [1 2 3] [4 5 6]) => [[5 7 9]]
      )