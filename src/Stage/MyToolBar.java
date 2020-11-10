package Stage;

import Basic.Path;
import Basic.Size;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class MyToolBar {
    private TilePane pane;
    private List<MyButton> buttons;

    private VBox vBox;

    MyToolBar() {
        pane = new TilePane();
        buttons = new ArrayList<>();

        initPane();

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        vBox.getChildren().add(pane);
    }

    private void initPane() {
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setPrefColumns(1);
        pane.setHgap(5);
        pane.setVgap(5);

        MyButton pen = new MyButton("PEN");
        pen.setGraphic(getImageView(new Image(Path.PEN)));
        pen.setOnMouseClicked(e -> {
            ShapeAttribute.setTool("PEN");
        });
        buttons.add(pen);

        MyButton rubber = new MyButton("RUBBER");
        rubber.setGraphic(getImageView(new Image(Path.RUBBER)));
        rubber.setOnMouseClicked(e -> {
            ShapeAttribute.setTool("RUBBER");
        });
        buttons.add(rubber);

        MyButton line = new MyButton("LINE");
        line.setGraphic(getImageView(new Image(Path.LINE)));
        line.setOnMouseClicked(e -> {
            ShapeAttribute.setTool("LINE");
        });
        buttons.add(line);

        pane.getChildren().addAll(buttons);
    }

    private ImageView getImageView(Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(Size.TOOL_BUTTON_WIDTH);
        imageView.setFitHeight(Size.TOOL_BUTTON_HEIGHT);
        return imageView;
    }

    public VBox getToolBar() {
        return vBox;
    }
}