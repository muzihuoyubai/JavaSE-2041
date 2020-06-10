import org.w3c.dom.ls.LSOutput;

public class FlowCtrlDemo {

    public static void main(String[] args) {
        // boolean a = (a = true) && 1 > 2;
        // if (a) {
        //     System.out.println("1");
        // } else {
        //     System.out.println("2");
        // }

        // int b = 5;

        // if (b < 0) {
        //     System.out.println("1");
        // } else if (b > 3) {
        //     System.out.println("2");
        // } else if (b > 4) {
        //     System.out.println("3");
        // }


        // int test = 5;
        // switch (test) {
        // case 1:
        // case 3:
        //     System.out.println(3);
        //     System.out.println(1);
        //     break;
        // case 2:
        //     System.out.println(2);
        // default:
        //     System.out.println("default");
        //     break;
        // }

        // int condition = 1;
        // while (condition > 1) {
        //     System.out.println("1");
        // }

        // do {
        //     System.out.println("1");
        // } while (condition > 1);


        for (int condition = 0; condition < 10 ; condition++) {

            if (condition % 2 == 0) {
                continue;
            } else {
                System.out.println(condition);
            }
            // if (condition++ > 10) {
            // break;
            // }
        }



        // System.out.println("123");


        /*
         * 单行语句
         */
        // boolean condition = true;
        // while (condition)
        //   condition = false;

        // do
        //   condition = false;
        // while(condition);

        // for(;;)
        //   break;



    }
}
