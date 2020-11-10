package Stage;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Painter {
    private GraphicsContext gc;
    private boolean fill;

    enum PaintShape {
        LINE {
            public void paint(double startX, double startY, double endX, double endY) {
                gc.moveTo(startX, startY);
                gc.lineTo(endX,endY);
                gc.stroke();
            }
        }, CIRCLE, RECTANGLE;

        GraphicsContext gc;

        public void paint(double startX, double startY, double endX, double endY) {
        }
    }

    public void setPainter(Canvas canvas, Color color, boolean isFilled) {
        gc = canvas.getGraphicsContext2D();
        fill = isFilled;
        if (isFilled) {
            gc.setFill(color);
        } else
            gc.setStroke(color);
    }

    public void paint(String type, double startX, double startY, double endX, double endY) {
        PaintShape paintShape = PaintShape.valueOf(type);
        paintShape.gc = gc;
        paintShape.paint(startX, startY, endX, endY);
    }
}
