import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class ToShare implements Iterable<Product> {
    private List<Product> products;
    private Map<Product, Client> shared;
    private ReadProducts productsReader;

    public ToShare() {
        products = new ArrayList<Product>();
        shared = new HashMap<Product, Client>();
    }

    public boolean add(Product product) {
        if (products.add(product)) {
            return true;
        }
        return false;
    }

    public Product remove(String code) {
        for (Product p : products) {
            if (p.code().equals(code)) {
                products.remove(p);
                return p;
            }
        }
        return null;
    }

    public boolean share(String code, Client user) {
        for (Product product : products) {
            if (product.code().equals(code)) {
                if (shared.get(product) == null) {
                    shared.put(product, user);
                    return true;
                } 
                product.addObserver(user);
                return false;
            }
        }
        return false;
    }

    public boolean share(Product product, Client user) {
        if (shared.get(product) == null) {
            shared.put(product, user);
            return true;
        }
        return false;
    }

    public boolean giveBack(String code) {
        for (Product product : products) {
            if (product.code().equals(code)) {
                if (shared.get(product) != null) {
                    Client client = shared.get(product);
                    shared.remove(product, client);
                    notifyObservers(product);
                    if (product.getObservers() != null && !product.getObservers().isEmpty()) {
                        Client c = product.getObservers().get(0);
                        product.getObservers().remove(0);
                        share(product, c);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void notifyObservers(Product product) {
        for (Client client : product.getObservers()) {
            System.out.println(client.getName() + ", " + product.description() + " has been given back");
        }
    }

    public boolean giveBack(Product product) {
        if (shared.get(product) != null) {
            Client client = shared.get(product);
            shared.remove(product, client);
            return true;
        }
        return false;
    }

    public String sharedProducts() {
        String value = "";
        value += "Total : " + shared.size() + "\n";
        for (Product product : shared.keySet()) {
            value += "\t" + product.toString() + "\n";
        }
        return value;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int totalProducts() {
        return products.size();
    }

    public int totalSharedProducts() {
        return shared.size();
    }

    public void setProductsReader(ReadProducts productsReader) {
        this.productsReader = productsReader;
    }

    public void importProductsFromProductsReader() {
        for (Product product : this.productsReader.getProducts()) {
            products.add(product);
        }
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
