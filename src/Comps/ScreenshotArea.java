package Comps;

import com.sun.awt.AWTUtilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    This class creates a borderless transparent frame that covers the entire screen
    The purpose is to draw the area you wish to extract the screenshot from on this frame
 */
public class ScreenshotArea extends JFrame {
    Screenshot.Mode mode;
    static int[] dimensions = null;
    static final Object lock = new Object();
    public ScreenshotArea(Screenshot.Mode mode) {
        this.mode = mode;
        // Get screen dimensions and set selectable area to encompass it
        Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(r.width, r.height);

        // Sets to transparent
        AWTUtilities.setWindowOpaque(this, false);

        // Crop drawing panel
        setContentPane(new DrawCrop(r.width, r.height));

        /*
        try{
                Robot r = new Robot();
                String path = "src/screen.jpg";
                Rectangle cap = new Rectangle(dims[0], dims[1], dims[2], dims[3]);
                BufferedImage img = r.createScreenCapture(cap);
                ImageIO.write(img, "jpg", new File(path));
                System.out.println("Screenshot saved");
            } catch (AWTException | IOException ex){
                System.out.println(ex);
            }
         */

        // Minimize tools GUI
        MainFrame.minimize(true);
        setVisible(true);

        /*
        *   Start a new thread and wait for screenshot dimensions to be returned
        *   Thread is observing dimensions array and waits till it has some values
        *   before proceeding.
        */
        Thread t = new Thread(() -> {
            synchronized (lock){
                while(dimensions == null){
                    try{
                        lock.wait();
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(Arrays.toString(dimensions));
            }
        });
        t.start();

    }
}

// Area you can crop out using the mouse drag
// This class is adapted from https://stackoverflow.com/a/40945778
class DrawCrop extends JPanel {
    int screen_w, screen_h;
    int x1, y1, x2, y2;
    float alpha = 0.5f;
    Color bg_color = new Color(1.0f, 1.0f,1.0f, alpha);
    Color outline = new Color(0.0f,1.0f,0.0f,1.0f);

    public DrawCrop(int screen_w, int scree_h){
        x1 = x2 = y1 = y2 = 0;
        this.screen_w = screen_w;
        this.screen_h= scree_h;

        // Mouse listener
        MouseManager mouse = new MouseManager();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);

        // Panel config
        setOpaque(false);
        setLayout(null);
        repaint();

    }

    // Return dimensions of cropped area in array format [x , y , width, height]
    public int[] getScreenDim(int x1, int y1, int x2, int y2){
        int px = Math.min(x1,x2);
        int py = Math.min(y1, y2);
        int pw = Math.abs(x1-x2);
        int ph = Math.abs(y1-y2);
        return new int[]{px,py,pw,ph};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw background (translucent white)
        g.setColor(bg_color);
        g.fillRect(0,0,screen_w,screen_h);

        // Draw the clear rectangle (cropping area)
        int[] dims = getScreenDim(x1,y1,x2,y2);
        g.clearRect(dims[0], dims[1], dims[2], dims[3]);

        // Draw green outline
        g.setColor(outline);
        g.drawRect(dims[0], dims[1], dims[2], dims[3]);

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

            // Area locked in - return rectangle dimensions and notify thread
            synchronized (ScreenshotArea.lock){
                ScreenshotArea.dimensions = getScreenDim(x1,y1,x2,y2);
                ScreenshotArea.lock.notify();
            }

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }
    }
}