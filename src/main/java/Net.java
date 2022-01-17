import one.empty3.feature.PixM;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Net {
    private static final double RESOLUTION = 14;
    private List<File> trainSet = new ArrayList<>();
    private InputLayer inputLayer;
    private List<HiddenLayer> hiddenLayerList = new ArrayList<>();
    private List<OutputLayer> outputLayerList = new ArrayList<>();

    public InputLayer getInputLayer() {
        return inputLayer;
    }

    public void setInputLayer(InputLayer inputLayer) {
        this.inputLayer = inputLayer;
    }

    public List<HiddenLayer> getHiddenLayerList() {
        return hiddenLayerList;
    }

    public void setHiddenLayerList(List<HiddenLayer> hiddenLayerList) {
        this.hiddenLayerList = hiddenLayerList;
    }

    public List<OutputLayer> getOutputLayerList() {
        return outputLayerList;
    }

    public void setOutputLayerList(List<OutputLayer> outputLayerList) {
        this.outputLayerList = outputLayerList;
    }

    public List<File> getTrainSet() {
        return trainSet;
    }

    public void setTrainSet(List<File> trainSet) {
        this.trainSet = trainSet;
    }
    public void loadModel(File model) {

    }
    public void train() {
        try {
            for (int n = 0; n < trainSet.size(); n++) {
                PixM pixM = PixM.getPixM(ImageIO.read(trainSet.get(n)), RESOLUTION);
                for (int i = 0; i < inputLayer.getSizeX(); i++) {
                    double function = inputLayer.function();
                    for(int h=0; h<hiddenLayerList.get(0).getSizeX(); h++) {
                        hiddenLayerList.get(0).getInput()[h] += function; // ??? et le
                    }
                }
                for (int i = 0; i < hiddenLayerList.size()-1; i++) {
                    double function = hiddenLayerList.get(i).function(hiddenLayerList.get(i).getInput(),
                            hiddenLayerList.get(i).getInput().length);
                    for (int h = 0; h < hiddenLayerList.get(h).getSizeX(); h++) {
                        hiddenLayerList.get(i + 1).getInput()[h] += function;
                    }
                }

                HiddenLayer hiddenLayerOut = hiddenLayerList.get(hiddenLayerList.size() - 1);
                OutputLayer outputLayer = outputLayerList.get(0);
                double function = hiddenLayerOut.function(hiddenLayerOut.getInput(),
                        hiddenLayerOut.getInput().length);
                for (int h = 0; h < hiddenLayerList.get(h).getSizeX(); h++) {
                    outputLayer.getInput()[h] += function;
                }

                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
