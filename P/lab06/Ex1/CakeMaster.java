public class CakeMaster {
    private CakeBuilder cakeBuilder;

    public void setCakeBuilder(CakeBuilder cakeBuilder) {
        this.cakeBuilder = cakeBuilder;
    }

    public void createCake(String message) {
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(Shape.Circle);
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.addMessage(message);
    }

    public void createCake(Shape shape, int numCakeLayers, String message) {
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(shape);

        if (numCakeLayers > 1) {
            for (int i = 1; i < numCakeLayers; i++) {
                cakeBuilder.addCakeLayer();
            }
            cakeBuilder.addCreamLayer();
        }
        cakeBuilder.addCreamLayer();
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.addMessage(message);
    }

    public void createCake(int numCakeLayers, String message) {
        cakeBuilder.createCake();
        if (numCakeLayers > 1) {
            for (int i = 1; i < numCakeLayers; i++) {
                cakeBuilder.addCakeLayer();
            }
            cakeBuilder.addCreamLayer();
        }
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.addMessage(message);
    }

    public Cake getCake() {
        return cakeBuilder.getCake();
    }
}
