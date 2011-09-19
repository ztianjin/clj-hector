(ns clj-hector.test.time
  (:import [java.util UUID]
           [org.joda.time Instant])
  (:use [clojure.test]
        [clj-hector.time] :reload))

(defn close-enough?
  [a b]
  (let [diff (- a
                b)]
    (< diff 100)))

(deftest time-as-uuid
  (let [now (uuid-now)
        now-date (java.util.Date. )]
    (is (= now (from-bytes (to-bytes now))))
    (is (close-enough? (epoch now-date)
                       (epoch (get-date (to-bytes now)))))
    (is (instance? UUID now))
    (is (close-enough? (epoch now-date)
                       (epoch (get-date (to-bytes (uuid (epoch now-date)))))))))

(deftest joda-support
  (is (instance? UUID (uuid (epoch (Instant/now)))))
  (is (close-enough? (epoch (Instant/now))
                     (epoch (get-date (to-bytes (uuid-now)))))))
