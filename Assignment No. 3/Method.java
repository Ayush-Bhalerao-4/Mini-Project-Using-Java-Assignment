class Shapes {

    // Constructor Overloading
    Shapes() {
        System.out.println("Shape Object Created");
    }

    Shapes(double r) {
        System.out.println("Circle Created");
        area(r);
    }

    Shapes(double l, double b) {
        System.out.println("Rectangle Created");
        area(l, b);
    }

    // Method Overloading
    void area(double r) {
        System.out.println("Area of Circle: " + (3.14 * r * r));
    }

    void area(double l, double b) {
        System.out.println("Area of Rectangle: " + (l * b));
    }

    void area(double b, double h, int triangle) {
        System.out.println("Area of Triangle: " + (0.5 * b * h));
    }
}

class Hillstations {

    void famousfor() {
        System.out.println("Hillstation is famous for scenic beauty");
    }

    void famousfood() {
        System.out.println("Hillstation has local traditional food");
    }
}

class Manali extends Hillstations {

    @Override
    void famousfor() {
        System.out.println("Manali is famous for snow and mountains");
    }

    @Override
    void famousfood() {
        System.out.println("Manali famous food: Siddu");
    }
}

class Shimla extends Hillstations {

    @Override
    void famousfor() {
        System.out.println("Shimla is famous for colonial architecture");
    }

    @Override
    void famousfood() {
        System.out.println("Shimla famous food: Chana Madra");
    }
}

class Darjeeling extends Hillstations {

    @Override
    void famousfor() {
        System.out.println("Darjeeling is famous for tea gardens");
    }

    @Override
    void famousfood() {
        System.out.println("Darjeeling famous food: Momos");
    }
}

public class Method {
    public static void main(String[] args) {

        // Part 1: Method Overloading
        System.out.println("=== Shapes (Method Overloading) ===");
        Shapes s1 = new Shapes(5);           // Circle
        Shapes s2 = new Shapes(4, 6);        // Rectangle
        Shapes s3 = new Shapes();
        s3.area(3, 4, 1);                   // Triangle

        // Part 2: Method Overriding
        System.out.println("\n=== Hillstations (Method Overriding) ===");

        Hillstations h;

        h = new Manali();
        h.famousfor();
        h.famousfood();

        h = new Shimla();
        h.famousfor();
        h.famousfood();

        h = new Darjeeling();
        h.famousfor();
        h.famousfood();
    }
}