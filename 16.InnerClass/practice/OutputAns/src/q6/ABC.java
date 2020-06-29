package q6;

class ABC {

  class XYZ {

    int i = 111;
  }

  public static void main(String[] args) {
    ABC.XYZ a = new ABC().new XYZ();
    System.out.println(a.i);

    System.out.println(new ABC().new XYZ().i);
  }
}
