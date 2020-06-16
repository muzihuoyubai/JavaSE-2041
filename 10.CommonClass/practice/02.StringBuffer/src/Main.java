public class Main {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("0");
        stringBuffer.append("1");
        stringBuffer.append("2");
        stringBuffer.append("3");
        stringBuffer.append("4");
        stringBuffer.append("5");
        stringBuffer.append("6");

        String rlt = stringBuffer.toString();
        System.out.println(rlt);

        System.out.println(stringBuffer.reverse());
        System.out.println(stringBuffer.reverse(3, 5));


        stringBuffer.clear();
        System.out.println("======================");
        System.out.println(stringBuffer.toString());

        stringBuffer.append("0");
        stringBuffer.append("1");
        stringBuffer.append("2");
        stringBuffer.append("3");
        stringBuffer.append("4");
        stringBuffer.append("5");
        stringBuffer.append("6");
        System.out.println(stringBuffer.toString());

        stringBuffer.shiftOne();
        stringBuffer.shiftOne();
        stringBuffer.shiftOne();
        System.out.println(stringBuffer.toString());
        System.out.println(stringBuffer.reverse());

    }
}