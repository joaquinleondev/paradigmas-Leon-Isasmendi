module Region (  Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR ) where
import Point ()
import City ( City )
import Quality ( Quality )
import Link
import Tunel

data Region = Reg [City] [Link] [Tunel] deriving (Show)
newR :: Region
newR = Reg [] [] []


foundR :: Region -> City -> Region
foundR (Reg cities links tunnels) city
    | city `elem` cities = error "La ciudad ya forma parte de la ciudad"
    | otherwise = Reg (city:cities) links tunnels


linkR :: Region -> City -> City -> Quality -> Region
linkR (Reg cities links tunnels) city1 city2 quality
    | not (city1 `elem` cities || city2 `elem` cities) = error "Alguna o ninguna de las ciudades existe"
    | any (\link -> (newL city1 city2 quality == link) || (newL city2 city1 quality == link)) links = error "El link ya existe"
    | otherwise = Reg cities (newL city1 city2 quality:links) tunnels

capacidadUsadaLink :: (Num b, Foldable t1, Foldable t2, Eq a) => a -> t1 (t2 a) -> b
capacidadUsadaLink link tunels = foldr(\tunel fold1 -> (foldr(\linkUsado fold -> if linkUsado == link then fold + 1 else fold)0 tunel) + fold1 ) 0 tunels
capacidadDisponibleLink :: Link -> t -> Int
capacidadDisponibleLink link tunels = capacityL link - capacidadUsadaLink link tunels

posibleTunelR ::  Region -> [City] -> Bool
posibleTunelR (Reg cities links tunels)| length cities == 0 = error "Lista de ciudades vacia"
posibleTunelR (Reg cities links tunels)| length cities == 1 = True
posibleTunelR (Reg (city:citys) links tunels)= (any (\link -> (linksL city (head citys) link) && ((capacidadDisponibleLink link tunels ) > 0)  ) links)  && (posibleTunelR citys)

citiesToLinks::Region -> [Link]
citiesToLinks (Reg cities links tunels)| length cities == 1 = []
citiesToLinks (Reg (city:citys) links tunels)= [foldr (\link fold-> if (linkL city (head citys) && (capacidadDisponibleLink link tunels ) >0 ) then link else fold ) 0 links] ++ [citiesToLinks (Reg citys links tunels)]

tunelR :: Region -> [ City ] -> Region
tunelR (Reg cities links tunnels) citiesToAdd
    | length cities < 2 = error "Debe haber al menos dos ciudades"
    | any (`notElem` cities) citiesToAdd = error "Alguna de las ciudades no existe"
    | not( posibleTunelR) = error " No existen links para conectar todas las ciudades"
    | otherwise = Reg cities links ((newT (citiesToLinks citiesToAdd )):tunnels)


connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunnels) city1 city2 = any (connectsT city1 city2) tunnels


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunnels) city1 city2 = any (linksL city1 city2) links


delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cities links tunnels) city1 city2
    | not (city1 `elem` cities && city2 `elem` cities) = error "Las ciudades no existen"
    | not (connectedR (Reg cities links tunnels) city1 city2) = error "Las ciudades no estan conectadas"
    | otherwise = delayT (head (filter (connectsT city1 city2) tunnels))


availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR = error "Not implemented yet"