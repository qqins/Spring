package edu.cqupt.eini.chapter07.po;

/**
 * @author: Hello World
 * @date: 2018/8/15 14:59
 */
public class User {
    private Integer id;
    private String xingMing;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXingMing() {
        return xingMing;
    }

    public void setXingMing(String xingMing) {
        this.xingMing = xingMing;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + xingMing + '\'' +
                ", age=" + age +
                '}';
    }
}
