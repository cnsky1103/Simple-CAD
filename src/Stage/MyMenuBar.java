package Stage;

import File.FileLoader;
import File.FileSaver;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.StageStyle;

import java.util.List;

public class MyMenuBar {
    private MainStage mainStage;
    private MenuBar menuBar;
    private Menu file, edit, help;
    private MenuItem fOpen, fSave, fClose;
    private MenuItem eUndo, eClear;
    private MenuItem hAbout;

    MyMenuBar(MainStage m) {
        mainStage = m;
        String fontSize = "-fx-font-size:14;";

        menuBar = new MenuBar();

        file = new Menu();
        file.setText("文件");
        file.setStyle(fontSize);

        fOpen = new MenuItem();
        fOpen.setText("打开");
        fOpen.setStyle(fontSize);
        fOpen.setOnAction(e -> {
            FileLoader loader = new FileLoader();
            loader.load(mainStage);
        });

        fSave = new MenuItem();
        fSave.setText("保存");
        fSave.setStyle(fontSize);
        fSave.setOnAction(e -> {
            FileSaver saver = new FileSaver();
            saver.save();
        });

        fClose = new MenuItem();
        fClose.setText("关闭");
        fClose.setStyle(fontSize);
        fClose.setOnAction(e -> {
            Platform.exit();
        });

        file.getItems().add(fOpen);
        file.getItems().add(fSave);
        file.getItems().add(fClose);

        menuBar.getMenus().add(file);

        edit = new Menu();
        edit.setText("编辑");
        edit.setStyle(fontSize);

        eUndo = new MenuItem();
        eUndo.setText("撤销");
        eUndo.setStyle(fontSize);
        eUndo.setOnAction(e -> {
            mainStage.getBoard().undo();
        });

        eClear = new MenuItem();
        eClear.setText("清除");
        eClear.setStyle(fontSize);
        eClear.setOnAction(e -> {
            mainStage.getBoard().clear();
        });

        edit.getItems().add(eUndo);
        edit.getItems().add(eClear);

        menuBar.getMenus().add(edit);

        help = new Menu();
        help.setText("帮助");
        help.setStyle(fontSize);

        hAbout = new MenuItem();
        hAbout.setText("关于");
        hAbout.setStyle(fontSize);
        hAbout.setOnAction(e -> {
            Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
            aboutAlert.setTitle("关于Simple CAD");
            aboutAlert.setHeaderText("欢迎使用Simple CAD");
            aboutAlert.initStyle(StageStyle.UTILITY);
            aboutAlert.setContentText("本程序是浙江大学翁恺老师班Java应用技术课程作业\n"
                    + "仅供学习交流使用");
            aboutAlert.showAndWait();
        });

        help.getItems().add(hAbout);

        menuBar.getMenus().add(help);
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }
}
