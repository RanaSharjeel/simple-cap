import Comps.ToolsPanel;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    public static final int W_WIDTH = 640;
    public static final int W_HEIGHT = 125;

    public Frame(String title){
        setTitle(title);
        setLayout(new BorderLayout());
        
        // Init Components
        ToolsPanel tools = new ToolsPanel();

        // Add Components
        add(tools);

        // Window settings
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(W_WIDTH, W_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
