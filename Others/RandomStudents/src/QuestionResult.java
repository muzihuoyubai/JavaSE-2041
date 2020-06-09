import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

public class QuestionResult {

  private String answer;
  @JSONField(format = "yyyy-MM-dd HH:mm")
  private Date date;

  public QuestionResult() {
  }

  public QuestionResult(String answer) {
    this.answer = answer;
    this.date = new Date();
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
