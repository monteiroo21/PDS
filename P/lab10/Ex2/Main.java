public class Main {
    public static void main(String[] args) {
        BurguerChef burguerChef = new BurguerChef(FoodType.BURGUER);
        PastaChef pastaChef = new PastaChef(FoodType.PASTA);
        PizzaChef pizzaChef = new PizzaChef(FoodType.PIZZA);
        SushiChef sushiChef = new SushiChef(FoodType.SUSHI);
        DessertChef dessertChef = new DessertChef(FoodType.DESSERT);

        sushiChef.setNext(pastaChef);
        pastaChef.setNext(burguerChef);
        burguerChef.setNext(pizzaChef);
        pizzaChef.setNext(dessertChef);

        FoodItem veggieBurger = new FoodItem("veggie burger", FoodType.BURGUER);
        FoodItem pastaCarbonara = new FoodItem("Pasta Carbonara", FoodType.PASTA);
        FoodItem plainPizza = new FoodItem("PLAIN pizza, no toppings!", FoodType.PIZZA);
        FoodItem sushiOrder = new FoodItem("sushi nigiri and sashimi", FoodType.SUSHI);
        FoodItem saladTuna = new FoodItem("salad with tuna", null);
        FoodItem dessert = new FoodItem("strawberry ice cream and waffles dessert", FoodType.DESSERT);

        System.out.println("Can I please get a veggie burger?");
        sushiChef.handleRequest(veggieBurger);
        System.out.println("\nCan I please get a Pasta Carbonara?");
        sushiChef.handleRequest(pastaCarbonara);
        System.out.println("\nCan I please get a PLAIN pizza, no toppings!?");
        sushiChef.handleRequest(plainPizza);
        System.out.println("\nCan I please get a sushi nigiri and sashimi?");
        sushiChef.handleRequest(sushiOrder);
        System.out.println("\nCan I please get a salad with tuna?");
        sushiChef.handleRequest(saladTuna);
        System.out.println("\nCan I please get a strawberry ice cream and waffles dessert?");
        sushiChef.handleRequest(dessert);
        
    }
}
