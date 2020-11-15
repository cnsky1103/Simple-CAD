package Stage;

import Component.Painter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;

import Basic.Size;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Group group;
    private VBox vBox;
    private Canvas canvas;
    private GraphicsContext gc;
    private Painter painter;

    private double startX, startY;
    private double endX, endY;

    private String state;
    private int selected;

    Board() {
        group = new Group();
        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10, 0, 0, 0));
        vBox.getChildren().add(group);

        canvas = new Canvas(Size.CANVAS_WIDTH, Size.CANVAS_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, Size.CANVAS_WIDTH, Size.CANVAS_HEIGHT);
        gc.restore();
        group.getChildren().add(canvas);

        ShapeAttribute.canvasList = new ArrayList<>();

        handleMouseEvent();
    }

    private void handleMouseEvent() {
        canvas.setOnMousePressed(e -> {
            state = ShapeAttribute.getTool();

            startX = e.getX();
            startY = e.getY();

            if (state.equals("MOUSE")) {
                for (int i = 0; i < ShapeAttribute.canvasList.size(); ++i) {
                    if (ShapeAttribute.shapeArrayList.get(i).isSelected(startX, startY)) {
                        selected = i;
                        break;
                    }
                }
            } else if (state.equals("MOVE")) {

            } else {
                Canvas c = new Canvas(Size.CANVAS_WIDTH, Size.CANVAS_HEIGHT);
                gc = c.getGraphicsContext2D();
                c.setOnMousePressed(canvas.getOnMousePressed());
                c.setOnMouseReleased(canvas.getOnMouseReleased());
                c.setOnMouseDragged(canvas.getOnMouseDragged());

                painter = new Painter();
                painter.setPainter(c, ShapeAttribute.getColor(), false);

                ShapeAttribute.canvasList.add(c);
                group.getChildren().add(c);

            }
        });

        canvas.setOnMouseDragged(e -> {
            if (ShapeAttribute.getTool().equals("PEN")) {
                gc.setStroke(ShapeAttribute.getColor());
                gc.lineTo(e.getX(), e.getY());
                gc.stroke();
            }
        });

        canvas.setOnMouseReleased(e -> {
            endX = e.getX();
            endY = e.getY();
            state = ShapeAttribute.getTool();
            if (state.equals("MOUSE")) {

            } else if (state.equals("MOVE")) {
                double[] p = ShapeAttribute.shapeArrayList.get(selected).getPoint();
                String className = ShapeAttribute.shapeArrayList.get(selected).getClass().toString();
                className = className.substring(6);
                className = className.substring(10);
                className = className.toUpperCase();

                double dx = endX - startX, dy = endY - startY;
                p[0] += dx;
                p[1] += dy;
                p[2] += dx;
                p[3] += dy;

                Canvas c = new Canvas(Size.CANVAS_WIDTH, Size.CANVAS_HEIGHT);
                gc = c.getGraphicsContext2D();
                c.setOnMousePressed(canvas.getOnMousePressed());
                c.setOnMouseReleased(canvas.getOnMouseReleased());
                c.setOnMouseDragged(canvas.getOnMouseDragged());

                painter = new Painter();
                painter.setPainter(c, ShapeAttribute.shapeArrayList.get(selected).getColor(), false);

                group.getChildren().remove(ShapeAttribute.canvasList.get(selected));
                ShapeAttribute.canvasList.remove(selected);
                ShapeAttribute.shapeArrayList.remove(selected);

                ShapeAttribute.canvasList.add(c);
                group.getChildren().add(c);
                selected = ShapeAttribute.canvasList.size() - 1;

                painter.paint(className, p[0], p[1], p[2], p[3]);
                gc.stroke();
            } else {
                if (!ShapeAttribute.getTool().equals("PEN")
                        && !ShapeAttribute.getTool().equals("RUBBER"))
                    painter.paint(ShapeAttribute.getTool(), startX, startY, endX, endY);

                gc.stroke();
            }
        });
    }

    public void undo() {
        if (!ShapeAttribute.canvasList.isEmpty()) {
            group.getChildren().remove(ShapeAttribute.canvasList.get(ShapeAttribute.canvasList.size() - 1));
            ShapeAttribute.canvasList.remove(ShapeAttribute.canvasList.size() - 1);
        }
        //gc.stroke();
    }

    public void clear() {
        group.getChildren().clear();
        ShapeAttribute.canvasList.clear();
        ShapeAttribute.shapeArrayList.clear();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, Size.CANVAS_WIDTH, Size.CANVAS_HEIGHT);
        gc.restore();
        group.getChildren().add(canvas);
    }

    public void loadCanvas(String[] attr) {
        String className = attr[0].toUpperCase();
        double[] p = new double[4];
        for (int i = 0; i < 4; ++i) {
            p[i] = Double.parseDouble(attr[i + 1]);
        }
        String colorStr = attr[5];

        Canvas c = new Canvas(Size.CANVAS_WIDTH, Size.CANVAS_HEIGHT);
        gc = c.getGraphicsContext2D();
        c.setOnMousePressed(canvas.getOnMousePressed());
        c.setOnMouseReleased(canvas.getOnMouseReleased());
        c.setOnMouseDragged(canvas.getOnMouseDragged());

        painter = new Painter();
        painter.setPainter(c, Color.web(colorStr), false);

        ShapeAttribute.canvasList.add(c);
        group.getChildren().add(c);

        painter.paint(className, p[0], p[1], p[2], p[3]);
        gc.stroke();
    }

    public VBox getBoard() {
        return vBox;
    }

    public List<Canvas> getCanvasList() {
        return ShapeAttribute.canvasList;
    }
}
