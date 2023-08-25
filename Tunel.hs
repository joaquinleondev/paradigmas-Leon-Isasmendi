module Tunel ( Tunel, newT, connectsT, usesT, delayT ) where
import Point ()
import City ( City, distanceC )
import Quality ()
import Link 

data Tunel where
  Tun :: [Link] -> Tunel
  deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun


connectsT :: City -> City -> Tunel -> Bool
connectsT city1 city2 (Tun links)
  | city1 == city2 = error "Chequeando la misma ciudad"
  | otherwise = connectsL city1 (head links) && connectsL city2 (last links) || connectsL city2 (head links) && connectsL city1 (last links) 


usesT :: Link -> Tunel -> Bool
usesT link (Tun links) = link `elem` links


delayT :: Tunel -> Float
delayT (Tun links) = sum (map delayL links)