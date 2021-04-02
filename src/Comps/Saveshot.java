package Comps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    Saveshot Button : Take a screenshot when clicked on and prompt to save the image to PC
 */
public class Saveshot extends ToolButton {

    public Saveshot(String name) {
        super(name);
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
