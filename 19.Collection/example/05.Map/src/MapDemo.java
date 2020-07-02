import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {

  // key-value
  public static void main(String[] args) {
    // ZH - 中国
    // EN - 英国
    // US - 美国

    Country zh = new Country(1400000000, "ZH");
    Country en = new Country(70000000, "EN");
    Country us = new Country(400000000, "US");

    List<Country> list = new ArrayList<>();
    list.add(zh);
    list.add(en);
    list.add(us);
    Set<Country> set = new HashSet<>(list);

    System.out.println(isExist("zh", set));
    System.out.println(find("ZH", list));

    // 键-值  key-value
    Map<String, Country> map = new HashMap<>();
    map.put("ZH", zh);
    map.put("US", us);
    map.put("EN", en);
    System.out.println(isExist("ZH", map));

    map.put("ZH", new Country(3000000, "ABC"));

    System.out.println(map.get("ZH"));

    Map<String, Integer> strNum = new HashMap<>();
    strNum.put("123", 123);
    strNum.get("123");
    // 如果查找的key不存在，返回null
    System.out.println(strNum.get("12345"));

    strNum.put(null, 123123);
    // hashmap 允许 key、value为null
    System.out.println(strNum.get(null));
    strNum.put("123", 12345);
    strNum.put("1234", 12345);
    System.out.println(strNum);

    Collection<Integer> values = strNum.values();
    Set<String> strings = strNum.keySet();

    Set<Entry<String, Integer>> entries = strNum.entrySet();
    for (Entry<String, Integer> entry : entries) {
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
    }

    strNum.get("key");
    // 查询key，如果找不到，则返回给定的默认值
    strNum.getOrDefault("1234", 0);

    // 保留插入顺序
    Map<String, String> linkedHashMap = new LinkedHashMap<>();
    linkedHashMap.put("1", "1");
    linkedHashMap.put("2", "2");
    linkedHashMap.put("4", "4");
    linkedHashMap.put("3", "3");
    linkedHashMap.put("5", "5");
    System.out.println(linkedHashMap);

    Map<String, String> hashMap = new HashMap<>();
    hashMap.put("1", "1");
    hashMap.put("4", "4");
    hashMap.put("2", "2");
    hashMap.put("5", "5");
    hashMap.put("3", "3");
    System.out.println(hashMap);

    Map<String, String> treeMap = new TreeMap<>();
    treeMap.put("1", "1");
    treeMap.put("4", "4");
    treeMap.put("2", "2");
    treeMap.put("5", "5");
    treeMap.put("3", "3");
    System.out.println(treeMap);

    Map<String, Country> stringCountryMap = new TreeMap<>();
    stringCountryMap.put("ZH", zh);
    stringCountryMap.put("US", us);
    stringCountryMap.put("EN", en);
    System.out.println(stringCountryMap);

    // key必须实现Comparable接口
    Map<Country, String> countryStringMap = new TreeMap<>(Comparator.comparingInt(Object::hashCode));
    countryStringMap.put(zh, "ZH");
    countryStringMap.put(us, "US");
    countryStringMap.put(en, "EN");
    System.out.println(countryStringMap);
  }

  public static boolean isExist(String code, Map<String, Country> map) {
    return map.containsKey(code);
  }




  public static boolean isExist(String code, Collection<Country> collection) {
    for (Country country : collection) {
      if (code.equals(country.getCode())) {
        return true;
      }
    }
    return false;
  }

  public static Country find(String code, Collection<Country> collection) {
    for (Country country : collection) {
      if (code.equals(country.getCode())) {
        return country;
      }
    }
    return null;
  }
}
