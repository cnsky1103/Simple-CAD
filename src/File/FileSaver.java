package File;

import Basic.Size;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSaver {
    private List<Canvas> canvasList;

    public FileSaver(List<Canvas> c) {
        if (c.isEmpty())
            canvasList = new ArrayList<>();
        else {
            canvasList = new ArrayList<>(c);
        }
    }

    public void saveToFile() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG", "*.png"));
        fc.setTitle("保存图片");
        File img = fc.showSaveDialog(null);
        String type = "PNG";

        try {
            Canvas myCanvas = createCanvas(this.canvasList);
            WritableImage writableImage = new WritableImage((int) (Size.CANVAS_WIDTH), (int) Size.CANVAS_HEIGHT);
            myCanvas.snapshot(null, writableImage);
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
            if (img != null) {
                ImageIO.write(renderedImage, type, img);
            }
            img = null;
            myCanvas = null;
        } catch (IOException ignored) {
        }
    }

    /**
     * 画布生成器，将所有图层合并成一个canvas
     *
     * @param list 传入所有图层
     * @return canvas
     */
    private Canvas createCanvas(List<Canvas> list) {
        Canvas tempCanvas = new Canvas(Size.CANVAS_WIDTH, Size.CANVAS_HEIGHT);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        for (Canvas aList : list) {
            WritableImage image = aList.snapshot(params, null);
            tempCanvas.getGraphicsContext2D().drawImage(image, 0, 0);
        }
        return tempCanvas;
    }
}
