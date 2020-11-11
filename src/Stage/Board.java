package Stage;

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
    private List<Canvas> canvasList;

    private double startX, startY;
    private double endX, endY;

    private String state;

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

        canvasList = new ArrayList<>();

        handleMouseEvent();
    }

    private void handleMouseEvent() {
        canvas.setOnMousePressed(e -> {
            state = ShapeAttribute.getTool();

            Canvas c = new Canvas(Size.CANVAS_WIDTH, Size.CANVAS_HEIGHT);
            gc = c.getGraphicsContext2D();
            c.setOnMousePressed(canvas.getOnMousePressed());
            c.setOnMouseReleased(canvas.getOnMouseReleased());
            c.setOnMouseDragged(canvas.getOnMouseDragged());

            startX = e.getX();
            startY = e.getY();

            canvasList.add(c);
            group.getChildren().add(c);
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

            painter = new Painter();
            painter.setPainter(canvas, ShapeAttribute.getColor(), false);

            double w = Math.abs(endX - startX), h = Math.abs(endY - startY);

            if (!ShapeAttribute.getTool().equals("PEN")
                    && !ShapeAttribute.getTool().equals("RUBBER"))
                painter.paint(ShapeAttribute.getTool(), startX, startY, endX, endY);

            gc.stroke();

        });
    }

    public void undo() {
        if (!canvasList.isEmpty()) {
            group.getChildren().remove(canvasList.get(canvasList.size() - 1));
            canvasList.remove(canvasList.size() - 1);
        }
        gc.stroke();
    }

    public void clear() {
        group.getChildren().removeAll(canvasList);
        canvasList.clear();
        gc.stroke();
    }

    public VBox getBoard() {
        return vBox;
    }

    public List<Canvas> getCanvasList() {
        return canvasList;
    }
}
