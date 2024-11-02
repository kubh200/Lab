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
    return 0;
  }

  @Override
  public boolean present(T data) {
    return false;
  }

  @Override
  public T minimum() {
    return null;
  }

  @Override
  public T maximum() {
    return null;
  }

  @Override
  public String preOrder() {
    return null;
  }

  @Override
  public String inOrder() {
    return null;
  }

  @Override
  public String postOrder() {
    return null;
  }

}
