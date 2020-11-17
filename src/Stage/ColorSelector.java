package Stage;

import java.util.ArrayList;
import java.util.List;

import Basic.Size;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sample.ShapeAttribute;

public class ColorSelector {
    private VBox vBox;
    private TilePane tilePane;
    private Color currentColor = Color.BLACK;
    private ColorPicker colorSelector = new ColorPicker();
    private List<MyButton> colorButton = new ArrayList<>();
    private String[] color = {"#ffffff", "#000000", "#c4c3be", "#b97b56",
            "#ffadd6", "#f01e1f", "#89010d", "#fef007", "#ff7c26",
            "#efe2ab", "#93dceb", "#07a0e6", "#9c4ca1", "#3b46e0"};

    public ColorSelector() {
        initUI();
    }

    private void initUI() {

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        colorSelector = new ColorPicker();
        colorSelector.setPrefWidth(Size.COLOR_SELECTOR_WIDTH);
        colorSelector.setStyle("-fx-background-color:orange;-fx-color-label-visible:false;");
        colorSelector.setValue(currentColor);
        colorSelector.setOnAction((ActionEvent t) -> {
            currentColor = colorSelector.getValue();
            ShapeAttribute.setColor(currentColor);
        });

        tilePane = new TilePane();
        tilePane.setAlignment(Pos.CENTER);
        tilePane.setPadding(new Insets(10, 10, 10, 10));
        tilePane.setPrefColumns(2);
        tilePane.setHgap(5);
        tilePane.setVgap(5);

        DropShadow shadow = new DropShadow();
        for (int i = 0; i < color.length; i++) {
            MyButton cButton = new MyButton(color[i]);
            cButton.setStyle("-fx-base: " + color[i] + ";");
            cButton.setPrefSize(Size.COLOR_SELECTOR_WIDTH, Size.COLOR_SELECTOR_WIDTH);
            cButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
                cButton.setEffect(shadow);
            });

            cButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
                cButton.setEffect(null);
            });

            cButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                currentColor = Color.web(((MyButton) e.getSource()).getName());
                colorSelector.setValue(currentColor);
                ShapeAttribute.setColor(currentColor);
            });
            colorButton.add(cButton);
        }
        tilePane.getChildren().addAll(colorButton);
        vBox.getChildren().add(colorSelector);
        vBox.getChildren().add(tilePane);
    }

    public VBox getColorPanel() {
        return vBox;
    }
}
