import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordExample {

  /**
   * 统计每个单词的出现次数，并按照格式输出
   * 单词1=xx次
   * 单词2=xx次
   * 单词3=xx次
   */
  public static final String words = "Shall I compare thee to a summer's day?\n"
      + "Thou art more lovely and more temperate:\n"
      + "Rough winds do shake the darling buds of May,\n"
      + "And summer's lease hath all too short a date:\n"
      + "Sometime too hot the eye of heaven shines,\n"
      + "And often is his gold complexion dimmed,\n"
      + "And every fair from fair sometime declines,\n"
      + "By chance, or nature's changing course untrimmed:\n"
      + "But thy eternal summer shall not fade,\n"
      + "Nor lose possession of that fair thou ow'st,\n"
      + "Nor shall death brag thou wand'rest in his shade,\n"
      + "When in eternal lines to time thou grow'st,\n"
      + "So long as men can breathe or eyes can see,\n"
      + "So long lives this, and this gives life to thee.";

  // 拆分字符串，根据 空格 \n . : , 内容进行拆分
  // 遍历拆分之后的数组，把遍历的字符串保存到Map中，作为Key， 单词的数量作为value
  // 保存的时候，先根据数组中的字符串作为key到map中查询，看是否存在这个字符串，如果存在，则将查询出来的value + 1，如果不存在，则添加这个key，并且value值是1
  // 遍历完数组之后，map中单词为key，数量为value

  public static void main(String[] args) {
    String[] split = words.split(" |\\?|,|\\n|\\.|:");
    System.out.println(Arrays.toString(split));
    Map<String, Integer> wordCount = new TreeMap<>(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (!o1.equals(o2) && o1.toLowerCase().equals(o2.toLowerCase())) {
          return o1.compareTo(o2);
        }
        return o1.toLowerCase().compareTo(o2.toLowerCase());
      }
    });
    int count = 0;
    // for (String s : split) {
    //   if (s.length() == 0) {
    //     continue;
    //   } else if (wordCount.containsKey(s)) {
    //     count++;
    //     wordCount.put(s, wordCount.get(s) + 1);
    //   } else {
    //     wordCount.put(s, 1);
    //     count++;
    //   }
    // }

    for (String s : split) {
      if (s.length() == 0) {
        continue;
      }
      Integer countOne = wordCount.getOrDefault(s, 0) + 1;
      wordCount.put(s, countOne);
      count++;
    }
    System.out.println(wordCount);
    for (Integer value : wordCount.values()) {
      count -= value;
    }
    System.out.println(count);
  }
}
