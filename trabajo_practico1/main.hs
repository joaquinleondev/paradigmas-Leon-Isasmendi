import Point
import City
import Quality
import Link
import Tunel
import Region

point1 :: Point
point1 = newP 0 0
point2 :: Point
point2 = newP 1 1
point3 :: Point
point3 = newP 2 2
point4 :: Point
point4 = newP 3 3

city1 :: City
city1 = newC "City1" point1
city2 :: City
city2 = newC "City2" point2
city3 :: City
city3 = newC "City3" point3
city4 :: City
city4 = newC "City4" point4

quality1 :: Quality
quality1 = newQ "Quality1" 2 1.0
quality2 :: Quality
quality2 = newQ "Quality2" 1 2.0

link1 :: Link
link1 = newL city1 city2 quality1
link2 :: Link
link2 = newL city2 city3 quality1
link3 :: Link
link3 = newL city3 city4 quality1
link4 :: Link
link4 = newL city2 city4 quality1

tunel1 :: Tunel
tunel1 = newT [link1, link2]
tunel2 :: Tunel
tunel2 = newT [link1, link4]

cities :: [ City ]
cities = [city1, city1]

region1 :: Region
region1 = newR

region2 = foundR region1 city1

region3 = foundR region2 city2

region4 = foundR region3 city3

region5 = foundR region4 city4

region6 = linkR region5 city1 city2 quality1

region7 = linkR region6 city2 city3 quality1

region8 = linkR region7 city3 city4 quality2

region9 = tunelR region8 [city1, city2]

region10 = tunelR region9 [city2, city3, city4]

region11 = connectedR region10 city1 city2

region12 = connectedR region10 city1 city3

region13 = linkedR region10 city1 city4

region14 = delayR region10 city2 city4

region15 = availableCapacityForR region10 city2 city3