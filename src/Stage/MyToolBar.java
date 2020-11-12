package Stage;

import Basic.Path;
import Basic.Size;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyToolBar {
    private TilePane pane;
    private List<MyButton> buttons;
    private ColorSelector colorSelector;

    private VBox vBox;

    MyToolBar() {
        pane = new TilePane();
        buttons = new ArrayList<>();

        initPane();

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        vBox.getChildren().add(pane);

        colorSelector = new ColorSelector();
        vBox.getChildren().add(colorSelector.getColorPanel());
    }

    private void initPane() {
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setPrefColumns(1);
        pane.setHgap(5);
        pane.setVgap(5);

        MyButton mouse = new MyButton("MOUSE");
        mouse.setGraphic(getImageView(new Image(Path.PEN)));
        mouse.setOnMouseClicked(e -> {
            ShapeAttribute.setTool("MOUSE");
        });
        buttons.add(mouse);

        MyButton move = new MyButton("MOVE");
        move.setGraphic(getImageView(new Image(Path.PEN)));
        move.setOnMouseClicked(e -> {
            ShapeAttribute.setTool("MOVE");
        });
        buttons.add(move);

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

        MyButton circle = new MyButton("CIRCLE");
        circle.setGraphic(getImageView(new Image(Path.CIRCLE)));
        circle.setOnMouseClicked(e -> {
            ShapeAttribute.setTool("CIRCLE");
        });
        buttons.add(circle);

        MyButton rectangle = new MyButton("RECTANGLE");
        rectangle.setGraphic(getImageView(new Image(Path.RECTANGLE)));
        rectangle.setOnMouseClicked(e -> {
            ShapeAttribute.setTool("RECTANGLE");
        });
        buttons.add(rectangle);

        MyButton text = new MyButton("TEXT");
        text.setGraphic(getImageView(new Image(Path.TEXT)));
        text.setOnMouseClicked(e -> {
            ShapeAttribute.setTool("TEXT");
            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("文本输入框");
            dialog.setContentText("请输入");
            dialog.setHeaderText("修改字体后，直接在画布点击");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(ShapeAttribute::setText);
        });
        buttons.add(text);

        System.out.println(buttons.size());

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
