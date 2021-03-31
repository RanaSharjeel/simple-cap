package Comps;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


/*
    This class provides the main GUI for the app, displaying all the buttons and options
*/
public class ToolsPanel extends JPanel {
    public ToolsPanel(){
        // Init panel
        setBackground(Color.RED);
        setLayout(new GridLayout(1,0, 25, 0));
        setBorder(new EmptyBorder(10,10,10,10)); // Padding

        // Init Components
        Screenshot b1 = new Screenshot("Screen");
            // TEMP COMPS
        JButton b2 = new JButton("Save");
        JButton b3 = new JButton("About");

        // Add Components
        add(b1);
        add(b2);
        add(b3);
    }
}
