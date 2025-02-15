import java.util.List;
import java.util.ArrayList;

public class SocialSecurity {
    List<Person> SSregists;

    public SocialSecurity() {
        SSregists = new ArrayList<Person>();
    }

    public void regist(Person person) {
        if (!SSregists.contains(person)) {
            SSregists.add(person);
        }
    }

    public List<Person> socialSecurity() {
        return SSregists;
    }
}
