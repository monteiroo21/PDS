import java.awt.Color;

public class Ex3 {
    static int CANVAS_SIZE = 1200;
    static int STARS_TO_DRAW = 1000000;

    public static void main(String[] args) {
        Sky sky = new Sky();
        StarFactory starFactory = new StarFactory();

        char[] starTypes = { 'O', 'B', 'A', 'F', 'G', 'K', 'M' };
        char type;

        Runtime runtime = Runtime.getRuntime();
        long before = runtime.totalMemory() - runtime.freeMemory();

        for (int i = 0; i < STARS_TO_DRAW; i++) {
            type = starTypes[random(0, starTypes.length - 1)];
            sky.placeStar(starFactory.createStar(type));
        }
        sky.setSize(CANVAS_SIZE, CANVAS_SIZE);
        sky.setBackground(Color.BLACK);
        sky.setVisible(true);

        long after = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory: " + (after - before) / 1024 / 1024 + " MB");
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
