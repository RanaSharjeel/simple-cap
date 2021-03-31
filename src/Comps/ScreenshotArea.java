package Comps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        // Crop drawing panel
        setContentPane(new DrawCrop());

        // Minimize tools GUI
        MainFrame.minimize(true);
        setVisible(true);
    }
}

// Area you can crop out using the mouse drag
// This class is adapted from https://stackoverflow.com/a/40945778
class DrawCrop extends JPanel {
    int x1, y1, x2, y2;

    public DrawCrop(){
        x1 = x2 = y1 = y2 = 0;
        MouseManager mouse = new MouseManager();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    public void drawRect(Graphics g, int x1, int y1, int x2, int y2){
        int px = Math.min(x1, x2);
        int py = Math.min(y1, y2);
        int pw = Math.abs(x1-x2);
        int ph = Math.abs(y1-y2);
        g.fillRect(px, py, pw, ph);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        // Draw rect
        drawRect(g, x1, y1, x2, y2);
    }

    // Private class : Mouse adapter
    class MouseManager extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            // Top-left rectangle coords are where mouse was first clicked
            x1 = e.getX();
            y1 = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }
    }
}