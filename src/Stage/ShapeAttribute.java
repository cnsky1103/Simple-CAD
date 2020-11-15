package Stage;

import Component.Shape;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class ShapeAttribute {
    private static String tool = "PEN";
    private static Color color = Color.BLACK;
    private static String text = "";
    public static ArrayList<Shape> shapeArrayList = new ArrayList<>();
    public static List<Canvas> canvasList;

    static String getTool() {
        return tool;
    }

    static void setTool(String newTool) {
        tool = newTool;
    }

    static Color getColor() {
        return color;
    }

    static void setColor(Color newColor) {
        color = newColor;
    }

    static String getText() {
        return text;
    }

    static void setText(String t) {
        text = t;
    }
}
