package org.example;


import com.example.geometry.Cube;
import com.example.geometry.GeometryUtils;
import com.example.geometry.Sphere;
import com.example.geometry.model.Circle;
import com.example.geometry.model.Rectangle;
import com.example.geometry.model.Triangle;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(5);
        GeometryUtils  geometryUtils = new GeometryUtils();

        System.out.println("Площадь  окружности: " + circle.getArea());
        System.out.println("Периметр  окружности : " + circle.getPerimeter());
        System.out.println("Длина  окружности : " + circle.getRadius());


        Rectangle rectangle = new Rectangle(4, 6);
        System.out.println("Плошать прямоугольника: " + rectangle.getArea());
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter());

        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("Площадь треугольника: " + triangle.getArea());
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());
        System.out.println(geometryUtils.convertToSquareMeters(triangle.getArea()));


        Sphere sphere = new Sphere(5);
        System.out.println(" Объем сферы " + sphere.getVolume());

        Cube cube = new Cube(15);
        System.out.println("Объем куба" + cube.getVolume());

    }
}