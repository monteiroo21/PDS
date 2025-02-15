public class MobilePhone {
    private String processor;
    private double price;
    private int memory;
    private int camera;
    private String brand;

    public MobilePhone(String processor, double price, int memory, int camera, String brand) {
        this.processor = processor;
        this.price = price;
        this.memory = memory;
        this.camera = camera;
        this.brand = brand;
    }

    public String getProcessor() {
        return processor;
    }

    public double getPrice() {
        return price;
    }

    public int getMemory() {
        return memory;
    }

    public int getCamera() {
        return camera;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "MobilePhone: " + brand + " with " + processor + " processor, " + memory + "GB memory, " + camera
                + "MP camera, and price of " + price + "€";
    }
}
