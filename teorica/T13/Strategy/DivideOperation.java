public class DivideOperation implements Operation {
    @Override
    public double performOperation(int a, int b) {
        if (b == 0) {
            System.out.println("Can't divide by 0!");
            return 0.0;
        }
        return a / b;
    }
}
