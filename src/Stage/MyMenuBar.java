package Stage;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MyMenuBar {
    private MainStage mainStage;
    private MenuBar menuBar;
    private Menu file, edit, help;
    private MenuItem fOpen, fSave, fClose;
    private MenuItem eUndo, eClear;
    private MenuItem hAbout;
    MyMenuBar(MainStage m){
        mainStage = m;
        String fontSize = "-fx-font-size:14;";

        menuBar = new MenuBar();

        file = new Menu();
        file.setText("文件");
        file.setStyle(fontSize);

        fOpen = new MenuItem();
        fOpen.setText("打开");
        fOpen.setStyle(fontSize);

        fSave = new MenuItem();
        fSave.setText("保存");
        fSave.setStyle(fontSize);

        fClose = new MenuItem();
        fClose.setText("关闭");
        fClose.setStyle(fontSize);

        file.getItems().add(fOpen);
        file.getItems().add(fSave);
        file.getItems().add(fClose);

        menuBar.getMenus().add(file);
    }

    public MenuBar getMenuBar(){
        return menuBar;
    }
}
