
public class ChocolateCakeBuilder implements CakeBuilder {
    private Cake chocolateCake;

    public void setCakeShape(Shape shape) {
        chocolateCake.setShape(shape);
    }

    public void addCakeLayer() {
        chocolateCake.addLayer();
    }

    public void addCreamLayer() {
        chocolateCake.setMidLayerCream(Cream.Null);
    }

    public void addTopLayer() {
        chocolateCake.setTopLayerCream(Cream.Whipped_Cream);
    }

    public void addTopping() {
        chocolateCake.setTopping(Topping.Fruit);
    }

    public void addMessage(String message) {
        chocolateCake.setMessage(message);
    }

    public void createCake() {
        chocolateCake = new Cake("Soft Chocolate");
    }

    public Cake getCake() {
        return chocolateCake;
    }
}
