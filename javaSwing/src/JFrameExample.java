import javax.swing.*;

public class JFrameExample {
    public static void main(String[] args) {
        JFrame window = new JFrame("Example Gui");

        window.setTitle("Hello World");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setSize(400, 400);

        window.setLocationRelativeTo(null);

        //window.setLocation(240, 50);

        window.setResizable(false);

        //Adding components
        JButton button = new JButton("Button");
        window.add(button);

        window.setVisible(true);
    }
}
