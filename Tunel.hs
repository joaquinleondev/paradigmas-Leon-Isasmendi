module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where
import Link
import City
import Point 
import Quality
data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT [link] = Tun [link]
connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun links) =foldr(\link fold -> if (linksL city1 city2 link) then True else fold) False links
usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link1 (Tun links)= foldr(\link2 fold -> if (link1==link2) then True else fold) False links
delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links)= foldr(\link fold ->  (delayL link) + fold) 0 links 
p1= newP 2 2
a= newC "a" p1
b= newP 1 2
d= newC "ola" b
q=newQ "d" 4 3.0
l=newL a d q 
p3= newP 2 2
f= newC "f" p1
t= newT [l]
l2=newL a f q
t2= newT [l2]