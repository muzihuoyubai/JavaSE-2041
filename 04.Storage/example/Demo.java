class Demo {

    // Struct Array {
    // 	int [] arr;
    // 	final int length;
    // }


    public static void main(String[] args) {


        int[][] twoDimensionalArr;
// 二维数组的创建只需要指定一维的大小就行了，因为创建了一个引用的数组，大小是3，无论每个引用指向的内容是多大都无所谓
        twoDimensionalArr = new int[3][];
// 二维数组的长度就是一维数组的长度
        System.out.println(twoDimensionalArr.length); // 3
        for (int []a : twoDimensionalArr) {
            System.out.println(a);
        }
// 如果没有指定二维的大小，那么每个引用里面的内容都是null
// System.out.println(twoDimensionalArr[0].length); // java.lang.NullPointerException

// 可以同时指定维度
        twoDimensionalArr = new int[3][2];
        System.out.println(twoDimensionalArr.length); // 3
// 如果指定了二维的大小，那么就会连带创建了每个二维的数组，这样引用中就不是null
        System.out.println(twoDimensionalArr[0].length); // 2

        for (int []a : twoDimensionalArr) {
            System.out.println(a);
        }

        twoDimensionalArr[2] = new int[20];

        // int[] arr = null;

        // System.out.println(arr.length);

        // int[] arr = new int[5];

        // System.out.println(arr[0]);
        // System.out.println(arr[1]);
        // System.out.println(arr[2]);
        // System.out.println(arr[3]);
        // System.out.println(arr[4]);
        // System.out.println(arr[5]);

        // int[] arr = {1, 2, 3};
        // int length = arr.length;
        // System.out.println(length);

        // System.out.println((new int[1])[0]); // 0
        // System.out.println((new byte[1])[0]); // 0
        // System.out.println((new short[1])[0]); // 0
        // System.out.println((new long[1])[0]); // 0
        // System.out.println((new char[1])[0]); // \u0000 空字符
        // System.out.println((new boolean[1])[0]); // false
        // System.out.println((new float[1])[0]); // 0.0
        // System.out.println((new double[1])[0]); // 0.0
        // System.out.println((new String[1])[0]); // null

        // int[] foreachArr = new int[2];
        // foreachArr[0] = 1;
        // foreachArr[1] = 20;
        // // 依次输出foreachArr[0]和foreachArr[1]的内容
        // for (int a : foreachArr) {
        //     System.out.println(a);
        // }

        // for (int i = 0; i < foreachArr.length; i++) {
        //     System.out.println(foreachArr[i]);
        // }

        // System.out.println(0xFFFFFFFF);
        // System.out.println(0x1FFFFFFFFL);
        // System.out.println("\uD83D\uDE00");
        // System.out.println("😀");

        // char c;
        // boolean test = true;
        // if (test) {
        //     c = 'a';
        // } else {
        //     c = 'b';
        // }
        // System.out.println(c); // 编译报错

        // final int a;
        // a = 14;
        // a = 15;

    }
}