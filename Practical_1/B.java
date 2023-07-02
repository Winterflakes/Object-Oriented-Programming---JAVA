package Practical_1;

public class B {
    public static void main(String[] args) {
        ThreeDShape shape = new ThreeDShape();

        // Calculate the volume of a sphere with radius 5
        double sphereVolume = shape.volume(5);
        System.out.println("Volume of the sphere: " + sphereVolume);

        // Calculate the volume of a cube with side length 4
        double cubeVolume = shape.volume(4, "cube");
        System.out.println("Volume of the cube: " + cubeVolume);

        // Calculate the volume of a cuboid with dimensions 3, 4, 5
        double cuboidVolume = shape.volume(3, 4, 5, "cuboid");
        System.out.println("Volume of the cuboid: " + cuboidVolume);

        // Calculate the volume of a cylinder with radius 2 and height 6
        double cylinderVolume = shape.volume(2, 6, "cylinder");
        System.out.println("Volume of the cylinder: " + cylinderVolume);
    }
}

class ThreeDShape {
    // Method to calculate the volume of a sphere
    public double volume(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // Method to calculate the volume of a cube
    public double volume(double sideLength, String shape) {
        if (shape.equalsIgnoreCase("cube")) {
            return Math.pow(sideLength, 3);
        } else {
            System.out.println("Invalid shape!");
            return 0.0;
        }
    }

    // Method to calculate the volume of a cuboid
    public double volume(double length, double width, double height, String shape) {
        if (shape.equalsIgnoreCase("cuboid")) {
            return length * width * height;
        } else {
            System.out.println("Invalid shape!");
            return 0.0;
        }
    }

    // Method to calculate the volume of a cylinder
    public double volume(double radius, double height, String shape) {
        if (shape.equalsIgnoreCase("cylinder")) {
            return Math.PI * Math.pow(radius, 2) * height;
        } else {
            System.out.println("Invalid shape!");
            return 0.0;
        }
    }
}


