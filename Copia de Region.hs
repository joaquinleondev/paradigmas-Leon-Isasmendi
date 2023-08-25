module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where
import Link
import City
import Point 
import Quality
import Tunel
data Region = Reg [City] [Link] [Tunel]
newR :: Region
newR = Reg [] [] []
foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg citys links tunels) city= Reg (citys ++ city ) links tunels  
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg citys links tunels) city1 city2 quality| ((elem city1 citys) && (elem city1 citys) && (not(elem (newL city1 city2 quality) links ))) = Reg citys (links ++ (newL city1 city2 quality)) tunels
                                                  |not((elem city1 citys) && (elem city1 citys)) =error " No se pueden conectar. Al menos una ciudad no pertenece a la region."
                                                  |(elem (newL city1 city2 quality) links ) = error " El link ya existe."

capacidadUsadaLink link (Reg citys links tunels)=foldr(\tunel fold1 -> (foldr(\linkUsado fold -> if linkUsado == link then fold + 1 else fold)0 tunel) + fold1 ) 0 tunels
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg citys links tunels) [city1 , city2] | len([link | link <- links, (linksL city1 city2 link ) && ( capacityL link - (capacidadUsada link (Reg citys links tunels) ))>0  ]) =Reg citys links (tunels ++ (newT [link | link <- links, (linksL city1 city2 link )]))
                                                |otherwise = error " No existe ningun link que conecte ambas ciudades y si existe no tiene capacidad disponible."
connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg citys links tunels) city1 city2 = foldr (\tunel fold -> if (connectsT city1 city2 tunel)then True else fold) False tunels
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg citys links tunels) city1 city2 = foldr (\link fold -> if (linksT city1 city2 link)then True else fold) False links
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg citys links tunels) city1 city2 = foldr (\tunel fold -> (if (connectsT city1 city2 tunel) then delayT tunel else 0) + fold) 0 tunels
availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg citys links tunels) city1 city2 = foldr ((\link fold -> if (linksL city1 city2 link)then ( capacityL link - (capacidadUsada link (Reg citys links tunels) )) else 0 ) + fold) 0 links
