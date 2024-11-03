package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
      assertEquals("Height of an empty tree should be 0", 0, bst.height());
    }

    @Test
    public void testHeightSingleElement() {
      bst.add(10);
      assertEquals("Height of a tree with one element should be 1", 1, bst.height());
    }
    
    @Test
    public void testHeightMutiple() {
      bst.add(3);
      bst.add(4);
      bst.add(5);
      assertEquals("Height of tree with 3 elements should be 3", 3, bst.height());
    }

    @Test
    public void testHeightLeftSkewedTree() {
      bst.add(10);
      bst.add(8);
      bst.add(6);
      bst.add(4);
      bst.add(2);
      assertEquals("Height of a left-skewed tree with 5 elements should be 5", 5, bst.height());
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
    
    @Test
    public void testMinimumEmptyTree() {
      assertNull("Minimum of an empty tree should be null", bst.minimum());
    }

    @Test
    public void testMaximumEmptyTree() {
      assertNull("Maximum of an empty tree should be null", bst.maximum());
    }

    @Test
    public void testMinimumSingleElement() {
      bst.add(10);
      assertEquals("Minimum of a tree with one element should be that element", Integer.valueOf(10), bst.minimum());
    }

    @Test
    public void testMaximumSingleElement() {
      bst.add(10);
      assertEquals("Maximum of a tree with one element should be that element", Integer.valueOf(10), bst.maximum());
    }

    @Test
    public void testMinimumMultipleElements() {
      bst.add(10);
      bst.add(5);
      bst.add(15);
      bst.add(3);
      bst.add(7);
      bst.add(12);
      bst.add(18);

      assertEquals("Minimum of the tree should be 3", Integer.valueOf(3), bst.minimum());
    }

    @Test
    public void testMaximumMultipleElements() {
      bst.add(10);
      bst.add(5);
      bst.add(15);
      bst.add(3);
      bst.add(7);
      bst.add(12);
      bst.add(18);

      assertEquals("Maximum of the tree should be 18", Integer.valueOf(18), bst.maximum());
    }

    @Test
    public void testMinimumRightSkewedTree() {
      bst.add(2);
      bst.add(4);
      bst.add(6);
      bst.add(8);
      bst.add(10);

      assertEquals("Minimum of a right-skewed tree should be the first element added", Integer.valueOf(2), bst.minimum());
    }

    @Test
    public void testMaximumLeftSkewedTree() {
      bst.add(10);
      bst.add(8);
      bst.add(6);
      bst.add(4);
      bst.add(2);

      assertEquals("Maximum of a left-skewed tree should be the first element added", Integer.valueOf(10), bst.maximum());
    }
    
    @Test
    public void testPreOrderEmptyTree() {
      assertEquals("Pre-order traversal of an empty tree should be an empty string", "[]", bst.preOrder());
    }
    
    @Test
    public void testPreOrderSingleElement() {
      bst.add(10);
      assertEquals("Pre-order traversal of a tree with one element should be '10'", "[10]", bst.preOrder());
    }
    
    @Test
    public void testPreOrderMultipleElements() {
      bst.add(10);
      bst.add(5);
      bst.add(15);
      bst.add(3);
      bst.add(7);
      bst.add(12);
      bst.add(18);

      assertEquals("Pre-order traversal should be '10 5 3 7 15 12 18'", "[10 5 3 7 15 12 18]", bst.preOrder());
    }
    
    @Test
    public void testPreOrderSkewedTree() {
      bst.add(1);
      bst.add(2);
      bst.add(3);
      bst.add(4);
      bst.add(5);

      assertEquals("Pre-order traversal of a right-skewed tree should be '1 2 3 4 5'", "[1 2 3 4 5]", bst.preOrder());
    }
    
    @Test
    public void testInOrderEmptyTree() {
      assertEquals("In-order traversal of an empty tree should be an empty string", "[]", bst.inOrder());
    }
    
    @Test
    public void testInOrderSingleElement() {
      bst.add(10);
      assertEquals("In-order traversal of a tree with one element should be '10'", "[10]", bst.inOrder());
    }
    
    @Test
    public void testInOrderMultipleElements() {
      bst.add(10);
      bst.add(5);
      bst.add(15);
      bst.add(3);
      bst.add(7);
      bst.add(12);
      bst.add(18);

      assertEquals("In-order traversal should be '3 5 7 10 12 15 18'", "[3 5 7 10 12 15 18]", bst.inOrder());
    }
    
    @Test
    public void testInOrderSkewedTree() {
      bst.add(1);
      bst.add(2);
      bst.add(3);
      bst.add(4);
      bst.add(5);

      assertEquals("In-order traversal of a right-skewed tree should be '1 2 3 4 5'", "[1 2 3 4 5]", bst.inOrder());
    }
    
    @Test
    public void testPostOrderEmptyTree() {
      assertEquals("Post-order traversal of an empty tree should be an empty string", "[]", bst.postOrder());
    }
    
    @Test
    public void testPostOrderSingleElement() {
      bst.add(10);
      assertEquals("Post-order traversal of a tree with one element should be '10'", "[10]", bst.postOrder());
    }
    
    @Test
    public void testPostOrderMultipleElements() {
      bst.add(10);
      bst.add(5);
      bst.add(15);
      bst.add(3);
      bst.add(7);
      bst.add(12);
      bst.add(18);

      assertEquals("Post-order traversal should be '3 7 5 12 18 15 10'", "[3 7 5 12 18 15 10]", bst.postOrder());
    }
    
    @Test
    public void testPostOrderSkewedTree() {
      bst.add(1);
      bst.add(2);
      bst.add(3);
      bst.add(4);
      bst.add(5);

      assertEquals("Post-order traversal of a right-skewed tree should be '[5 4 3 2 1]'", "[5 4 3 2 1]", bst.postOrder());
    }
}
