package com.itheima.demo;

public class Person_ implements Comparable<Person_> {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person_(int age) {
        super();
        this.age = age;
    }

    @Override
    public String toString() {
        return " [age=" + age + "]";
    }

    @Override
    public int compareTo(Person_ o) {
        if (this.age == o.age)
            return 0;
        else if (this.age > o.age)
            return 1;
        else
            return -1;
    }
}
