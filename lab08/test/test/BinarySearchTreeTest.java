package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bst.BinarySearchTree;
import bst.BinarySearchTreeImpl;

public class BinarySearchTreeTest {

	private BinarySearchTree<Integer> bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTreeImpl<>(); // Using the interface type
    }

    @Test
    public void testAddSingleElement() {
        bst.add(10);
        assertEquals("Size should be 1 after adding one element", 1, bst.size());
    }

    @Test
    public void testAddMultipleElements() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);

        assertEquals("Size should be 5 after adding five elements", 5, bst.size());
    }

}
