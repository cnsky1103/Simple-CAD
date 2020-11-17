package File;

import Stage.MainStage;
import sample.ShapeAttribute;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {
    public FileLoader() {

    }

    public void load(MainStage mainStage) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CAD", "*.cad"));
        fc.setTitle("打开图片");
        File file = fc.showOpenDialog(null);

        mainStage.getBoard().clear();
        ShapeAttribute.shapeArrayList.clear();
        ShapeAttribute.canvasList.clear();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String t = null;
            while ((t = br.readLine()) != null) {
                String[] attr = t.split("\\s+");
                mainStage.getBoard().loadCanvas(attr);
            }
        } catch (IOException e) {

        }
    }
}
