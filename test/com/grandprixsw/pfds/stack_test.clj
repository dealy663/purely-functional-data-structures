(ns com.grandprixsw.pfds.stack-test
  (:require [clojure.test :refer [deftest is testing]]
            [com.grandprixsw.pfds.stack :as sut]))

(deftest stack-test
  (testing "Test building a simple stack"
    (is (sut/empty? sut/empty-stack))

    (let [s1 (sut/new-stack :foo)
          s2 (sut/cons s1 :biz)
          s3 (sut/cons s2 :bar)]
      (is (false? (sut/empty? s1))
          "s1 should be non-empty")
      (is (= :foo (sut/head s1)))
      (is (= :biz (sut/head s2))
          "s2 head should be biz")
      (is (= :foo (->> s2 sut/tail sut/head)))
      (is (= s1 (->> s3 sut/tail sut/tail))
          "The stack s1 should be the second tail in s3"))))
