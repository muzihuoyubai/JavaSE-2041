// package q1;
//
// class Main {
//    public static void main(String args[]) {
//       try {
//          throw 10;  // 编译报错， 必须抛出Throwable的子类 通常选择抛出Exception或RuntimeException的子类
//       }
//       catch(int e) { // 编译报错，必须接受上面可以抛出的异常类
//          System.out.println("Got the  Exception " + e);
//       }
//   }
// }