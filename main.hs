import Point
import City
import Quality
import Link
import Tunel
import Region

point1 = newP 0 0
point2 = newP 1 1
point3 = newP 2 2
point4 = newP 3 3

city1 = newC "City1" point1
city2 = newC "City2" point2
city3 = newC "City3" point3
city4 = newC "City4" point4

quality1 = newQ "Quality1" 1 1.0
quality2 = newQ "Quality2" 2 2.0

link1 = newL city1 city2 quality1
link2 = newL city3 city4 quality2
link3 = newL city1 city3 quality1
link4 = newL city2 city4 quality2

tunel1 = newT [link1, link2]
tunel2 = newT [link3, link4]