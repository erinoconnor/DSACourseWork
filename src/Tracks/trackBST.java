
package Tracks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * Class for a binary search tree that stores Song objects.
 *
 * @author Erin O'Connor
 *
 */
public class trackBST
        implements SearchTree {

    /**
     * Return value from the public add method.
     */
    protected boolean addReturn;

    /*<listing chapter="6" number="1">*/
    /**
     * Class to encapsulate a tree node.
     *
     */
    protected static class Node implements Serializable {
        // Data Fields

        /**
         * The information stored in this node.
         */
        public Song data;
        /**
         * Reference to the left child.
         */
        public Node left;
        /**
         * Reference to the right child.
         */
        public Node right;

        // Constructors
        /**
         * Construct a node with given data and no children.
         *
         * @param data The data to store in this node
         */
        public Node(Song data) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods
        /**
         * Returns a string representation of the node.
         *
         * @return A string representation of the data fields
         */
        @Override
        public String toString() {
            return data.toString();
        }
    }

    /**
     * The root of the binary tree
     */
    protected Node root;

    /**
     * Construct an empty BinaryTree
     */
    public trackBST() {
        root = null;
    }

    /**
     * Construct a BinaryTree with a specified root. Should only be used by
     * subclasses.
     *
     * @param root The node that is the root of the tree.
     */
    protected trackBST(Node root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root,leftTree as its left
     * subtree and rightTree as its right subtree.
     *
     * @param data Song
     * @param leftTree Left side of tree
     * @param rightTree Right side of tree
     */
    public trackBST(Song data, trackBST leftTree, trackBST rightTree) {
        root = new Node(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    /**
     * Starter method add.
     *
     * @param item The object being inserted
     * @return true if the object is inserted, false if the object already
     * exists in the tree
     */
    @Override
    public boolean add(Song item) {
        root = add(root, item);
        return addReturn;
    }

    /**
     * Recursive add method.
     *
     * @post The data field addReturn is set true if the item is added to the
     * tree, false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the inserted item
     */
    private Node add(Node localRoot, Song item) {
        if (localRoot == null) {
            // item is not in the tree � insert it.
            addReturn = true;
            return new Node(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    /**
     * Loads text file of songs by reading each line and creating new song
     * objects and then adding them to the bst
     *
     * @return bst Return the bst full of tracks
     * @throws SQLException
     */
    public trackBST load() throws SQLException {
        final char DELIMITER = ',';
        trackBST bst = new trackBST();

        try (BufferedReader br = new BufferedReader(new FileReader("src/Tracks/songs.txt"))) {
            String[] temp;
            String line = br.readLine();
            while (line != null) {
                temp = line.split(Character.toString(DELIMITER));
                int id = Integer.parseInt(temp[0]);
                String title = stripQuotes(temp[1]);
                String artistname = stripQuotes(temp[2]);
                int length = Integer.parseInt(temp[3]);
                String composerName = stripQuotes(temp[4]);
                String releasedate = stripQuotes(temp[5]);
                String album = stripQuotes(temp[6]);
                String genre = stripQuotes(temp[7]);

                Song song = new Song(id, title, artistname, length, composerName, releasedate, album, genre);

                bst.add(song);

                line = br.readLine();

            }
            br.close();
        } catch (IOException ex) {

        }

        return bst;
    }

    private static String stripQuotes(String str) {
        return str.substring(1, str.length() - 1);
    }

    

    /**
     * Perform and print an in order traversal of tree.
     *
     */
    @Override
    public void printInOrder() {
        printTreeInOrder(root);
    }

    /**
     *
     * @param node
     */
    public void printTreeInOrder(Node node) {
        if (node != null) {
            printTreeInOrder(node.left);
            System.out.println("" + node.data);
            printTreeInOrder(node.right);
        }
    }

}
