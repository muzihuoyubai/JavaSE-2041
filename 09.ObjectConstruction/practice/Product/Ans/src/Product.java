public class Product {

    private String name;
    


private double price;
    private int scanCode;
    private int num;
    private static int code = 1000;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        scanCode = code;
        code++;
    }

    String getName() {
        return name;
    }
    int getScanCode() {
        return scanCode;
    }
    double getPrice() {
        return price;
    }
    void changePrice(double price) {
        this.price = price;
    }
    int getNum() {
        return num;
    }
    void setNum(int num) {
        this.num = num;
    }
    String getInfo() {
        return "--- 产品信息 ---\n" +
               "名称: " + name +
               "\n编码：" + scanCode +
               "\n价格: " + price + "元\n";
    }
    boolean buy(int num) {
        if (this.num < num) {
            System.out.println("没有足够的库存，已有库存：" + this.num + "，购买数量:" + num);
            return false;
        } else {
            this.num -= num;
            return true;
        }
    }
}
