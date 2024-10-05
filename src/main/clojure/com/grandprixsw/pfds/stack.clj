(ns com.grandprixsw.pfds.stack
  (:require [clojure.core :as cc]))

(defprotocol Stack
  (empty? [this])
  (cons [this x])
  (head [this])
  (tail [this]))

(deftype stack-native [head_ tail_] Stack
         (empty? [this] (nil? head_))
         (cons [this x] (stack-native. x this))
         (head [this]
           (if-not (empty? this)
             head_
             (throw (Exception. "Can't operate on empty stack"))))
         (tail [this]
           (if (empty? this)
             (throw (Exception. "Can't operate on empty stack"))
             tail_)))

(extend-type clojure.lang.PersistentList$EmptyList
  Stack
  (empty? [_] true))

(extend-type nil
  Stack
  (empty? [_] true))

(extend-type clojure.lang.PersistentList
  Stack
  (empty? [this] (cc/empty? this))
  (cons [this x] (conj this x))
  (head [this] (first this))
  (tail [this] (rest this)))

(def empty-stack nil)
(def empty-stack-clj '())

(defn new-stack-clj [item]
  (conj empty-stack-clj item))

(defn new-stack [item]
  (stack-native. item empty-stack))

(defn show-stack [s]
  (loop [stk s
         lst []]
    (if (or (nil? stk) (empty? stk))
      lst
      (recur (tail stk) (conj lst (head stk))))))
