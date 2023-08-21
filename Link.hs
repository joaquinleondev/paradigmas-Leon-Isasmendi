module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where
import City
import Quality
import Point
data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL city1 city2 quality = Lin city1 city2 quality
connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city (Lin city1 city2 quality)| city == city1 = True
                                        | city == city2 = True
                                        | otherwise = False
linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL city1 city2 (Lin city3 city4 quality)|(city1 == city3 && city2==city4 ) || ( city2== city3 && city1==city4 ) = True
                                            | otherwise = False
capacityL :: Link -> Int
capacityL (Lin city1 city2 quality)= capacityQ quality
delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin city1 city2 quality)= delayQ quality
p1= newP 2 2
a= newC "a" p1
b= newP 1 2
d= newC "ola" b
q=newQ "d" 4 3.0
l=newL a d q 
p3= newP 2 2
f= newC "f" p1