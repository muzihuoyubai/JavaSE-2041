class CountMoney {

    public static void main(String[] args) {
        int one = 0, two = 0, five = 0, count = 0;
        for (one = 1; one < 150 ; one ++ ) {
            for (two = 1; two < 150 / 2; two++) {
                for (five = 1; five < 150 / 5 ; five++ ) {
                    if (one + two + five == 100 && one + two * 2 + five * 5 == 150) {
                        count++;
                        System.out.printf("%d,%d,%d\n", one, two, five);
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}