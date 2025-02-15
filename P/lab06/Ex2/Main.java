import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Cristopher Nolan");
        Person person2 = new Person("Leonardo DiCaprio");
        Person person3 = new Person("Cillian Murphy");
        Place place1 = new Place("Tokyo");
        Place place2 = new Place("Paris");
        List<Person> cast = new ArrayList<Person>();
        cast.add(person2);
        cast.add(person3);
        List<Place> locations = new ArrayList<Place>();
        locations.add(place1);
        locations.add(place2);
        Movie.MovieBuilder movie = new Movie.MovieBuilder("Inception", 2010);
        movie.setDirector(person1);
        movie.setWriter(person1);
        movie.setSeries("Inception");
        movie.setCast(cast);
        movie.setLocations(locations);
        movie.setIsIndependent(true);
        movie.setIsTelevision(true);
        Movie movieString = movie.build();

        System.out.println(movieString);
    }
}
