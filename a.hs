import Link
import City 
import Point 
import Quality
data Tunel = Tun [Link] deriving (Eq, Show)
newT :: [Link] -> Tunel
newT [link] = Tun [link]
connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun links) =foldr(\each fold -> if (linksL city1 city2 each) then True else fold) False links

p1= newP 2 2
a= newC "a" p1
b= newP 1 2
d= newC "ola" b
q=newQ "d" 4 3.0
l=newL a d q 

p3= newP 2 2
f= newC "f" p1
t= newT [l2]
l2=newL a f q

