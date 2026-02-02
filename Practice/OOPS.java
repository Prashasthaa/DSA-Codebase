public class OOPS {

    public static void main(String[] args) {
        // Pen p1 = new Pen(); // created a pen object p1
        // // ==> in Java object are created in heap

        // p1.setColor("Blue");
        // System.out.println(p1.getColor());

        // p1.setTip(6);
        // System.out.println(p1.getTip());

        // BankAccount myAccount = new BankAccount();
        // myAccount.username = "prashastha";

        // // // error due to The field BankAccount.password is not visible it has the
        // // access
        // // // specifier as private
        // // myAccount.password = "password";

        // myAccount.setPassword("newPassword");

        // Student1 s1 = new Student1("Prashastha");
        // System.out.println(s1.name);

        // Fish tuna = new Fish();
        // tuna.eat();

        Calculator cal = new Calculator();
        System.out.println(cal.sum((float) 1.1, (float) 10.6));
        System.out.println(cal.sum(1, 6));
        System.out.println(cal.sum(1, 6, 9));

        Deer d = new Deer();
        d.eat();
    }
}

// Polymorphism
// method overloading
// =>multiple functions with the same name but different parameter types

class Calculator {
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}
// method overriding
/// =>Parent and child classes both contain the same function with a different
// defination.

class Animal1 {
    void eat() {
        System.out.println("Eats anything");
    }
}

class Deer extends Animal1 {
    void eat() {
        System.out.println("Eats grass");
    }
}
// Inheritance

// types of inheritance
// 1)Single level inheritance
// 2)Multiple level inheritance
// 3)Hierarhial inheritance
// 4)Hybrid inheritance
// 5)Multiple inheritance (not there in java but indirectly implemented using
// interface)
// Base class
class Animal {
    String color;

    void eat() {
        System.out.println("eats");
    }

    void breathes() {
        System.out.println("breathes");
    }
}

// derived class
class Fish extends Animal {
    int fins;

    void swim() {
        System.out.println("Swims in water");
    }
}

// Constructor
// types of constructor
// =>non-paramaterized
// =>parameterized
// =>copy constructors

// Shallow and Deep copy

class Student1 {
    String name;
    int roll;

    Student1(String name) {
        this.name = name;
        System.out.println("Constructor is called....s");
    }
}

// ==> 4 types of access specifiers
// 1)Private
// 2)Public
// 3)Protected
// 4)Default

class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd) {
        password = pwd;
    }
}

class Pen {
    private String color;
    private int tip;

    void setColor(String newColor) {
        this.color = newColor;
    }

    void setTip(int newTip) {
        this.tip = newTip;
    }

    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }
}

class Student {
    String name;
    int age;
    float percentage; // cgpa

    void calcPercentage(int phy, int chem, int math) {
        percentage = (phy + chem + math) / 3;

    }
}
