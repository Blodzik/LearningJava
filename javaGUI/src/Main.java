import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;

public class Main {
    public static void main(String[] args) {


        JFrame frame = new JFrame();

        frame.setSize(420, 420);
        frame.setTitle("JFrame title goes here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //prevent frame from being resized


        frame.setVisible(true);

        ImageIcon image = new ImageIcon("loogo.png"); //create an ImageIcon
        frame.setIconImage(image.getImage()); //change icon of frame


        frame.getContentPane().setBackground(new Color(123, 50, 250 )); //change color of background
    }
}