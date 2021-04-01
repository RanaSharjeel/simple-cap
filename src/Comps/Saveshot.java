package Comps;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    Saveshot Button : Take a screenshot when clicked on and prompt to save the image to PC
 */
public class Saveshot extends JButton {
    
    String name;
    
    public Saveshot(String name){
        this.name = name;
        setText(name);
        this.addActionListener(new SaveshotAL());
    }
}

// The on click listener for the button
class SaveshotAL implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new ScreenshotArea(ToolsPanel.Mode.SAVE);

    }
}
