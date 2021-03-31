package Comps;

import javax.swing.*;
import java.awt.*;

/*
    This class creates a borderless transparent frame that covers the entire screen
    The purpose is to draw the area you wish to extract the screenshot from on this frame
 */
public class ScreenshotArea extends JFrame {
    public ScreenshotArea(){
        // Get screen dimensions and set selectable area to encompass it
        Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(r.width, r.height);

        // Sets to transparent
        setOpacity(0.3f);
        setBackground(Color.WHITE);

        MainFrame.minimize(true);
        setVisible(true);
    }
}
