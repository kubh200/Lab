package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import polynomial.Polynomial;
import polynomial.PolynomialImpl;


/**
 * This test class checks the functionality of the Polynomial and PolynomialImpl classes.
 */
public class PolynomialTest {

  private Polynomial poly1;
  private Polynomial poly2;
  private Polynomial emptyPoly;
  private Polynomial constantPoly;

  /**
   * Sets up Polynomial objects for testing.
   */
  @Before
  public void setUp() {
    poly1 = new PolynomialImpl("3x^2 +4x^1 -5"); 
    poly2 = new PolynomialImpl("2x^3 -3x^1 +5");
    emptyPoly = new PolynomialImpl();
    constantPoly = new PolynomialImpl("5");
  }
  
  /**
   * Tests adding two polynomials and verifies the result.
   */
  @Test
  public void testAddPolynomials() {
      Polynomial poly1 = new PolynomialImpl("3x^2 +4x^1 -5");
      Polynomial poly2 = new PolynomialImpl("2x^2 -3x^1 +7");

      // Expected result: "5x^2 +1x^1 +2"
      Polynomial result = poly1.add(poly2);
      assertEquals("5x^2 +x^1 +2", result.toString());
  }

  /**
   * Tests adding a polynomial of a different type, expecting an IllegalArgumentException.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testAddDifferentType() {
    Polynomial poly1 = new PolynomialImpl("3x^2 +4x^1 -5");
      
    Polynomial differentPoly = new Polynomial() {
      @Override
      public Polynomial add(Polynomial other) { 
        return null; 
      }
      
      @Override
      public void addTerm(int coefficient, int power) {

      }
      
      @Override
      public boolean isSame(Polynomial poly) { 
        return false; 
      }
      
      @Override
      public double evaluate(double x) { 
        return 0; 
      }
      
      @Override
      public int getCoefficient(int power) { 
        return 0; 
      }
      
      @Override
      public int getDegree() {
        return 0; 
      }
      
      @Override
      public String toString() { 
        return "Dummy"; 
      }
    };
    poly1.add(differentPoly);
  }
  
  /**
   * Tests the addTerm functionality, including adding terms with duplicate powers
   * and adding terms with zero coefficients.
   */
  @Test
  public void testAddTerm() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(3, 2);
    poly.addTerm(4, 1);
    poly.addTerm(-1, 2);  

    assertEquals("2x^2 +4x^1", poly.toString());

    poly.addTerm(0, 2);
    assertEquals("2x^2 +4x^1", poly.toString());

  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidAddTerm() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(5, -1);
  }

  /**
   * Tests the isSame method by comparing polynomials for equality.
   */
  @Test
  public void testIsSame() {
    Polynomial identicalPoly = new PolynomialImpl("3x^2 +4x^1 -5");
    Polynomial differentPoly = new PolynomialImpl("3x^2 +5x^1 -5");

    assertTrue(poly1.isSame(identicalPoly));
    assertFalse(poly1.isSame(differentPoly));
    assertFalse(poly1.isSame(emptyPoly));
  }

  /**
   * Tests the evaluate method by evaluating the polynomial at different values of x.
   */
  @Test
  public void testEvaluate() {
    assertEquals(15.0, poly2.evaluate(2), 0.0001);  
    assertEquals(5.0, poly2.evaluate(0), 0.0001); 
    assertEquals(6.0, poly2.evaluate(-1), 0.0001); 
  }

  /**
   * Tests the getCoefficient method by retrieving coefficients for various powers.
   */
  @Test
  public void testGetCoefficient() {
    Polynomial testPoly = new PolynomialImpl("3x^3 -2x^2 +5x^1 -1");

    assertEquals(3, testPoly.getCoefficient(3));
    assertEquals(-2, testPoly.getCoefficient(2));
    assertEquals(5, testPoly.getCoefficient(1));
    assertEquals(-1, testPoly.getCoefficient(0));
    assertEquals(0, testPoly.getCoefficient(4));
  }

  /**
   * Tests the getDegree method by checking the degree of various polynomials.
   */
  @Test
  public void testGetDegree() {
    assertEquals(2, poly1.getDegree());
    assertEquals(3, poly2.getDegree());
    assertEquals(0, emptyPoly.getDegree()); 
    assertEquals(0, constantPoly.getDegree()); 
  }

  /**
   * Tests the toString method to ensure proper string representation of polynomials.
   */
  @Test
  public void testToString() {
    assertEquals("3x^2 +4x^1 -5", poly1.toString());
    assertEquals("2x^3 -3x^1 +5", poly2.toString());
    assertEquals("0", emptyPoly.toString());
    assertEquals("5", constantPoly.toString());
  }
}
