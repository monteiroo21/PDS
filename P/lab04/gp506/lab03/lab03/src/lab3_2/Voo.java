import java.lang.Comparable;
public class Voo implements Comparable {
    private String code;

    private Voo(String code){
        this.code=code;
    }

    public static Voo criarVoo(String code){
        return  new Voo(code);
    }

    @Override
    public int compareTo(Object a) {
        int valorA=0;
        int valorThis=0;
        String codeA=((Voo)a).getCode();
        for (int i =0;i< code.length();i++){
            valorA+=codeA.charAt(i);
        }
        for (int i =0;i< this.getCode().length();i++){
            valorThis+=this.getCode().charAt(i);
        }


        
        return valorThis - valorA;
        
    }


    public String getCode() {
        return this.code;
    }

}