package File;

import Basic.Size;
import Component.Shape;
import Stage.ShapeAttribute;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
