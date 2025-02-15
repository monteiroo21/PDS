import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ProductsReaderFromTXTFile implements ReadProducts {
    private List<Product> products;

    public ProductsReaderFromTXTFile(String filename) throws FileNotFoundException {
        products = new ArrayList<Product>();
        Scanner sc = new Scanner(new File(filename));
        while (sc.hasNextLine()) {
            String[] parts = sc.nextLine().split(",");
            String type = parts[0];
            String code = parts[1];
            String description = parts[2];
            Double points = Double.parseDouble(parts[3]);
            Product p = null;
            switch(type) {
                case "Car":
                    p = new Car(code, description, points);
                    break;
                case "Van":
                    p = new Van(code, description, points);
                    break;
                case "Motorcycle":
                    p = new Motorcycle(code, description, points);
                    break;
                default:
                    break;
            }
            products.add(p);
        }
        sc.close();
    }

    public List<Product> getProducts() {
        return products;
    } 
}
