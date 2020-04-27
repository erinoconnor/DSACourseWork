/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tracks;

import java.sql.SQLException;
import java.util.Scanner;
import java.io.IOException;
import static java.lang.Integer.parseInt;

/**
 *
 * @author erino
 */
class Main {

    public static void main(String[] args) throws SQLException, IOException {
        menu();
      
    }

    public static void menu() throws IOException, SQLException {
        boolean finished = false;
        do {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Enter A: Part 2(Linked list)"
                    + " Enter B: Part 3(BST) Enter C: Test all parts  Q: QUIT");

            String choice = userInput.nextLine();
            if ("a".equalsIgnoreCase(choice) || "A".equalsIgnoreCase(choice)) {
                Part2menu();
            } else if ("b".equalsIgnoreCase(choice) || "B".equalsIgnoreCase(choice)) {
                Part3menu();

            } else if ("c".equalsIgnoreCase(choice) || "C".equalsIgnoreCase(choice)) {

                testPart1();
                testPart2();
                testPart3();
            } else if ("q".equalsIgnoreCase(choice) || "Q".equalsIgnoreCase(choice)) {

                finished = true;
            }
        } while (!finished);
    }

    public static void Part3menu() throws IOException, SQLException {
        boolean finished = false;
        do {
            trackBST aBSTree = new trackBST();
            aBSTree = aBSTree.load();

            Scanner userInput = new Scanner(System.in);
            System.out.println("Do u wish to A: Show songs in ascending artist order"
                    + ", or Q: Return to main menu");

            String choice = userInput.nextLine();
            if ("a".equalsIgnoreCase(choice) || "A".equalsIgnoreCase(choice)) {
                aBSTree.printInOrder();
            }

            if ("q".equalsIgnoreCase(choice) || "Q".equalsIgnoreCase(choice)) {

                finished = true;
                menu();
            }
        } while (!finished);
    }

    public static void Part2menu() throws IOException, SQLException {
        boolean finished = false;
        Boolean unique = false;
        int length = 0;
        boolean isint = false;
        int id = 0;

        do {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Do u wish to A: Add A song to the list"
                    + " B: Search a song by title, C: Search songs by genre, D: Search songs by artist, E: Display all songs, or Q: Return to main menu");

            String choice = userInput.nextLine();

            if ("a".equalsIgnoreCase(choice) || "A".equalsIgnoreCase(choice)) {

                do {
                    try {

                        System.out.println("Enter song id");

                        id = parseInt(userInput.nextLine());
                        unique = Song.checkIdUnique(id, unique);

                    } catch (Exception e) {
                        System.out.println("Please enter a number for id");
                    }
                } while (!unique);

                System.out.println("Enter song title");
                String title = userInput.nextLine();

                System.out.println("Enter artist name");
                String artist = userInput.nextLine();

                do {

                    try {
                        System.out.println("Enter track length in seconds");
                        length = parseInt(userInput.nextLine());
                        isint = true;
                    } catch (Exception e) {
                        System.out.println("Please enter a number for the length in seconds");
                        isint = false;
                    }
                } while (!isint);

                System.out.println("Enter composer name");
                String composer = userInput.nextLine();

                System.out.println("Enter date in format:  00 Month 0000");
                String date = userInput.nextLine();

                System.out.println("Enter album name");
                String album = userInput.nextLine();

                System.out.println("Enter genre");
                String genre = userInput.nextLine();

                Song song = new Song(id, title, artist, length, composer, date, album, genre);

                Song.addSong(song);

                System.out.println("Added new song:" + song);
           
            
            } else if ("b".equalsIgnoreCase(choice) || "B".equalsIgnoreCase(choice)) {
                System.out.println("Enter title to search by");
                String title = userInput.nextLine();

                Song titlesong = Song.findByTitle(title);
                if (titlesong == null) {
                    System.out.println("Couldn't find song ");
                } else {
                    System.out.println("Found song with title name " + title + ":");
                    System.out.println(titlesong);
                }

           
            } else if ("c".equalsIgnoreCase(choice) || "C".equalsIgnoreCase(choice)) {
                System.out.println("Enter Genre to search by");
                String genre = userInput.nextLine();

                Song.findByGenre(genre);
            
            
            } else if ("d".equalsIgnoreCase(choice) || "D".equalsIgnoreCase(choice)) {
                System.out.println("Enter artist to search by");
                String artist = userInput.nextLine();

                Song namesong = Song.findByName(artist);
                if (namesong == null) {
                    System.out.println("Couldn't find song ");
                } else {
                    System.out.println("Found song with artist name " + artist + ":");
                    System.out.println(namesong);
                }

            
            } else if ("e".equalsIgnoreCase(choice) || "E".equalsIgnoreCase(choice)) {
                System.out.println("Printing list");
                Song.displaySongs();

            } else if ("q".equalsIgnoreCase(choice) || "Q".equalsIgnoreCase(choice)) {
                finished = true;
                menu();
            }

        } while (!finished);
    }

    private static void testPart3() throws SQLException {
       System.out.println("Part 3 testing BST:");
        //testing creating new tree
        trackBST aBSTree = new trackBST();

        //testing loading data for tree
        aBSTree = aBSTree.load();
        System.out.println("Print BST in alphabetical order of artist:");
        //testing printing the tree in order
        aBSTree.printInOrder();
      

      

    }

    /**
     * Test Harness for part 2
     *
     */
    public static void testPart2() throws SQLException {
        System.out.println("Part 2 showing list functions work:");
        Song newsong = new Song(1, "Umbrella", "Rihanna", 300, "Michelle", "2010", "Umbrella", "Pop");
        Song newsong2 = new Song(2, "IFHY", "Tyler", 200, "Tyler", "2018", "Cherry Bomb", "Rap");
        Song newsong3 = new Song(3, "Lost", "Frank Ocean", 150, "Frank", "2018", "Chanel Orange", "Rap");
        Song newsong4 = new Song(4, "Nana", "The 1975", 200, "Matty", "2010", "The 1975", "Pop");
        Song newsong5 = new Song(5, "Fade into you", "Mazzy Star", 350, "Mazzy", "2008", "STTIMS", "Pop");

        //Testing adding songs to list
        Song.addSong(newsong);
        Song.addSong(newsong2);
        Song.addSong(newsong3);
        Song.addSong(newsong4);
        Song.addSong(newsong5);
        System.out.println("Printing all songs:");
        //Testing printing all songs
        System.out.println("All songs in list: ");
        Song.displaySongs();

        System.out.println("Search by artist name:");
        //Testing searching list by Artist name
        String searchName = "Rihanna";
        Song namesong = Song.findByName(searchName);
        if (namesong == null) {
            System.out.println("Couldn't find song ");
        } else {
            System.out.println("Found song with artist name " + searchName + ":");
            System.out.println(namesong);
        }

        System.out.println("Search by title:");
        //Testing searching list by Song title
        String searchTitle = "Nana";
        Song titlesong = Song.findByTitle(searchTitle);
        if (titlesong == null) {
            System.out.println("Couldn't find song ");
        } else {
            System.out.println("Found song with title name " + searchTitle + ":");
            System.out.println(titlesong);
        }

        System.out.println("Search by genre:");
        //Testing searching list by genre
        String searchGenre = "Pop";
        Song.findByGenre(searchGenre);

    }

    /**
     * Test Harness for part 1
     *
     */
    public static void testPart1() {
        System.out.println("Part 1 creating song using getters and setters:");

        Song song = new Song();
        // Test by setting values
        song.setTrackId(4);
        song.setTrackTitle("Moon Undah Water");
        song.setArtistName("PumaBlue");
        song.setTrackLength(60);
        song.setComposerName("Adam");
        song.setReleaseDate("2018");
        song.setAlbumName("Single");
        song.setGenreName("PumaBlue");
        System.out.println(song.getTrackId() + " " + song.getTrackTitle() + " " + song.getArtistName() + " " + song.getTrackLength() + " "
                + song.getComposerName() + " " + song.getReleaseDate() + " " + song.getAlbumName() + " " + song.getGenreName());
    }

}
