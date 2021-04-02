package Comps;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    public static final int W_WIDTH = 640;
    public static final int W_HEIGHT = 125;
    public static MainFrame[] instances = new MainFrame[1];
    public MainFrame(String title) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        setTitle(title);
        setLayout(new BorderLayout());

        // Init Components
        ToolsPanel tools = new ToolsPanel();

        // Add Components
        add(tools);

        // Window settings
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        setIconImage(new ImageIcon("res/icon.png").getImage());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(W_WIDTH, W_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        instances[0] = this;
    }

    // Minimize window
    public static void minimize(boolean doit){
        if(doit)
            instances[0].setState(Frame.ICONIFIED);
        else
            instances[0].setState(Frame.NORMAL);
    }
}
