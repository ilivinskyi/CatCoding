package com.ilivinskyi.homeworks.reflection;

import jdk.jfr.Description;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode
@Builder
@NonNull
public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private int getAgeAfterYears(int years) {
        return age + years;
    }

    @Description("Says hello")
    public void sayHello(String strangerName) {
        System.out.println("Hello " + strangerName + ", my name is " + name);
    }

    @Description("Hello, I'm method description.")
    @Deprecated
    public void oldMethod() {
        System.out.println("Old method");
    }

    public void printAge() {
        System.out.println(age);
    }
}
