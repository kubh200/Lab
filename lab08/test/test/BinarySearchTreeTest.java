package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import bst.BinarySearchTree;
import bst.BinarySearchTreeImpl;

public class BinarySearchTreeTest {

	private BinarySearchTree<Integer> bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTreeImpl<>(); 
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
    
    @Test
    public void testHeightEmptyTree() {
      assertEquals("Height of an empty tree should be -1", -1, bst.height());
    }

    @Test
    public void testHeightSingleElement() {
      bst.add(10);
      assertEquals("Height of a tree with one element should be 0", 0, bst.height());
    }

    @Test
    public void testHeightLeftSkewedTree() {
      bst.add(10);
      bst.add(8);
      bst.add(6);
      bst.add(4);
      bst.add(2);
      assertEquals("Height of a left-skewed tree with 5 elements should be 4", 4, bst.height());
    }
    
    @Test
    public void testPresentInEmptyTree() {
      assertFalse("The value should not be found in an empty tree", bst.present(10));
    }

    @Test
    public void testPresentSingleElementFound() {
      bst.add(10);
      assertTrue("The value 10 should be present in the tree", bst.present(10));
    }

    @Test
    public void testPresentSingleElementNotFound() {
      bst.add(10);
      assertFalse("The value 5 should not be present in the tree", bst.present(5));
    }

    @Test
    public void testPresentMultipleElementsFound() {
      bst.add(10);
      bst.add(5);
      bst.add(15);
      bst.add(3);
      bst.add(7);
      bst.add(12);
      bst.add(18);

      assertTrue("The value 5 should be present in the tree", bst.present(5));
      assertTrue("The value 15 should be present in the tree", bst.present(15));
      assertTrue("The value 3 should be present in the tree", bst.present(3));
      assertTrue("The value 18 should be present in the tree", bst.present(18));
    }

    @Test
    public void testPresentMultipleElementsNotFound() {
      bst.add(10);
      bst.add(5);
      bst.add(15);
      bst.add(3);
      bst.add(7);
      bst.add(12);
      bst.add(18);

      assertFalse("The value 6 should not be present in the tree", bst.present(6));
      assertFalse("The value 20 should not be present in the tree", bst.present(20));
      assertFalse("The value 0 should not be present in the tree", bst.present(0));
    }

    @Test
    public void testPresentEdgeValues() {
      bst.add(10);
      bst.add(5);
      bst.add(15);
      bst.add(3);
      bst.add(7);
      bst.add(12);
      bst.add(18);

      assertTrue("The minimum value 3 should be present in the tree", bst.present(3));
      assertTrue("The maximum value 18 should be present in the tree", bst.present(18));
    }

}
