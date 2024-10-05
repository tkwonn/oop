class PhysicsThings {
    public static final double GRAVITATION = 6.67438e-11;

    private static double roundingDown(double x, int n) {
        return Math.floor(x * Math.pow(10, n)) / Math.pow(10, n);
    }

    public static double getSurfaceGravity(double massKg, double meanRadiusKm) {
        double surfaceGravity = massKg * GRAVITATION / Math.pow(meanRadiusKm * 1000, 2);
        return roundingDown(surfaceGravity, 2);
    }

    public static double getFallingDistance(double gravity, int time) {
        double height = 0.5 * gravity * time * time;
        height = Math.floor(height * 0.000621371);
        return roundingDown(height, 2);
    }
}

class Main {
    public static void main(String[] args) {
        double massOfEarth = 5.974e24;
        double meanRadiusKmOfEarth = 6.3782e3;
        double gravityOfEarth = PhysicsThings.getSurfaceGravity(massOfEarth, meanRadiusKmOfEarth);
        System.out.println(gravityOfEarth); // 9.8
        System.out.println(PhysicsThings.getFallingDistance(gravityOfEarth, 5000)); // 76117.0

        double massOfMars = 6.419e23;
        double meanRadiusKmOfMars = 3.3972e3;
        double gravityOfMars = PhysicsThings.getSurfaceGravity(massOfMars, meanRadiusKmOfMars);
        System.out.println(gravityOfMars); // 3.71
        System.out.println(PhysicsThings.getFallingDistance(gravityOfMars, 5000)); // 28816.0
    }
}