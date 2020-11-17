package sample;

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

    public static String getTool() {
        return tool;
    }

    public static void setTool(String newTool) {
        tool = newTool;
    }

    public static Color getColor() {
        return color;
    }

    public static void setColor(Color newColor) {
        color = newColor;
    }

    public static String getText() {
        return text;
    }

    public static void setText(String t) {
        text = t;
    }
}
