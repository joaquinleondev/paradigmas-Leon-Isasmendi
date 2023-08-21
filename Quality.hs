module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ name tuneles delay = Qua name tuneles delay
capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
capacityQ ( Qua name tuneles delay) = tuneles
delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ ( Qua name tuneles delay) = delay