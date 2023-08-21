module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR ) where
import Point
import City
import Quality
import Link
import Tunel


data Region = Reg [City] [Link] [Tunel]
newR :: Region
newR = Reg [] [] []


foundR :: Region -> City -> Region
foundR (Reg cities links tunnels) city
| any (\city' -> city' == city) cities = error "La ciudad ya existe"
| otherwise = Reg (city:cities) links tunnels


linkR :: Region -> City -> City -> Quality -> Region
linkR (Reg cities links tunnels) city1 city2 quality
| not (any (\city' -> city' == city1) cities && any (\city' -> city' == city2) cities) = error "Las ciudades no existen"
| any (\link' -> (city1 == city link') && (city2 == city' link')) links = error "Las ciudades ya estan enlazadas"
| otherwise = Reg cities ((newL city1 city2 quality):links) tunnels


tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cities links tunnels) cities


connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades