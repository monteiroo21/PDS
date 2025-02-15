import java.util.ArrayList;
import java.util.List;

public class Insurance {
    List<Person> Iregists;

    public Insurance() {
        Iregists = new ArrayList<Person>();
    }

    public void regist(Person person) {
        if (!Iregists.contains(person)) {
            Iregists.add(person);
        }
    }

    public List<Person> insurance() {
        return Iregists;
    }
}
