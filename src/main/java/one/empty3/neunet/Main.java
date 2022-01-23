/*
 * Created by JFormDesigner on Sun Jan 23 11:27:24 CET 2022
 */

package one.empty3.neunet;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Manuel Dahmen
 */
public class Main extends JFrame {
    public Main() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        label1 = new JLabel();
        button1 = new JButton();
        textField1 = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel1 = new JPanel();
        label6 = new JLabel();
        textField4 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        label2 = new JLabel();
        label7 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("S\u00e9lection du listing CSV(\"\\t,\\n\") id,path,{(coordonn\u00e9es),} {(label)}");
        contentPane.add(label1, "cell 0 0");

        //---- button1 ----
        button1.setText("Choisissez le fichier ...");
        contentPane.add(button1, "cell 1 0");
        contentPane.add(textField1, "cell 0 1");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, "cell 0 2");

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "fill,hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label6 ----
            label6.setText("id");
            panel1.add(label6, "cell 0 0");
            panel1.add(textField4, "cell 1 0");

            //---- label3 ----
            label3.setText("path");
            panel1.add(label3, "cell 0 1");
            panel1.add(textField2, "cell 1 1");

            //---- label4 ----
            label4.setText("coordonn\u00e9es");
            panel1.add(label4, "cell 0 2");
            panel1.add(textField3, "cell 1 2");

            //---- label5 ----
            label5.setText("labels");
            panel1.add(label5, "cell 0 3");
            panel1.add(textField5, "cell 1 3");
        }
        contentPane.add(panel1, "cell 1 2,dock center");

        //---- label2 ----
        label2.setText("Pr\u00e9c\u00e9dent");
        contentPane.add(label2, "cell 0 3");

        //---- label7 ----
        label7.setText("Suivant");
        contentPane.add(label7, "cell 0 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JLabel label1;
    private JButton button1;
    private JTextField textField1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    private JLabel label6;
    private JTextField textField4;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label2;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String [] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}
