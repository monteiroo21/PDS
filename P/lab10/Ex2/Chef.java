import java.util.Random;

public class Chef implements Handler {
    private FoodType supportedFoodType;
    private Chef next = null;
    private static Random random = new Random();

    public Chef(FoodType supportedFoodType) {
        this.supportedFoodType = supportedFoodType;
    }

    @Override
    public boolean handleRequest(FoodItem foodItem) {
        if (foodItem.getType() == supportedFoodType) {
            System.out.println(this.getClass().getSimpleName() + ": Starting to cook " + foodItem.getDescription() + ". Out in " + this.getCookingTime() + " minutes!");
            return true;
        } else if (next != null) {
            System.out.println(this.getClass().getSimpleName() + ": I can't cook that.");
            return next.handleRequest(foodItem);
        }
        System.out.println("We're sorry but that request can't be satisfied by our service!");
        return false;
    }

    public int getCookingTime() {
        return 5 + random.nextInt(15);
    }

    @Override 
    public void setNext(Chef nextChef) {
        this.next = nextChef;
    }
}
