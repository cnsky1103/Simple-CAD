package Component;

public class Shape {
    private double x1, y1, x2, y2;

    public boolean isSelected(double x, double y) {
        return false;
    }

    public double[] getPoint() {
        double[] a = new double[4];
        a[0] = x1;
        a[1] = y1;
        a[2] = x2;
        a[3] = y2;
        return a;
    }
}
