public class Cake {
    private Shape shape = Shape.Circle;
    private String cakeLayer;
    private int numCakeLayers = 1;
    private Cream midLayerCream = Cream.Null;
    private Cream topLayerCream = Cream.Null;
    private Topping topping = Topping.Null;
    private String message = "";

    public Cake(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return this.shape;
    }

    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addLayer() {
        this.numCakeLayers++;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.cakeLayer + " cake with " + this.numCakeLayers + " layers");
        if (this.midLayerCream != Cream.Null) {
            sb.append(" and " + this.midLayerCream + " cream");
        }

        if (this.topLayerCream != Cream.Null) {
            sb.append(", topped with " + this.topLayerCream + " cream");
        }

        if (this.topping != Topping.Null) {
            sb.append(" and " + this.topping + ".");
        }

        if (!this.message.isEmpty()) {
            sb.append(" Message says: " + "\"" + this.message + "\"" + ".");
        }

        return sb.toString();
    }
}
