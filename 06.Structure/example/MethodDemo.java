class MethodDemo {

    public static void main(String[] args) {
        // int a = 5;
        // int b = 10;
        // swap(a, b);
        // System.out.println(a);
        // System.out.println(b);

        // int[] arr = new int[2];
        // arr[0] = 5;
        // arr[1] = 10;

        // int a = arr[0];
        // int b = arr[1];

        // swap(a, b);
        // System.out.println(a);
        // System.out.println(b);



        // swap(arr[0], arr[1]);
        // System.out.println(arr[0]);
        // System.out.println(arr[1]);

        // swap(arr);
        // System.out.println(arr[0]);
        // System.out.println(arr[1]);
        // String s = null;
        // System.out.println(s);

        int[] rlt = test();
        for (int i = 0; i < 10 ; i++ ) {
            System.out.println(rlt[i]);
        }
    }

    public static void swap(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }


    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void test(char b) {
        char c = 'c';
        // char b = 'a';
    }

    // public static void test(int a) {
    //     int b = 0;
    //     for (int a = 1; a < 10; a++) {

    //     }
    // }

    public static int[] test() {
        int []a = new int[10];
        for (int i = 0; i < 10 ; i++ ) {
            a[i] = i;
        }
        return a;
    }

}