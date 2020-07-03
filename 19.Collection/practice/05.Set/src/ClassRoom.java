import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ClassRoom {

  private Set<Student> students = new HashSet<>();

  public Set<Student> getStudents() {
    return students;
  }

  public void setStudents(Set<Student> students) {
    this.students = students;
  }

  public void addStd(Student student) {
    students.add(student);
    // for (Student one : students) {
    //
    //   if (one.equals(student)) {
    //     throw new IllegalArgumentException("id重复"+student.getId());
    //   } else {
    //     students.add(student);
    //   }
  }

  public void print() {
    for (Student stu : students) {
      System.out.println(stu);
    }
  }

  public List<Student> sortById() {
    Set<Student> printId = new TreeSet<>(Comparator.comparingInt(Student::getId));
    printId.addAll(students);
    return new ArrayList<>(printId);
  }

  public List<Student> sortById(boolean isAsc) {

    // if (isAsc) {
    // Set<Student> printId = new TreeSet<>(Comparator.comparingInt(Student::getId));
    // } else
    List<Student> list = new LinkedList<>(students);
    list.sort((o1, o2) -> {
      if (isAsc) {
        return o1.getId() - o2.getId();
      } else {
        return o2.getId() - o1.getId();
      }
    });
    return list;


  }
}


