// package q5.c1;
//
// interface P {
//
//   String p = "PPPP";
//
//   String methodP();
// }
//
// interface Q extends P {
//
//   String q = "QQQQ";
//
//   String methodQ();
// }
//
// class R implements P, Q {
//
//   public String methodP() {
//     return Q.q + Q.p;
//   }
//
//   public String methodQ() {
//     return P.p + P.q; // P.q 不能这样写
//   }
// }
//
// public class MainClass {
//
//   public static void main(String[] args) {
//     R r = new R();
//
//     System.out.println(r.methodP()); // QQQQPPPP
//
//     System.out.println(r.methodQ()); // PPPPQQQQ
//   }
// }