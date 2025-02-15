public class CapitalizationFilter extends FilterDecorator {
    public CapitalizationFilter(FilterInterface filterInterface) {
        super(filterInterface);
    }

    @Override
    public String next() {
        String capitalText = "";
        String[] words = super.next().split(" ");
        for (String word : words) {
            if (word.length() <= 2) {
                capitalText += word.toUpperCase() + " ";
            } else {
                if (word.matches(".*[\\p{Punct}].*")) {
                    capitalText += Character.toUpperCase(word.charAt(0)) + word.substring(1, word.length()-2) + Character.toUpperCase(word.charAt(word.length()-2)) + word.charAt(word.length()-1) + " ";
                } else {
                    capitalText += Character.toUpperCase(word.charAt(0)) + word.substring(1, word.length()-1) + Character.toUpperCase(word.charAt(word.length()-1)) + " ";
                }    
            }
        }
        return capitalText;
    }
}
