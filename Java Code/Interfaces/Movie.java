import java.util.ArrayList;
import java.util.Collections;

public class Movie implements Comparable<Movie> {

    //Instance Variables
    private String title;
    private double stars;
    private int year;

    //Initalise class
    public Movie(String title, double stars){
        this.stars = stars;
        this.title = title;
    }

    //Getters and Setters
    public void setYear(int year) {
        this.year = year;
    }
    public double getStars() {
        return stars;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }

    //Display instance
    public void displayMovie(){
        System.out.println("Title: "+ this.getTitle());
        System.out.println("Stars: "+ this.getStars());
        System.out.println("Year: "+ this.getYear());
        System.out.println("-----------------------");
    }

    //Compare to method requiered by implementing Comparable<Movie>
    public int compareTo(Movie that) {
        return (int) (this.getStars() - that.getStars());
    }

    public static void main(String[] args) {

        //Array list of Movie, to be sorted on stars.
        ArrayList<Movie> movies = new ArrayList<>();

        //Add Movie instances to arraylist
        movies.add(new Movie("Indiana Jones",5.0));
        movies.add( new Movie("Breakfast Club",4.0));
        movies.add( new Movie("Chitty Chitty Bang Bang",2.5));
        movies.add( new Movie("The fox and the hound",3.5));
        movies.add( new Movie("Bambi",1.5));

        //Display unsorted arraylist
        for (Movie movie : movies) {
            movie.displayMovie();
        }

        //Sort arraylist
        Collections.sort(movies);
        System.out.println("=========================");

        //Display sorted arraylist
        for (Movie movie : movies) {
            movie.displayMovie();
        }


    }
    
}
