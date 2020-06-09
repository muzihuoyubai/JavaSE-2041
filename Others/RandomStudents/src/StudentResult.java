import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentResult {

  private String name;
  private List<QuestionResult> questionResultList = new ArrayList<>();

  public StudentResult() {
  }

  public StudentResult(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<QuestionResult> getQuestionResultList() {
    return questionResultList;
  }

  public void setQuestionResultList(List<QuestionResult> questionResultList) {
    this.questionResultList = questionResultList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudentResult that = (StudentResult) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
