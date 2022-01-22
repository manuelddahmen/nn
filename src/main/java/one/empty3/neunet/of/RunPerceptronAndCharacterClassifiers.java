package one.empty3.neunet.of;

import one.empty3.neunet.HiddenLayer;
import one.empty3.neunet.InputLayer;
import one.empty3.neunet.Net;
import one.empty3.neunet.OutputLayer;
import org.jcodec.common.Ints;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.IntStream;

public class RunPerceptronAndCharacterClassifiers {
    private static HashMap<String, String> options;

    public static void main(String[] args) throws Exception {
        int res = 14;
        options = new HashMap<>();
        for (String s : args) {
            String option;
            String value;
            if (s != null) {
                String[] split = s.split("=");
                if (split.length == 2 && split[0] != null && split[1] != null) {
                    option = split[0].substring(2);
                    value = split[1];
                    options.put(option, value);
                }
            }
        }
        if (options.get("directory") != null) {
            File directory = new File(options.get("directory"));
            if (directory.exists() && directory.isDirectory()) {
                System.out.println("New network");
                Net net = new Net();
                net.setInputLayer(new InputLayer(res, res));
                net.getHiddenLayerList().add(new HiddenLayer(res, res));
                net.getHiddenLayerList().add(new HiddenLayer(res, res));
                net.getHiddenLayerList().add(new HiddenLayer(res, res));
                net.getHiddenLayerList().add(new HiddenLayer(res, res));
                net.getHiddenLayerList().add(new HiddenLayer(res, res));
                net.getOutputLayerList().add(new OutputLayer(res, res));
                for (File image : Objects.requireNonNull(directory.listFiles())) {
                    if (net.getInputLayer().loadData(image)) {

                        System.out.println("Train network");
                        net.train();
                    }
                }
                System.out.println("Result: net");

                for (int i = 0; i < net.getInputLayer().getW().length; i++) {
                    System.out.println("Input layer: \t"+i+"\t" + net.getInputLayer().getW()[i]);
                }
            } else
                System.out.println("Directory not found" + directory.getAbsolutePath());

        }

    }
}
