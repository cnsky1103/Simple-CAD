package Stage;

import Component.Circle;
import Component.Line;
import Component.Rectangle;
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
                gc.lineTo(endX, endY);
                gc.stroke();
                ShapeAttribute.shapeArrayList.add(new Line(startX, startY, endX, endY));
            }
        }, CIRCLE {
            public void paint(double startX, double startY, double endX, double endY) {
                double width = Math.abs(endX - startX);
                double height = Math.abs(endY - startY);

                startX = Math.min(endX, startX);
                startY = Math.min(endY, startY);

                endX = Math.max(endX, startX);
                endY = Math.max(endY, startY);

                gc.strokeOval(startX, startY, width, height);
                ShapeAttribute.shapeArrayList.add(new Circle(startX, startY, endX, endY));
            }
        }, RECTANGLE {
            public void paint(double startX, double startY, double endX, double endY) {
                double width = Math.abs(endX - startX);
                double height = Math.abs(endY - startY);

                startX = Math.min(endX, startX);
                startY = Math.min(endY, startY);

                endX = Math.max(endX, startX);
                endY = Math.max(endY, startY);

                gc.strokeRect(startX, startY, width, height);
                ShapeAttribute.shapeArrayList.add(new Rectangle(startX, startY, endX, endY));
            }
        }, TEXT {
            public void paint(double startX, double startY, double endX, double endY) {
                String text = ShapeAttribute.getText();
                gc.strokeText(text, startX, startY);
            }
        };

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

    public void setBold() {
        gc.setLineWidth(gc.getLineWidth() * 1.2);
    }
}
