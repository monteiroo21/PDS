public class SpongeCakeBuilder implements CakeBuilder {
    private Cake spongeCake;

    public void setCakeShape(Shape shape) {
        spongeCake.setShape(shape);
    }

    public void addCakeLayer() {
        spongeCake.addLayer();
    }

    public void addCreamLayer() {
        spongeCake.setMidLayerCream(Cream.Red_Berries);
    }

    public void addTopLayer() {
        spongeCake.setTopLayerCream(Cream.Whipped_Cream);
    }

    public void addTopping() {
        spongeCake.setTopping(Topping.Fruit);
    }

    public void addMessage(String message) {
        spongeCake.setMessage(message);
    }

    public void createCake() {
        spongeCake = new Cake("Sponge");
    }

    public Cake getCake() {
        return spongeCake;
    }
}
