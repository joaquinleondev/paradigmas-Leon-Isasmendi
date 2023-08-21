module Tunel ( Tunel, newT, connectsT, usesT, delayT ) where
import Point
import City
import Quality
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT links = Tun links


connectsT :: City -> City -> Tunel -> Bool
connectsT city1 city2 (Tun links) = any (\link -> linksL city1 city2 link) links


usesT :: Link -> Tunel -> Bool
usesT link (Tun links) = any (\link' -> link' == link) links


delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = sum (map delayL links)