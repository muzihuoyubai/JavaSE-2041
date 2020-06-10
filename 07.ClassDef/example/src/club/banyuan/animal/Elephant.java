package club.banyuan.animal;

public class Elephant {
    private int heightInCM;

    public void setHeightInCM(int height) {
        if (isHeightValid(height)) {
            System.out.println("高度不合法：" + height);
            return;
        }
        heightInCM = height;
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
}
