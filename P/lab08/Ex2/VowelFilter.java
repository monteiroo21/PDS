public class VowelFilter extends FilterDecorator {
    public VowelFilter(FilterInterface filterInterface) {
        super(filterInterface);
    }

    @Override
    public String next() {
        String vowellessText = "";
        while (super.hasNext()) {
            vowellessText += super.next().replaceAll("[aeiouAEIOU]", "") + " ";
        }
        return vowellessText;
    }    
}
