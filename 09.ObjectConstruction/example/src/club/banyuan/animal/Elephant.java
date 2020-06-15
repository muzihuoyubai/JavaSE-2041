package club.banyuan.animal;

public class Elephant {

    private static int idCount = 0;

    public static final int DEFAULT_HEIGHT;

    private int heightInCM;

    private final int id;


    { 
        System.exit(1);
        id = ++idCount;
        System.out.println("block3");
    }

    static {
        System.out.println("block2");
    }


    static {
        DEFAULT_HEIGHT = 300;
        System.out.println("block1");
    }



    public Elephant() {
        this(DEFAULT_HEIGHT);
        System.out.println("创建一个默认高度的大象");
    }

    public Elephant(int heightInCM) {
        System.out.printf("创建一个大象，高度%d厘米\n", heightInCM);
        this.heightInCM = heightInCM;
    }

    public Elephant(String heightInCM) {
        System.out.printf("创建一个大象，高度%d厘米\n", heightInCM);
        // this.heightInCM = heightInCM;
        // id = ++idCount;
    }

    public int getId() {
        return id;
    }

    public int getHeightInCM() {
        return heightInCM;
    }

    public void setHeightInCM(int height) {
        if (height <= 100) {
            System.out.println("大象身高错误:" + height);
            return;
        }
        heightInCM = height;
    }
}