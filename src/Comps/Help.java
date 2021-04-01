package Comps;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help extends JButton {
    String name;
    public Help(String name){
        this.name = name;
        setText(name);
        // Pop dialog explaining program on click
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "----COPY----\nSelect area you wish to crop. \nIt will then copy" +
                                " the image to your clipboard and exit the program." +
                                "\n\n\n" +
                                "----SAVE----\nSelect area you wish to crop. \nIt will then prompt" +
                                " you with a save menu.\nNavigate to your desired save location." +
                                "\nSelect desired filename and extension (JPG or PNG)" +
                                "\nIt will save to the location and exit the program.");
            }
        });
    }
}
