package one.empty3.neunet;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import one.empty3.feature.PixM;

public class InputLayer extends Layer {
    private double [] x;
    private File uri;
    private List<Layer> layers;

    public InputLayer(int sizeX, int sizeY){
        super(sizeX, sizeY);
        layers = new ArrayList<>();
    }

    public boolean loadData(File file) throws Exception {
        PixM p = null;
        try {
            if(ImageIO.getImageReaders(file)==null)
                return false;
            if(!Arrays.asList("jpg", "png").contains(file.getAbsolutePath().substring(
                    file.getAbsolutePath().length()-3, file.getAbsolutePath().length())))
                return false;
            p = PixM.getPixM(ImageIO.read(file), Config.RES);
            this.x = new double[p.getColumns()*p.getLines()];
            for(int j=0; j<p.getLines(); j++)
                for(int i=0; i<p.getColumns(); i++) {
                    for(int comp = 0; comp<p.getCompCount(); comp++) {
                        p.setCompNo(comp);
                        this.x[i + j * p.getColumns()] = p.get(i, j);
                    }
                }
            this.uri = file;
            return true;
        } catch (IIOException exception) {
            System.out.println("Error reading image. Returns");
            throw new Exception(exception);
        } catch (IOException e) {
            e.printStackTrace();
            }
        return false;
    }
    public void mapTo(Layer layer) {
        this.layers.add(layer);
    }
    public void process() {
        for (int i = 0; i < layers.size(); i++) {
                ((Layer)layers.get(i)).function();

        }
    }

    public void setInputImage(PixM pixM) {
        for(int x=0; x<pixM.getColumns(); x++)
            for(int y=0; y<pixM.getLines(); y++)
                for(int c=0; c<pixM.getCompCount(); c++) {
                    pixM.setCompNo(c);
                    input[(x+y*pixM.getColumns()* pixM.compCount)+c] = pixM.get(x, y);
                }
    }
}
