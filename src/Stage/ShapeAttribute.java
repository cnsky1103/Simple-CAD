package Stage;

import javafx.scene.paint.Color;

public class ShapeAttribute {
    private static String tool = "PEN";
    private static Color color = Color.BLACK;
    //static

    static String getTool(){
        return tool;
    }

    static void setTool(String newTool) {
        tool = newTool;
    }

    static Color getColor(){
        return color;
    }

    static void setColor(Color newColor) {
        color = newColor;
    }
}