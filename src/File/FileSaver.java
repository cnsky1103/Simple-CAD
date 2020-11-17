package File;

import Component.Shape;
import sample.ShapeAttribute;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {

    public FileSaver() {

    }

    public void save(){
        FileChooser fc = new FileChooser();
        fc.setTitle("保存可编辑图片");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CAD", "*.cad"));
        File f = fc.showSaveDialog(null);
        try {
            FileWriter fw = new FileWriter(f.getPath());
            for (Shape s : ShapeAttribute.shapeArrayList) {
                String t = s.toString();
                fw.write(t);
            }
            fw.close();
        } catch (IOException e) {

        }
    }

}
