package Part2_Hobby;

import java.util.Calendar;

class ComputerGame {

    //name
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //genre
    private String genre;
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    //engine
    private String engine;
    public String getEngine() {
        return engine;
    }
    public void setEngine(String engine) {
        this.engine = engine;
    }

    //releaseYear
    private int releaseYear;
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    //Constructor
    public ComputerGame(String name, String genre, String engine, int releaseYear){
        this.name = name;
        this.genre = genre;
        this.engine = engine;
        this.releaseYear = releaseYear;
    }

    public int getGameAge(){
        return Calendar.getInstance().get(Calendar.YEAR) - releaseYear;
    }

    public void printInfo(){
        System.out.printf("Name : %s\nGenre : %s\nEngine : %s\nRelease year %d\nAge %d", name, genre, engine, releaseYear,getGameAge());
    }
}
public class Part2_Hobby {
    public static void main(String[] args) {
        ComputerGame cg1 = new ComputerGame("CS 1.6", "Shooter", "Source", 2003 );
        cg1.printInfo();
    }
}
