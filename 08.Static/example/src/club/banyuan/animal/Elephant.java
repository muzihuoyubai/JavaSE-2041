package club.banyuan.animal;

public class Elephant {
    private int id;
    private int heightInCM;
    public static int total = 0;
    private int defaultHeight = 100;

    public Elephant(int heightInCM) {
        heightInCM = heightInCM;
    }

    public Elephant() {
        heightInCM = defaultHeight;
    }


    public static int getTotal() {
        return total;
    }

    // public static int staticMethod() {
    // return id;
    // }

    public void setHeightInCM(int heightInCM) {
        if (isHeightValid(heightInCM)) {
            System.out.println("高度不合法：" + height);
            return;
        }
        this.heightInCM = heightInCM;
    }

    public int getId() {
        return id;
    }

    public void setId(int one) {
        id = one;
    }

    public int getHeightInCM() {
        return heightInCM;
    }

    public double getHeightInMeter() {
        return heightInCM / 100.0;
    }

    private boolean isHeightValid(int height) {
        return height < 100;
    }

    public void print() {
        System.out.println("身高" + heightInCM + "CM的大象，编号是" + id);
    }
}
