package gui;

import javax.swing.*;
import java.awt.*;

public class InitWindow {
    private ImageIcon img = new ImageIcon("logo.png");
    public JFrame mainInit(JFrame frame,int width, int height, String title){

        frame.setSize(height, width);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(img.getImage());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return frame;
    }
}
