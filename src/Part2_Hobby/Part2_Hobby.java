package Part2_Hobby;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Scanner;


class Collection {


    private ArrayList<ComputerGame> collection = new ArrayList<>();

    private int size;

    public int getSize() {
        size = collection.size();
        return size;
    }

    public ArrayList<ComputerGame> getCollection() {
        return collection;
    }

    public void addComputerGame(ComputerGame computergame) {
        collection.add(computergame);
    }

    public void setComputerGame(int i, ComputerGame computergame) {
        collection.set(i,computergame);
    }

    public ComputerGame getComputerGame(int i) {
        return collection.get(i);
    }

    public void printAll() {
        for (int i = 0; i < collection.size(); i++) {
            System.out.printf("Name         : %s\nGenre        : %s\nEngine       : %s\nRelease year : %d\nAge          : %d\n\n", collection.get(i).getName(), collection.get(i).getGenre(), collection.get(i).getEngine(), collection.get(i).getReleaseYear(), collection.get(i).getGameAge());
        }
    }
    public void printOne(int i) {
            System.out.printf("Name         : %s\nGenre        : %s\nEngine       : %s\nRelease year : %d\nAge          : %d\n\n", collection.get(i).getName(), collection.get(i).getGenre(), collection.get(i).getEngine(), collection.get(i).getReleaseYear(), collection.get(i).getGameAge());
    }

    public void sortByYear() {
        boolean isSorted;
        for (int i = 0; i < collection.size() - 1; i++) {
            isSorted = true;
            for (int j = 0; j < (collection.size() - j) - 1; j++) {
                if(collection.get(j).getReleaseYear() > collection.get(j + 1).getReleaseYear()){
                    swap(j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public void swap(int i, int j) {
        ComputerGame temp = collection.get(i);
        collection.set(i, collection.get(j));
        collection.set(j, temp);
    }

    public void find(int op, String str) {
        switch (op){
            case 1:
                for (int i = 0; i < collection.size(); i++) {
                    if(collection.get(i).getName().toUpperCase().contains(str.toUpperCase()) ) {
                        printOne(i);
                    }
                }
                break;
            case 2:
                for (int i = 0; i < collection.size(); i++) {
                    if(collection.get(i).getGenre().toUpperCase().contains(str.toUpperCase()) ) {
                        printOne(i);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < collection.size(); i++) {
                    if(collection.get(i).getEngine().toUpperCase().contains(str.toUpperCase()) ) {
                        printOne(i);
                    }
                }
                break;
            case 4:
                for (int i = 0; i < collection.size(); i++) {
                    String ry = String.valueOf(collection.get(i).getReleaseYear());
                    if(ry.toUpperCase().contains(str.toUpperCase()) ) {
                        printOne(i);
                    }
                }
                break;
        }
    }
}
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

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Collection collection = new Collection();
        ComputerGame cg1 = new ComputerGame("CS 1.6", "Shooter", "Source", 2003);
        ComputerGame cg2 = new ComputerGame("The Witcher 3", "RPG", "REDengine 3", 2015);
        ComputerGame cg3 = new ComputerGame("GTA V", "Action-Adventure", "RAGE", 2013);
        ComputerGame cg4 = new ComputerGame("Cyberpunk 2077", "RPG", "REDengine 4", 2020);

        collection.addComputerGame(cg1);
        System.out.println(collection.getSize());
        collection.addComputerGame(cg2);
        System.out.println(collection.getSize());
        collection.addComputerGame(cg3);
        System.out.println(collection.getSize());
        collection.addComputerGame(cg4);
        System.out.println(collection.getSize());
//        cg1.printInfo();
        collection.printAll();

        collection.printOne(1);

        System.out.println("------------Sorted------------\n");
        collection.sortByYear();
        collection.printAll();

        System.out.println("-------------Find-------------\n");

        System.out.println("Search by " +
                "\n1. Name" +
                "\n2. Genre" +
                "\n3. Engine" +
                "\n4. Release year\n");
        collection.find( 1,"t");

        menu(collection);



    }

    public static int doTryInteger() {
        //integer try
        int userInt = 0;
        boolean doTry = true;
        while (doTry) {
            try {
                userInt = in.nextInt();
                doTry = false;
                break;
            } catch (Exception e) {
                in.nextLine();
            }
        }
        return userInt;
    }
    public static void menu(Collection collection) {
        System.out.println("Welcome to the book database!\n" +
                "Choose an option to proceed:\n" +
                "1 - add computergame to collection\n" +
                "2 - print all computergame\n" +
                "3 - sort computergame by year\n" +
                "4 - search computergame by title\n" +
                "5 - search computergame by year\n" +
                "0 - exit the program");
        int op = doTryInteger();
        switch (op){
            case 1:
                System.out.print("Enter game name: ");
                String name = in.next();
                System.out.print("Enter game genre: ");
                String genre = in.next();
                System.out.print("Enter game engine: ");
                String engine = in.next();
                System.out.print("Enter release year: ");
                int releaseYear = doTryInteger();
                ComputerGame newGame = new ComputerGame(name, genre, engine, releaseYear);
                collection.addComputerGame(newGame);
                System.out.println("Computer game added to the collection.");
                menu(collection);
                break;
            case 2:
                collection.printAll();
                menu(collection);
                break;
            case 3:
                collection.sortByYear();
                System.out.println("Computer games sorted by release year.");
                menu(collection);
                break;
            case 4:
                System.out.print("Enter the title to search for: ");
                String title = in.next();
                collection.find(1, title);
                menu(collection);
                break;
            case 5:
                System.out.print("Enter the release year to search for: ");
                int year = doTryInteger();
                collection.find(4, String.valueOf(year));
                menu(collection);
                break;
            case 0:
                System.out.println("exit");
                break;
            default:
                System.out.println("op null");
                menu(collection);
                break;
        }
    }


}
