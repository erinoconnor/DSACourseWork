/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tracks;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for a Single Linked List that stores Song objects.
 *
 * @author erino
 * @param <Song>
 */
public class trackList<Song> implements IADTtrackList<Song>, Iterable<Song> {

    public Iterator<Song> iterator() {
        if (isEmpty()) {
            return Collections.<Song>emptyList().iterator();
        }
        return new Iterator<Song>() {
            private Node<Song> currentNode = null;

            @Override
            public boolean hasNext() {
                return currentNode != tail;
            }

            @Override
            public Song next() {
                if (currentNode == null) {
                    currentNode = head;
                    return currentNode.element;
                }
                if (currentNode.next == null) {
                    throw new NoSuchElementException();
                }
                currentNode = currentNode.next;
                return currentNode.element;
            }
        };
    }

//create node class with element that points to next
    private static class Node<Song> {

        private Song element;
        private Node<Song> next; //points to next element

        public Node(Song e, Node<Song> n) { //create constructor
            element = e;
            next = n;
        }
//get element

        public Song getElement() {
            return element;
        }
//get next

        public Node<Song> getNext() {
            return next;
        }
//get set next

        public void setNext(Node<Song> n) {
            next = n;
        }

    }

    private Node<Song> head = null;
    private Node<Song> tail = null;
    private int size = 0;

  
    
    
    /** Check if list is empty
     *
     * @return size
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Add a song to the list.
     *
     * @param e Song to be added.
     */
    @Override
    public void add(Song e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;

    }

    /** Print the lise.
     *
     */
    @Override
    public void printList() {
        if (head == null) {
            return;
        }

        Node curr = this.head;
        while (curr != null) {

            System.out.println(curr.element);
            curr = curr.next;
        }
    }

}
