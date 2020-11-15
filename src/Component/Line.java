package Component;

import javafx.scene.paint.Color;

public class Line extends Shape {
    private double x1, y1, x2, y2;

    public Line(double x1, double y1, double x2, double y2, Color c) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        super.setColor(c);
    }

    @Override
    public boolean isSelected(double x, double y) {
        // Ax + By +C = 0
        // (Ax+By+C)/sqrt(A^2+B^2)
        double A = y2 - y1, B = x1 - x2, C = y1 * (x2 - x1) - x1 * (y2 - y1);
        double d = (A * x + B * y + C) / Math.sqrt(A * A + B * B);
        return d < 5;
    }

    @Override
    public double[] getPoint() {
        double[] a = new double[4];
        a[0] = x1;
        a[1] = y1;
        a[2] = x2;
        a[3] = y2;
        return a;
    }

    @Override
    public String toString() {
        return "Line " + x1 + " " + y1 + " " + x2 + " " + y2 + " " + super.toString();
    }
}
