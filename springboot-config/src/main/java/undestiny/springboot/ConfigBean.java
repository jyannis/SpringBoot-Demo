package undestiny.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@ConfigurationProperties(prefix="bean")
@Component
public class ConfigBean {

    // 字面值，字符串，布尔，数值
    private String str; // 普通字符串
    private String specialStr; // 转义特殊字符串
    private String specialStr2;// 输出特殊字符串
    private Boolean flag;   // 布尔类型
    private Integer num;    // 整数
    private Double dNum;    // 小数

    // 数组，List和Set，两种写法： 第一种：-空格value，每个值占一行，需缩进对齐；第二种：[1,2,...n] 行内写法
    private List<Object> list;  // list可重复集合
    private Set<Object> set;    // set不可重复集合

    // Map和实体类，两种写法：第一种：key空格value，每个值占一行，需缩进对齐；第二种：{key: value,....} 行内写法
    private Map<String, Object> map; // Map K-V
    private List<Student> students;  // 复合结构，集合对象

    public ConfigBean() {
    }

    public ConfigBean(String str, String specialStr, String specialStr2, Boolean flag, Integer num, Double dNum, List<Object> list, Set<Object> set, Map<String, Object> map, List<Student> students) {
        this.str = str;
        this.specialStr = specialStr;
        this.specialStr2 = specialStr2;
        this.flag = flag;
        this.num = num;
        this.dNum = dNum;
        this.list = list;
        this.set = set;
        this.map = map;
        this.students = students;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getSpecialStr() {
        return specialStr;
    }

    public void setSpecialStr(String specialStr) {
        this.specialStr = specialStr;
    }

    public String getSpecialStr2() {
        return specialStr2;
    }

    public void setSpecialStr2(String specialStr2) {
        this.specialStr2 = specialStr2;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getdNum() {
        return dNum;
    }

    public void setdNum(Double dNum) {
        this.dNum = dNum;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Set<Object> getSet() {
        return set;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
