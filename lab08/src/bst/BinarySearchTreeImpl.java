package bst;

public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

  private class Node {
    T data;
    Node left, right;

    Node(T data) {
      this.data = data;
      left = right = null;
    }
  }

  private Node root; 
  private int size;  

  public BinarySearchTreeImpl() {
    root = null;
    size = 0;
  }

  @Override
  public void add(T data) {
    root = addRecursive(root, data);
  }

  private Node addRecursive(Node node, T data) {
    if (node == null) {
      size++;
      return new Node(data);
    }
    if (data.compareTo(node.data) < 0) {
      node.left = addRecursive(node.left, data);
    } else if (data.compareTo(node.data) > 0) {
      node.right = addRecursive(node.right, data);
    }
      return node;
  }
  
  @Override
  public int size() {
    return size;
  }

  @Override
  public int height() {
    return heightRecursive(root);
  }

  private int heightRecursive(Node node) {
    if (node == null) {
      return 0;
    }
    int leftHeight = heightRecursive(node.left);
    int rightHeight = heightRecursive(node.right);
    return Math.max(leftHeight, rightHeight) + 1;
  }

  @Override
  public boolean present(T data) {
    return presentRecursive(root, data);
  }

  private boolean presentRecursive(Node node, T data) {
    if (node == null) {
      return false;
    }
    if (data.compareTo(node.data) == 0) {
      return true;
    } else if (data.compareTo(node.data) < 0) {
      return presentRecursive(node.left, data);
    } else {
      return presentRecursive(node.right, data);
    }
  }

  @Override
  public T minimum() {
    if (root == null) {
      return null;
    }
    return minimumRecursive(root);
  }

  private T minimumRecursive(Node node) {
    return (node.left == null) ? node.data : minimumRecursive(node.left);
  }

  @Override
  public T maximum() {
    if (root == null) {
      return null;
    }
    return maximumRecursive(root);
  }

  private T maximumRecursive(Node node) {
    return (node.right == null) ? node.data : maximumRecursive(node.right);
  }

  @Override
  public String preOrder() {
      StringBuilder sb = new StringBuilder();
      sb.append("["); 
      preOrderRecursive(root, sb);
      if (sb.length() > 1) {
          sb.setLength(sb.length() - 1); 
      }
      sb.append("]"); 
      return sb.toString();
  }

  private void preOrderRecursive(Node node, StringBuilder sb) {
      if (node != null) {
          sb.append(node.data).append(" ");
          preOrderRecursive(node.left, sb);
          preOrderRecursive(node.right, sb);
      }
  }

  @Override
  public String inOrder() {
      StringBuilder sb = new StringBuilder();
      sb.append("["); 
      inOrderRecursive(root, sb);
      if (sb.length() > 1) {
          sb.setLength(sb.length() - 1); 
      }
      sb.append("]");
      return sb.toString();
  }

  private void inOrderRecursive(Node node, StringBuilder sb) {
      if (node != null) {
          inOrderRecursive(node.left, sb);
          sb.append(node.data).append(" ");
          inOrderRecursive(node.right, sb);
      }
  }

  @Override
  public String postOrder() {
      StringBuilder sb = new StringBuilder();
      sb.append("["); 
      postOrderRecursive(root, sb);
      if (sb.length() > 1) {
          sb.setLength(sb.length() - 1); 
      }
      sb.append("]"); 
      return sb.toString();
  }

  private void postOrderRecursive(Node node, StringBuilder sb) {
      if (node != null) {
          postOrderRecursive(node.left, sb);
          postOrderRecursive(node.right, sb);
          sb.append(node.data).append(" ");
      }
  }
  
  @Override
  public String toString() {
      return inOrder();
  }

}
