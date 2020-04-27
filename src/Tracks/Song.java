/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tracks;

import java.sql.SQLException;

/**
 *
 * @author erino
 */
public class Song {

    static trackList<Song> mylist = new trackList();
     /**
     * Creating 
     */
    private int trackID;
    private String trackTitle;
    private String artistName;
    private int trackLength;
    private String composerName;
    private String releaseDate;
    private String albumName;
    private String genreName;

    /**Declaring song variables
     *
     */
    public Song() {
        this.trackID = 0;
        this.trackTitle = "";
        this.artistName = "";
        this.trackLength = 0;
        this.composerName = "";
        this.releaseDate = "";
        this.albumName = "";
        this.genreName = "";
    }

    /** Constructor for song
     *
     * @param id
     * @param title
     * @param artist
     * @param length
     * @param composer
     * @param date
     * @param album
     * @param genre
     * @throws SQLException
     */
    public Song(int id, String title, String artist, int length, String composer, String date, String album, String genre) throws SQLException {

        this.trackID = id;
        this.trackTitle = title;
        this.artistName = artist;
        this.trackLength = length;
        this.composerName = composer;
        this.releaseDate = date;
        this.albumName = album;
        this.genreName = genre;
    }

    /** Get id of track
     *
     * @return track id
     */
    public int getTrackId() {
        return this.trackID;
    }

    /** Get title of track
     *
     * @return track title
     */
    public String getTrackTitle() {
        return this.trackTitle;
    }

    /** Get artist name for track
     *
     * @return artist name
     */
    public String getArtistName() {
        return this.artistName;
    }

    /** Get track length
     *
     * @return track length
     */
    public int getTrackLength() {
        return this.trackLength;
    }

    /** Get composer name
     *
     * @return composer name
     */
    public String getComposerName() {
        return this.composerName;
    }

    /** Get release date
     *
     * @return release date
     */
    public String getReleaseDate() {
        return this.releaseDate;
    }

    /** Get album name
     *
     * @return album name
     */
    public String getAlbumName() {
        return this.albumName;
    }

    /** Get genre name
     *
     * @return genre 
     */
    public String getGenreName() {
        return this.genreName;
    }

    /** Set track id
     *
     * @param id Track id to be set
     */
    public void setTrackId(int id) {
        this.trackID = id;
    }

    /** Set track title
     *
     * @param title Track title to be set
     */
    public void setTrackTitle(String title) {
        this.trackTitle = title;
    }

    /** Set Artist name
     *
     * @param artist Artist name to be set
     */
    public void setArtistName(String artist) {
        this.artistName = artist;
    }

    /** Set track length
     *
     * @param length Track length to be set
     */
    public void setTrackLength(int length) {
        this.trackLength = length;
    }

    /** Set composer name
     *
     * @param composer Composer name to be set
     */
    public void setComposerName(String composer) {
        this.composerName = composer;
    }

    /** Set release date
     *
     * @param release Release date to be set
     */
    public void setReleaseDate(String release) {
        this.releaseDate = release;
    }

    /** Set album name
     *
     * @param album
     */
    public void setAlbumName(String album) {
        this.albumName = album;
    }

    /** Set genre
     *
     * @param genre Genre to be set
     */
    public void setGenreName(String genre) {
        this.genreName = genre;
    }

    /** Add song to linked list
     *
     * @param song Song to be inserted
     */
    static public void addSong(Song song) {
        mylist.add(song);

    }
    
     /**
     * Display all songs in list
     */
     static public void displaySongs() {
        mylist.printList();

    }

    /**Ensures songs added have a unique id.
     *
     * @param id Id to be checked for uniqueness
     * @param unique Will be true or false if the id is unique.
     * @return
     */
    static public Boolean checkIdUnique(int id, Boolean unique) {
        for (Song song : mylist) {
            if (song.trackID == id) {
                unique = false;
                 System.out.println("This id already belongs to a song, please choose another");
                return unique;
            }
        }
        unique = true;
        return unique;
    }
/**
     * Returns songs in list with specified artist name
     *
     * @param name The artist name being searched for.
     * @return Song that matches this name will be returned, otherwise if no match null will be returned
     */
    static public Song findByName(String name) {
        for (Song song : mylist) {
            if (song.artistName.equals(name)) {
               
                return song;
            }
        }
        
        return null;
    }

    
 
/**
     * Prints songs in list with specified artist name
     *
     * @param title The title name of song being searched for.
     */
    static public Song findByTitle(String title) {
        for (Song song : mylist) {
            if (song.trackTitle.equals(title)) {
                return song;
               
              
            }
        }
       return null;
     
        }
    
/**
     * Prints multiple songs in list with specified genre name
     *
     * @param genre The genre of song being searched for.
     */
    static public void findByGenre(String genre) {
        boolean found = false;
        int count = 0;
        for (Song song : mylist) {
            if (song.genreName.equals(genre)) {

                System.out.println(song);
                found = true;
                count++;
            } else {
                found = false;

            }
        }
        if (found == true) {
            System.out.println("Found " + count + " songs with " + genre + " genre");
        } else if (found == false) {
            System.out.println("Couldn't find song any songs with this genre");
        }

    }

   /**
     * Compares songs based on artist name
     *
     * @param song The song to be compared.
     * @return The integer compare value is returned which is either -1, 0 or 1+
     */
     public int compareTo(Song song){
    return this.artistName.compareTo(song.getArtistName());
}
 
   
/**
     * Formats the song objects
     *
     * @return Formatted song
     */
    @Override
    public String toString() {
        return "Track ID: " +Integer.toString(trackID) + ", Track title: " + trackTitle + ", Artist Name: " + artistName + ", Track Length: " + trackLength + "s, Composer Name: "
                + composerName + ", Release Date: " + releaseDate + ", Album Name: " + albumName + ", Genre: " + genreName;

    }
}
