(ns com.grandprixsw.pfds.stack)

(defprotocol Stack
  (is-empty? [this])
  (con-s [this x])
  (head [this])
  (tail [this]))

(deftype stack-native [head_ tail_] Stack
         (is-empty? [this] (nil? head_))
         (con-s [this x] (stack-native. x this))
         (head [this]
           (if-not (is-empty? this)
             head_
             (throw (Exception. "Can't operate on empty stack"))))
         (tail [this]
           (if (is-empty? this)
             (throw (Exception. "Can't operate on empty stack"))
             tail_)))

(def empty-stack nil)

(defn new-stack []
  (stack-native. empty-stack empty-stack))

(defn show-stack [s]
  (loop [stk s
         lst []]
    (if (is-empty? stk)
      lst
      (recur (tail stk) (conj lst (head stk))))))


