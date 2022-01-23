package one.empty3.neunet.of;

import atlasgen.Action;
import atlasgen.CsvLine;
import atlasgen.CsvReader;
import one.empty3.neunet.*;

import javax.swing.*;
import java.io.File;

public class Main2 {
    private static JRootPane rootPane;
    private String csv;
    private JButton button1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JList rectangles;
    private JList labels;
    private JButton saveAsButton;
    private JButton reloadButton;
    private JButton saveButton;
    private JPanel imagePanel;

    public static void main(String [] args) {


        JFrame frame = new JFrame("Test");
        rootPane = new Main().getRootPane();
        frame.setContentPane(rootPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();


    }

    public void loadData() {
        File directory = new File(csv);
        CsvReader reader = new CsvReader(directory, "\t", "\n", false);
        if (directory.exists() && directory.isFile()) {
            reader.setAction(new Action() {
                @Override
                public void init() {

                }

                @Override
                public void processLine(CsvLine csvLine) {
                    String[] value = csvLine.getValue();

                }
            });
            reader.process();

        }
    }
}
