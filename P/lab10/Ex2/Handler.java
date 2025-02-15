public interface Handler {
    public boolean handleRequest(FoodItem foodItem);
    public void setNext(Chef nextChef);
}
