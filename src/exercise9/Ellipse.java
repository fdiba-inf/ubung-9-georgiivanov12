package exercise9;

public class Ellipse {
    private Point startPoint;
    private double semiaxisA;
    private double semiaxisB;

    public Ellipse() {
        startPoint = new Point(0, 0);
        semiaxisA = 1;
        semiaxisB = 1;
    }

    public Ellipse(Point startPoint, double semiaxisA, double semiaxisB) {
        this.startPoint = new Point(startPoint);
        this.semiaxisA = semiaxisA;
        this.semiaxisB = semiaxisB;
    }

    public Ellipse(Ellipse otherEllipse) {
        startPoint = new Point(otherEllipse.startPoint);
        semiaxisA = otherEllipse.semiaxisA;
        semiaxisB = otherEllipse.semiaxisB;
    }

    public boolean isValid() {
        return semiaxisA > 0 && semiaxisB > 0;
    }

    public void initialize() {
        do {
            System.out.println("Start point: ");
            startPoint.initialize();
            System.out.print("Enter semiaxisA: ");
            semiaxisA = Utils.INPUT.nextDouble();
            System.out.print("Enter semiaxisB: ");
            semiaxisB = Utils.INPUT.nextDouble();
        } while (!isValid());
    }

    public double calculatePerimeter() {
        return Math.PI*(3*(semiaxisA+semiaxisB) - Math.sqrt((3*semiaxisA + semiaxisB)*(3*semiaxisB + semiaxisA)));
    }

    public double calculateArea() {
        return Math.PI * semiaxisA * semiaxisB;
    }

    public String getType() {
        return (semiaxisA == semiaxisB) ? "Cycle" : "Ellipse";
    }

    public String toString() {
        return String.format("%s-[%s, %s], %s, P=%s, A=%s", startPoint, semiaxisA, semiaxisB, getType(), calculatePerimeter(), calculateArea());
    }

    public boolean equal(Ellipse otherEllipse) {
        boolean samesemiaxisA = Utils.equals(semiaxisA, otherEllipse.semiaxisA);
        boolean samesemiaxisB = Utils.equals(semiaxisB, otherEllipse.semiaxisB);
        boolean sameSemiaxisAReversed = Utils.equals(semiaxisA, otherEllipse.semiaxisB);
        boolean sameSemiaxisBReversed = Utils.equals(semiaxisB, otherEllipse.semiaxisA);

        return (samesemiaxisA && samesemiaxisB) || (sameSemiaxisAReversed && sameSemiaxisBReversed);
    }
}
