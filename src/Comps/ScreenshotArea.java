package Comps;

import com.sun.awt.AWTUtilities;

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
        AWTUtilities.setWindowOpaque(this, false);

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
    float alpha = 0.3f;
    Color bg_color = new Color(1.0f, 1.0f,1.0f, alpha);

    public DrawCrop(){
        x1 = x2 = y1 = y2 = 0;
        MouseManager mouse = new MouseManager();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        setOpaque(false);
        setLayout(null);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw background (translucent white)
        g.setColor(bg_color);
        g.fillRect(0,0,1920,1080);

        // Draw the rectangle (cropping area)
        int px = Math.min(x1, x2);
        int py = Math.min(y1, y2);
        int pw = Math.abs(x1-x2);
        int ph = Math.abs(y1-y2);

        g.clearRect(px, py, pw, ph);

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