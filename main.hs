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
quality2 = newQ "Quality2" 2 2.0

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
region1 = Reg [city1, city2, city3, city4] [link1, link2, link3] []

region2 = tunelR region1 [city1, city2, city3, city4]