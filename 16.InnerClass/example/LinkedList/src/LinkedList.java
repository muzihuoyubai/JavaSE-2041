public class LinkedList {

  private Node node = new Node();

  public void add(Object o) {
    Node node = new Node();
    node.setPrev(this.node);
    this.node.setNext(node);
    node.setData(o);
  }


  public class Node {

    private Node prev;
    private Node next;
    private Object data;

    public Node getPrev() {
      return prev;
    }

    public void setPrev(Node prev) {
      this.prev = prev;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    public Object getData() {
      return data;
    }

    public void setData(Object data) {
      this.data = data;
    }
  }

}


