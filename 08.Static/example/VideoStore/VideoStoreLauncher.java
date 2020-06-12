class VideoStoreLauncher {
    public static void main(String[] args) {
        // Video v1 = new Video();
        // v1.title = "黑客帝国";

        // Video v2 = new Video();
        // v2.title = "教父";

        // Video v3 = new Video();
        // v3.title = "星球大战";

        VideoStore vs = new VideoStore();

        vs.addVideo("黑客帝国");
        vs.addVideo("教父");
        vs.addVideo("星球大战");

        vs.listInventory();

        System.out.println(vs.checkOut("教父"));

        vs.listInventory();
        System.out.println(vs.returnVideo("教父1"));
        System.out.println(vs.returnVideo("教父"));
        vs.listInventory();

        vs.receiveRating("星球大战", 5);
        vs.receiveRating("星球大战", 2);
        vs.listInventory();


    }
}