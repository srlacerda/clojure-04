(ns hospital.model)

; Uma variacao baseada na palestra a seguir, mas com extend-type com gregorian calendar
; From Sean Devlin's talk on protocols at Clojure Conj
(defprotocol Dateble
  (to-ms [this]))

(extend-type Number
  Dateble
  (to-ms [this] this))

(extend-type java.util.Date
  Dateble
  (to-ms [this] (.getTime this)))

(extend-type java.util.Calendar
  Dateble
  (to-ms [this] (to-ms (.getTime this))))