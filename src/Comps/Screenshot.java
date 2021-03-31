package Comps;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screenshot extends JButton {
    String name;
    public Screenshot(String name) {
        this.name = name;
        setText(name);
        this.addActionListener(new ScreenshotAL());
    }
}

class ScreenshotAL implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Works");
    }
}