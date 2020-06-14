package club.banyuan.machine;

import club.banyuan.animal.Elephant;

public class Fridge {

    private int heightInCM;
    private Elephant storage;

    public Fridge(int heightInCM) {
        System.out.printf("创建一个冰箱，高度%d厘米\n", heightInCM);
        this.heightInCM = heightInCM;
    }

    public Elephant getStorage() {
        return this.storage;
    }

    public void setStorage(Elephant storage) {
        this.storage = storage;
    }

    public int getHeightInCM() {
        return heightInCM;
    }

    public void setHeightInCM(int heightInCM) {
        this.heightInCM = heightInCM;
    }


    // public void store(Elephant elephant) {
    //     storage = elephant;
    // }
}