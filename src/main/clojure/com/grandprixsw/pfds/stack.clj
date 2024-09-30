(ns com.grandprixsw.pfds.stack)

(defprotocol Stack
  (is-empty? [this])
  (con-s [this x])
  (head [this])
  (tail [this]))

(deftype stack-native [head_ tail_] Stack
         (is-empty? [this] (nil? head_))
         (con-s [this x] (stack-native. x this))
         (head [this] head_)
         (tail [this] tail_)

         #_(stk-prn [this]
           (print head)))

(def empty-stack nil)

(defn new-stack []
  (stack-native. empty-stack empty-stack))
