module Quality ( Quality, newQ, capacityQ, delayQ ) where
import Point
import City

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ name capacity delay = Qua name capacity delay


capacityQ :: Quality -> Int
capacityQ (Qua _ capacity _) = capacity


delayQ :: Quality -> Float 
delayQ (Qua _ _ delay) = delay