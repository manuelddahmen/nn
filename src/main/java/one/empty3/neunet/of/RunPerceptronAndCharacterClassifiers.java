package one.empty3.neunet.of;

import one.empty3.neunet.HiddenLayer;
import one.empty3.neunet.InputLayer;
import one.empty3.neunet.Net;
import one.empty3.neunet.OutputLayer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

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
                if (split.length==2 && split[0] != null && split[1] != null) {
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
                for (File image : Objects.requireNonNull(directory.listFiles())) {
                    Net net = new Net();
                    net.setInputLayer(new InputLayer(res , res));
                    if(net.getInputLayer().loadData(image)) {
                        net.getHiddenLayerList().add(new HiddenLayer(res , res));
                        net.getOutputLayerList().add(new OutputLayer(res , res));
                        net.train();
                    }
                }
            } else
                System.out.println("Directory not found" + directory.getAbsolutePath());
        }

    }
}
