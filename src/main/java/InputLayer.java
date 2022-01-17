import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import one.empty3.feature.PixM;

public class InputLayer extends Layer {
    private double [] x;
    private URL uri;
    private List<Layer> layers;

    public InputLayer(int sizeX){
        super(sizeX);
        layers = new ArrayList<>();
    }

    public void loadData(URL file) {
        PixM p = null;
        try {
            p = PixM.getPixM(ImageIO.read(file), Config.RES);
            this.x = new double[p.getColumns()*p.getLines()];
            for(int j=0; j<p.getLines(); j++)
                for(int i=0; i<p.getColumns(); i++) {
                    for(int comp = 0; comp<p.getCompCount(); comp++) {
                        p.setCompNo(comp);
                        this.x[j + i * p.getColumns()] = p.get(i, j);
                    }
                }
            this.uri = file;
        } catch (IOException e) {
            e.printStackTrace();
        }
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
