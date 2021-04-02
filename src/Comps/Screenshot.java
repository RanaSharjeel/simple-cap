package Comps;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
    Screenshot Button : Take a screenshot when clicked on and copy it to the clipboard
 */
public class Screenshot extends ToolButton {

    public Screenshot(String name) {
        super(name);
        this.addActionListener(new ScreenshotAL());
    }
}


// The on click listener for the button
class ScreenshotAL implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {

        new ScreenshotArea(ToolsPanel.Mode.COPY);

    }
}