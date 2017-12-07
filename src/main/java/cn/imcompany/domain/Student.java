package cn.imcompany.domain;

import java.util.function.Function;

public class Student {

    private String name;
    private int age;
    private String tag;
    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String printStudent(Function<Student, String> function) {
        return function.apply(this);
    }
}
