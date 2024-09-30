(ns com.grandprixsw.pfds.stack)

(defprotocol Stack
  (is-empty? [this])
  (con-s [this x])
  (hd [this])
  (tl [this]))

(deftype stack-native [head tail] Stack
         (is-empty? [this] (nil? head))
         (con-s [this x] (stack-native. x this))
         (hd [this] head)
         (tl [this] tail)

         #_(stk-prn [this]
           (print head)))

(def empty-stack nil)

(defn new-stack []
  (stack-native. empty-stack empty-stack))
