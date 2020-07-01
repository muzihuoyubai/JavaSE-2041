package club.banyuan.shoe;

public class ShoeBox<T, R> {

  private T left;
  private R right;

  public T getLeft() {
    return left;
  }

  public void setLeft(T left) {
    this.left = left;
  }

  public R getRight() {
    return right;
  }

  public void setRight(R right) {
    this.right = right;
  }
}
