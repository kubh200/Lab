package polynomial;

/**
 * This class represents an implementation of a polynomial.
 * It supports adding terms, evaluating the polynomial at a given value, retrieving coefficients,
 * getting the degree, and other polynomial operations.
 */
public class PolynomialImpl implements Polynomial {
  private Term head;

  public PolynomialImpl() {
    this.head = null;
  }

  public PolynomialImpl(String polynomial) {
    this.head = null;
    parsePolynomial(polynomial);
  }
    
  private void parsePolynomial(String polynomial) {
    if (polynomial == null || polynomial.isEmpty()) {
      return;
    }
    String[] terms = polynomial.split(" ");
    for (String term : terms) {
      int coefficient = extractCoefficient(term);
      int power = extractPower(term);
      addTerm(coefficient, power);
    }
  }
    
  private int extractCoefficient(String term) {
    if (term.contains("x")) {
      String[] parts = term.split("x");
      if (parts[0].isEmpty() || parts[0].equals("+")) {
        return 1;
      }
      if (parts[0].equals("-")) {
        return -1;
      }
      return Integer.parseInt(parts[0]);
    } else {
      return Integer.parseInt(term); 
    }
  }

  private int extractPower(String term) {
    if (term.contains("^")) {
      String[] parts = term.split("\\^");
      return Integer.parseInt(parts[1]);
    } else if (term.contains("x")) {
      return 1;  
    } else {
      return 0;  
    }
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException("Both polynomials must be of the same type.");
    }
    PolynomialImpl otherPoly = (PolynomialImpl) other;
    PolynomialImpl result = new PolynomialImpl();
    result.head = addPolynomialsRecursively(this.head, otherPoly.head);
    return result;
  }
    
  private Term addPolynomialsRecursively(Term poly1, Term poly2) {
    if (poly1 == null) {
      return poly2;
    }
    if (poly2 == null) {
      return poly1;
    }

    if (poly1.power == poly2.power) {
      int newCoefficient = poly1.coefficient + poly2.coefficient;
      if (newCoefficient == 0) {
        return addPolynomialsRecursively(poly1.next, poly2.next);
      }
      return new Term(newCoefficient, poly1.power, 
          addPolynomialsRecursively(poly1.next, poly2.next));
    } else if (poly1.power > poly2.power) {
      return new Term(poly1.coefficient, poly1.power, addPolynomialsRecursively(poly1.next, poly2));
    } else {
      return new Term(poly2.coefficient, poly2.power, addPolynomialsRecursively(poly1, poly2.next));
    }
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Negative "
        + "powers are not allowed.");
    }
    if (coefficient == 0) {
      return;
    } 

    this.head = addTermRecursively(this.head, coefficient, power);

  }

  private Term addTermRecursively(Term node, int coefficient, int power) {
    if (node == null) {
      return new Term(coefficient, power, null);  
    } else if (node.power == power) {
      node.coefficient += coefficient;  
      if (node.coefficient == 0) {
        return node.next;
      }  
    } else if (node.power < power) {
      return new Term(coefficient, power, node); 
    } else {
      node.next = addTermRecursively(node.next, coefficient, power);  
    }
    return node;
  }

  @Override
  public boolean isSame(Polynomial poly) {
    if (!(poly instanceof PolynomialImpl)) {
      return false;
    }
    Term current1 = this.head;
    Term current2 = ((PolynomialImpl) poly).head;

    while (current1 != null && current2 != null) {
      if (current1.coefficient != current2.coefficient || current1.power != current2.power) {
        return false;
      }
      current1 = current1.next;
      current2 = current2.next;
    }
    return current1 == null && current2 == null;
  }

  @Override
  public double evaluate(double x) {
    double result = 0;
    Term current = head;
    while (current != null) {
      result += current.coefficient * Math.pow(x, current.power);
      current = current.next;
    }
    return result;
  }

  @Override
  public int getCoefficient(int power) {
    Term current = head;
    while (current != null) {
      if (current.power == power) {
        return current.coefficient;
      }
      current = current.next;
    }
    return 0; 
  }

  @Override
  public int getDegree() {
    return head != null ? head.power : 0;
  }

  @Override
  public String toString() {
    if (head == null) {
      return "0";  
    }

    StringBuilder sb = new StringBuilder();
    Term current = head;
    
    while (current != null) {
      if (sb.length() > 0) {
        sb.append(" ");
      }

      if (current.coefficient > 0 && sb.length() > 0) {
        sb.append("+");
      } else if (current.coefficient < 0) {
        sb.append("-");
      }

      if (Math.abs(current.coefficient) != 1 || current.power == 0) {
        sb.append(Math.abs(current.coefficient));
      }

      if (current.power > 0) {
        sb.append("x");
        if (current.power >= 1) {
          sb.append("^").append(current.power);
        }
      }
      current = current.next;
    }

    return sb.toString();
  }




}
