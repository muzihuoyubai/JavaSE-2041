package club.banyuan.shoe;

public class ShoeDemo {

  public static void main(String[] args) {
    ShoeBox<Shoe, Shoe> shoeShoeShoeBox = new ShoeBox<>();

    shoeShoeShoeBox.setLeft(new Shoe("红色"));
    shoeShoeShoeBox.setRight(new Shoe("蓝色"));

    ShoeBox<LeatherShoes,SportShoes> shoesShoeBox = new ShoeBox<>();
    shoesShoeBox.setLeft(new LeatherShoes("灰色"));
    shoesShoeBox.setRight(new SportShoes("灰色"));

    LeatherShoes left = shoesShoeBox.getLeft();
    SportShoes right = shoesShoeBox.getRight();

  }
}
