package one.empty3.neunet;

import javax.swing.*;

public class SetLabel {
    private JList list1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;

    public void setData(JFileChooser data) {
    }

    public void getData(JFileChooser data) {
        list1.setListData(data.files);
    }

    public boolean isModified(JFileChooser data) {
        return false;
    }

    public static void main(String [] args) {
        SetLabel setLabel = new SetLabel();
    }
}
