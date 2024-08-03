import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class BattleField {
    
    public static boolean fieldValidator(int[][] field) {
   HashMap<Integer, Integer> result = new HashMap<>();
        result.put(1, 0);
        result.put(2, 0);
        result.put(3, 0);
        result.put(4, 0);
        Hashtable<String, Boolean> visit = new Hashtable<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (visit.containsKey(String.format("[%d,%d]", i, j))) {
                    continue;
                }
                int count = checkNode(i, j, field, visit);
                if (count > 0 && result.containsKey(count)) {
                    result.put(count, result.get(count) + 1);
                }
            }
        }
        if(result.get(1) == 4 && result.get(2) == 3 && result.get(3) == 2 && result.get(4) == 1) return true;
        return false;
    }

    public static int checkNode(int i, int j, int[][] array, Hashtable<String, Boolean> visit) {
        if (array[i][j] != 1) {
            return 0;
        }

        // Check for diagonal adjacency which is not allowed
        if (hasDiagonalAdjacency(i, j, array)) {
            return 0;
        }

        visit.put(String.format("[%d,%d]", i, j), true);
        int count = 1;
        int x = i, y = j;

        // Check horizontal ship
        while (y + 1 < 10 && array[x][y + 1] == 1) {
            y++;
            if (visit.containsKey(String.format("[%d,%d]", x, y))) {
                break;
            }
            visit.put(String.format("[%d,%d]", x, y), true);
            count++;
        }

        // Check vertical ship only if count is still 1 (i.e., no horizontal ship was found)
        if (count == 1) {
            while (x + 1 < 10 && array[x + 1][y] == 1) {
                x++;
                if (visit.containsKey(String.format("[%d,%d]", x, y))) {
                    break;
                }
                visit.put(String.format("[%d,%d]", x, y), true);
                count++;
            }
        }

        return count;
    }

    private static boolean hasDiagonalAdjacency(int i, int j, int[][] array) {
        int[][] directions = {
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < 10 && y >= 0 && y < 10 && array[x][y] == 1) {
                return true;
            }
        }
        return false;
    }
}