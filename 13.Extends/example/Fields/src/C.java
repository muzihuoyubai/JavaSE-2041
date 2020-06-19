public class C extends B {

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object obj) {
    return true;
  }

  // equals => true     hashCode => true
  // hashCode => false   equals => false

  // equals => false  hashCode => true / false
  // hashCOde => true equals => true / false

  public static void main(String[] args) {

  }
}
