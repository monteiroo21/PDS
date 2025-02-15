import java.util.List;
import java.util.ArrayList;

public class ProductsReaderHardcodedProducts implements ReadProducts {
    private List<Product> products;
    private Product[] cars = {
        new Car("ZA11ZB", "Tesla, Grey, 2021", 100),
        new Van("AA22BB", "Chevrolet Chevy, 2020", 180),
        new Motorcycle("ZA33ZB", "Touring, 750, 2022", 85),
        new Car("BB44ZB", "Ford Mustang, Red, 2021", 150), 
    };

    public ProductsReaderHardcodedProducts() {
        products = new ArrayList<Product>();
        for (Product product : cars) {
            products.add(product);
        }
    }

    public List<Product> getProducts() {
        return products;
    } 
}
