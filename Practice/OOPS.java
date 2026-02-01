public class OOPS {

    public static void main(String[] args) {
        Pen p1 = new Pen(); // created a pen object p1
        // ==> in Java object are created in heap

        p1.setColor("Blue");
        System.out.println(p1.color);

        p1.setTip(6);
        System.out.println(p1.tip);
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