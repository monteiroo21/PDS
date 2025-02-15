import java.util.HashMap;
import java.util.Map;
import startypesResolution.*;

public class StarFactory {
    private static Map<Character, StarType> starTypes;

    public StarFactory() {
        starTypes = new HashMap<Character, StarType>();
    }

    public Star createStar(Character type) {
        StarType starType = null;

        int x = randomFunction(0, Ex3.CANVAS_SIZE);
        int y = randomFunction(0, Ex3.CANVAS_SIZE);

        if (starTypes.containsKey(type)) {
            starType = starTypes.get(type);
        } else {
            switch (type) {
                case 'O':
                    starType = new OStar(x, y);
                    break;
                case 'B':
                    starType = new BStar(x, y);
                    break;
                case 'A':
                    starType = new AStar(x, y);
                    break;
                case 'F':
                    starType = new FStar(x, y);
                    break;
                case 'G':
                    starType = new GStar(x, y);
                    break;
                case 'K':
                    starType = new KStar(x, y);
                    break;
                case 'M':
                    starType = new MStar(x, y);
                    break;
            }
            starTypes.put(type, starType);
        }

        return new Star(x, y, starType);
    }

    private int randomFunction(int i, int CANVAS_SIZE) {
        return i + (int) (Math.random() * ((CANVAS_SIZE - i) + 1));
    }

}
