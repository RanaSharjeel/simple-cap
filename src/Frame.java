import javax.swing.*;

public class Frame extends JFrame {
    String title;
    static final int WIDTH = 640;
    static final int HEIGHT = 125;
    public Frame(String title){
        this.title = title;
        setTitle(title);


        // Window settings
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
}
