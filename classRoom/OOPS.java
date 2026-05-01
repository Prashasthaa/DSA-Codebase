package classRoom;

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

        // Calculator cal = new Calculator();
        // System.out.println(cal.sum((float) 1.1, (float) 10.6));
        // System.out.println(cal.sum(1, 6));
        // System.out.println(cal.sum(1, 6, 9));

        // Deer d = new Deer();
        // d.eat();

        // Horse h1 = new Horse();
        // h1.eat();
        // h1.walk();
        // System.out.println(h1.color);
        // h1.changeColor();
        // System.out.println(h1.color);

        // Chicken c1 = new Chicken();
        // c1.eat();
        // c1.walk();

        // Queen q = new Queen();
        // q.moves();

        // Student1 s1 = new Student1();
        // s1.schoolName = "AJIET";

        // Student1 s2 = new Student1();
        // System.out.println(s2.schoolName);

        // Student1 s3 = new Student1();
        // s3.schoolName = "SVVHSS";
        // System.out.println(s3.schoolName);

        // Horse h1 = new Horse();

        Complex c = new Complex();
        c.sum(2, 3, 4, 5);
        c.difference(2, 3, 4, 5);
        c.product(2, 3, 4, 5);

    }
}

//

// Practice
class Complex {
    void sum(int a, int b, int c, int d) {
        System.out.println("sum=" + (a + c) + "+" + (b + d) + "i");
    }

    void difference(int a, int b, int c, int d) {
        System.out.println("sum=" + (a - c) + "+" + (b - d) + "i");

    }
    // product (ac−bd)+(ad+bc)i

    void product(int a, int b, int c, int d) {
        System.out.println("sum=" + ((a * c) - (b * d)) + "+" + ((a * d) + (b * c)) + "i");
    }

}

// Super keyword
class Animal3 {
    Animal3() {
        System.out.println("animal constructor is called ");
    }
}

class Horse extends Animal3 {
    Horse() {
        super();
        System.out.println("horse constructor is calledf");
    }
}

// Static Keyword

// class Student1 {
// String name;
// int roll;

// static String schoolName;

// void setName(String name) {
// this.name = name;
// }

// String getName() {
// return this.name;
// }
// }

// Abstraction

// Interface
// ==>Blueprint of a classes

interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    @Override
    public void moves() {
        System.out.println("Up,down, left, right, diagonal (in all 4 directions)");
    }
}

class Knight implements ChessPlayer {
    @Override
    public void moves() {
        System.out.println("diagonal");
    }
}

class Rook implements ChessPlayer {
    @Override
    public void moves() {
        System.out.println("Up,down, left, right");
    }
}

class King implements ChessPlayer {
    @Override
    public void moves() {
        System.out.println("Up,down, left, right, diagonal( by 1 step) ");
    }
}
// Abtract classes

abstract class Animal2 {
    String color;

    Animal2() {
        color = "brown";
    }

    void eat() {
        System.out.println("animal eats");
    }

    abstract void walk();
}

class Horse1 extends Animal2 {
    void changeColor() {
        color = "dark brown";
    }

    void walk() {
        System.out.println("walks on four legs");
    }
}

class Chicken extends Animal2 {
    void changeColor() {
        color = "yellow";
    }

    void walk() {
        System.out.println("walks on two legs9");
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
