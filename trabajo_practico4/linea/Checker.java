package linea;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Checker {
    public boolean isFinished(ArrayList<ArrayList<Character>> gameTable) {

        AtomicBoolean isFinished = new AtomicBoolean(false);
        gameTable.forEach(column -> {
            if (column.size() < 4) {
                return;
            }
            for (int i = 0; i < column.size() - 3; i++) {
                Character toCheck = column.get(i);
                for (int j = 1; j < 4; j++) {
                    if (!toCheck.equals(column.get(i + j))) {
                        break;
                    }
                    isFinished.set(true);
                }
            }
        });
        return isFinished.get();
    }
}
