class VideoStore {
    Video[] videos = new Video[10];
    int videoCount = 0;


    void addVideo(String title) {
        Video video = new Video(title);
        videos[videoCount] = video;
        videoCount++;
    }

    // 根据片名借出电影
    boolean checkOut(String title) {
        Video one = findVideo(title);
        if (one == null) {
            return false;
        }

        return one.setRentStatus(true);
    }

    // 归还电影
    boolean returnVideo(String title) {
        Video one = findVideo(title);
        if (one == null) {
            return false;
        }

        return one.setRentStatus(false);
    }

    // 设置用户对电影的评分(1~5)，收到评分之后，计算该电影的平均评分，然后保存到Video的评分属性中
    boolean receiveRating(String title, int rating) {

        if (rating < 0 || rating > 5) {
            return false;
        }

        Video one = findVideo(title);

        if (one == null) {
            return false;
        }

        one.rating(rating);
        return true;
    }

    private Video findVideo(String title) {
        for (int i = 0; i < videoCount ; i++ ) {
            if (videos[i].title.equals(title)) {
                return videos[i];
            }
        }
        return null;
    }


    void listInventory() {
        for (int i = 0; i < videoCount ; i++ ) {
            Video video = videos[i];
            System.out.printf("片名：%s\t\t评分：%.1f\t是否借出:%s\n", video.title, video.rating, video.isRent ? "是" : "否");
        }
    }
}



