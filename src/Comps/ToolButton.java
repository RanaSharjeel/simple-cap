package Comps;

import javax.swing.*;
import java.awt.*;

public abstract class ToolButton extends JButton {
    String name;

    public ToolButton(String name){
        this.name = name;
        // Look
        setText(name);
        setBackground(new Color(255,215,0));
        setFont(new Font("Tahoma", Font.BOLD, 14));
        setFocusPainted(false);
    }
}
