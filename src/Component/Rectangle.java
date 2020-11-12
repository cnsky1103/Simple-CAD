package Component;

import Basic.Size;

public class Rectangle extends Shape {
    private double x1, y1, x2, y2;

    public Rectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean isSelected(double x, double y) {
        double centerX = (x1 + x2) / 2, centerY = (y1 + y2) / 2;
        double halfW = Math.abs(x2 - x1) / 2, halfH = Math.abs(y2 - y1) / 2;
        return //Math.abs(x - centerX) > halfW - Size.SELECT_SCOPE
                 Math.abs(x - centerX) < halfW + Size.SELECT_SCOPE
                //&& Math.abs(y - centerY) > halfH - Size.SELECT_SCOPE
                && Math.abs(y - centerY) < halfH + Size.SELECT_SCOPE;
    }
}
