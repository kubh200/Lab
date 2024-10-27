package polynomial;

/**
 * This class represents a single term in a polynomial.
 * A term consists of a coefficient, a power, and a reference to the next term,
 * allowing for a linked-list structure to represent the polynomial.
 */
public class Term {
  int coefficient;
  int power;
  Term next;  
  
  /**
   * Constructs a Term with a specified coefficient, power, and reference to the next term.
   * 
   * @param coefficient the coefficient of the term
   * @param power       the power of the term
   * @param next        the next term in the polynomial
   */
  public Term(int coefficient, int power, Term next) {
    this.coefficient = coefficient;
    this.power = power;
    this.next = next;
  }
}
