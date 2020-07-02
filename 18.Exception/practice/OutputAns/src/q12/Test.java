package q12;

public class Test {
 
    private static String result = "";
 
    public static void main(String[] args) {
        test(1);
        result += "*"; // 1245*
        test(0);
        System.out.println(result);
    }
 
    public static void test(int i) {
        result += "1"; // 1  //1245*1
        try {
            if (i == 0) {
                throw new RuntimeException("");
            }
            result += "2"; // 12
        } catch (Exception e) {
            result += "3"; // 1245*13
            return;
        } finally {
            result += "4"; // 124 // 1245*134
        }
        result += "5"; // 1245
    }
}