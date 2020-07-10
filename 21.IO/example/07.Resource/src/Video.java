import java.io.Serializable;

class Video implements Serializable {

  // - 片名
  String title;

  // - 是否被出租的标识
  // 1 出租  0 未出租
  // int isRent = 1;
  // 出租 未出租
  // String isRent = "出租";
  // true 被出租  false 未被出租
  boolean isRent;
  // - 用户的平均评分
  double rating;

  int ratingTimes;

  public Video(String title) {
    this.title = title;
  }

  void rating(int rate) {
    double originRating = rating * ratingTimes;
    ratingTimes++;
    rating = (originRating + rate) / ratingTimes;
  }

  boolean setRentStatus(boolean status) {
    if (status == isRent) {
      return false;
    }
    isRent = status;
    return true;
  }

  // int[] ratingArr = new int[10]{-1};


  @Override
  public String toString() {
    return "Video{" +
        "title='" + title + '\'' +
        ", isRent=" + isRent +
        ", rating=" + rating +
        ", ratingTimes=" + ratingTimes +
        '}';
  }
}