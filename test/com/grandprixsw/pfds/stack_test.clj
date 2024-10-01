(ns com.grandprixsw.pfds.stack-test
  (:require [clojure.test :refer [deftest is testing]]
            [com.grandprixsw.pfds.stack :as stk]))

(deftest stack-test
  (testing "Test building a simple stack"
    (is (true? (stk/is-empty? (stk/new-stack))))

    (let [s0 (stk/new-stack)
          s1 (stk/con-s s0 :foo)
          s2 (stk/con-s s1 :biz)]
      (is (false? (stk/is-empty? s1))
          "s1 should be non-empty")
      (is (= :foo (stk/head s1)))
      (is (= :biz (stk/head s2))
          "s2 head should be biz")
      (is (= :foo (->> s2 stk/tail stk/head)))
      (is (thrown? java.lang.Exception (stk/head s0))
          "empty stack should throw exception")
      (is (thrown? java.lang.Exception (stk/tail s0))
          "empty stack should throw an exception"))))

