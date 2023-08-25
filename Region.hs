module Region (  Region (Reg), newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR ) where
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


tunelR :: Region -> [ City ] -> Region
tunelR (Reg cities links tunnels) citiesToAdd
    | length cities < 2 = error "Debe haber al menos dos ciudades"
    | any (`notElem` cities) citiesToAdd = error "Alguna de las ciudades no existe"
    | not (validTunelR (Reg cities links tunnels) citiesToAdd 0) = error "No hay links que unan las dos ciudades"
    | otherwise = Reg cities links (newT (citiesToLinksR (Reg cities links tunnels) citiesToAdd):tunnels)


connectedR :: Region -> City -> City -> Bool
connectedR (Reg _ _ tunnels) city1 city2 = any (connectsT city1 city2) tunnels


linkedR :: Region -> City -> City -> Bool
linkedR (Reg _ links _) city1 city2 = any (linksL city1 city2) links


delayR :: Region -> City -> City -> Float
delayR (Reg cities links tunnels) city1 city2
    | not (city1 `elem` cities && city2 `elem` cities) = error "Las ciudades no existen"
    | not (connectedR (Reg cities links tunnels) city1 city2) = error "Las ciudades no estan conectadas"
    | otherwise = delayT (head (filter (connectsT city1 city2) tunnels))


availableCapacityForR :: Region -> City -> City -> Int
availableCapacityForR = error "Not implemented yet"


validTunelR :: Region -> [ City ] -> Int -> Bool
validTunelR (Reg cities links tunnels) citiesToAdd index 
    | index == length citiesToAdd - 1 = True
    | any (\link -> linksL (citiesToAdd !! index) (citiesToAdd !! (index + 1)) link && capacityLinkR tunnels link > 0) links = validTunelR (Reg cities links tunnels) citiesToAdd (index + 1)
    | otherwise = False


capacityLinkR :: [ Tunel ] -> Link -> Int
capacityLinkR tunnels link = (capacityL link) - timesUsed
    where
        timesUsed = length (filter (\tunel -> usesT link tunel) tunnels)


citiesToLinksR :: Region -> [ City ] -> [ Link ]
citiesToLinksR (Reg cities links tunnels) citiesToAdd
    | length citiesToAdd <= 1 = [] 
    | otherwise = validLinks ++ citiesToLinksR (Reg cityTail links tunnels) cityTail
    where
        city = head citiesToAdd
        cityTail = tail citiesToAdd
        validLinks = filter (\link -> isValidLink link) links
        isValidLink link = linksL city (head cityTail) link  && (capacityL link - capacityLinkR tunnels link) > 0
