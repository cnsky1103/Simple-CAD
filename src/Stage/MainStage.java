package Stage;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainStage extends Stage {
    private Group group;
    private BorderPane pane;
    private Board board;
    private MyToolBar toolBar;

    public MainStage(){
        group = new Group();
        pane = new BorderPane();

        setScene(new Scene(group, Color.WHEAT));
        setTitle("Simple CAD");
        setResizable(true);

        initPane();

        group.getChildren().add(pane);
        show();
    }

    private void initPane(){
        MyMenuBar myMenuBar=new MyMenuBar(this);
        myMenuBar.getMenuBar().prefWidthProperty().bind(this.widthProperty());
        pane.setTop(myMenuBar.getMenuBar());

        board = new Board();
        pane.setRight(board.getBoard());

        toolBar = new MyToolBar();
        pane.setLeft(toolBar.getToolBar());
    }
}
