package model;

public class Circle {
    private float radius;
    private float area;
    int diameter; // <-- has a default access modifier

    public Circle(float radius) {
        this.radius = radius;
        this.area = (float) (Math.PI * radius * radius);
    }

    public void setRadius(float radius) {
        this.radius = radius;
        this.area = (float) (Math.PI * radius * radius);
    }

    public void printArea() {
        System.out.println("The area of the circle with radius " + radius + " is " + area);
    }

    private void printSecrectSauceRecipe() {
        System.out.println("The secret sauce recipe is: ...");
    }
}
