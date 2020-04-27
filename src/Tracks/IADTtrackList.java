/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tracks;

/**
 *
 * @author erino
 */
public interface IADTtrackList<Song> {

    /*
    * Add object to head node in List
     */
    public void add(Song e);

    /*
    * display a List on screen
     */
    public void printList();

 
}
