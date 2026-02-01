public class OOPS {

    public static void main(String[] args) {
        Pen p1 = new Pen(); // created a pen object p1
        // ==> in Java object are created in heap

        p1.setColor("Blue");
        System.out.println(p1.color);

        p1.setTip(6);
        System.out.println(p1.tip);

        BankAccount myAccount = new BankAccount();
        myAccount.username = "prashastha";

        // // error due to The field BankAccount.password is not visible it has the
        // access
        // // specifier as private
        // myAccount.password = "password";

        myAccount.setPassword("newPassword");
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
    String color;
    int tip;

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
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
