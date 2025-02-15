public class YogurtCakeBuilder implements CakeBuilder {
    private Cake yogurtCake;

    public void setCakeShape(Shape shape) {
        yogurtCake.setShape(shape);
    }

    public void addCakeLayer() {
        yogurtCake.addLayer();
    }

    public void addCreamLayer() {
        yogurtCake.setMidLayerCream(Cream.Vanilla);
    }

    public void addTopLayer() {
        yogurtCake.setTopLayerCream(Cream.Red_Berries);
    }

    public void addTopping() {
        yogurtCake.setTopping(Topping.Fruit);
    }

    public void addMessage(String message) {
        yogurtCake.setMessage(message);
    }

    public void createCake() {
        yogurtCake = new Cake("Yogurt");
    }

    public Cake getCake() {
        return yogurtCake;
    }
}
