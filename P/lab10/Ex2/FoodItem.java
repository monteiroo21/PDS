public class FoodItem {
    private String request;
    private FoodType foodType;

    public FoodItem(String request, FoodType foodType) {
        this.request = request;
        this.foodType = foodType;
    }

    public FoodType getType() {
        return foodType;
    }

    public String getDescription() {
        return request;
    }
}
