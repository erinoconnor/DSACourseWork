package Tracks;

/**
 * Interface to define a search tree
 * @author Erin O'Connor
 **/
public interface SearchTree  {

    /**
     * Inserts item where it belongs in the tree.
     * @param song
     * 
     * @return true If the item is inserted, false if the
     *         item was already in the tree.
     */
    boolean add(Song song);
    
    /**
     * Prints songs in ascending alphabetical order of Artist Name.
     */
    void printInOrder();
    
    

    
}
