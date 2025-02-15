import java.util.List;

public class Movie {
   private final String title;
   private final int year;
   private final Person director;
   private final Person writer;
   private final String series;
   private final List<Person> cast;
   private final List<Place> locations;
   private final List<String> languages;
   private final List<String> genres;
   private final boolean isTelevision;
   private final boolean isNetflix;
   private final boolean isIndependent;

   private Movie(MovieBuilder builder) {
      this.title = builder.title;
      this.year = builder.year;
      this.director = builder.director;
      this.writer = builder.writer;
      this.series = builder.series;
      this.cast = builder.cast;
      this.locations = builder.locations;
      this.languages = builder.languages;
      this.genres = builder.genres;
      this.isTelevision = builder.isTelevision;
      this.isNetflix = builder.isNetflix;
      this.isIndependent = builder.isIndependent;
  }

   public static class MovieBuilder{
      private String title = null;
      private int year = 0;
      private Person director = null;
      private Person writer = null;
      private String series = null;
      private List<Person> cast = null;
      private List<Place> locations = null;
      private List<String> languages = null;
      private List<String> genres = null;
      private boolean isTelevision = false;
      private boolean isNetflix = false;
      private boolean isIndependent = false;

      public MovieBuilder(String title, int year) {
         this.title = title;
         this.year = year;
      }

      public MovieBuilder setDirector(Person director) {
         this.director = director;
         return this;
      }

      public MovieBuilder setWriter(Person writer) {
         this.writer = writer;
         return this;
      }

      public MovieBuilder setSeries(String series) {
         this.series = series;
         return this;
      }

      public MovieBuilder setCast(List<Person> cast) {
         this.cast = cast;
         return this;
      }

      public MovieBuilder setLocations(List<Place> locations) {
         this.locations = locations;
         return this;
      }

      public MovieBuilder setLanguages(List<String> languages) {
         this.languages = languages;
         return this;
      }

      public MovieBuilder setGenres(List<String> genres) {
         this.genres = genres;
         return this;
      }

      public MovieBuilder setIsTelevision(Boolean isTelevision) {
         this.isTelevision = isTelevision;
         return this;
      }

      public MovieBuilder setIsNetflix(Boolean isNetflix) {
         this.isNetflix = isNetflix;
         return this;
      }

      public MovieBuilder setIsIndependent(Boolean isIndependent) {
         this.isIndependent = isIndependent;
         return this;
      }

      public Movie build() {
         return new Movie(this);
      }
   }

   public String toString() {
      return "Movie Title: " + this.title + "\n" + "\tYear: " + this.year + "\n" +
      "\tDirector: " + this.director + "\n" + "\tWriter: " + this.writer + "\n" +
      "\tSeries: " + this.series + "\n" + "\tCast: " + this.cast + "\n" +
      "\tLocations: " + this.locations + "\n" + "\tLanguages: " + this.languages + "\n" +
      "\tGenres: " + this.genres + "\n" + "\tTelevision: " + this.isTelevision + "\n" +
      "\tNetflix: " + this.isNetflix + "\n" + "\tIndependent: " + this.isIndependent;
   }
}
