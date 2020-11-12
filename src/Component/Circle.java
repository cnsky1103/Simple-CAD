package Component;

public class Circle extends Shape {
    private double x1, y1, x2, y2;

    public Circle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean isSelected(double x, double y) {
        return (x >= x1) && (x <= x2) && (y >= y1) && (y <= y2);
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
}
