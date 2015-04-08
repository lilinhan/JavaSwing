import javax.swing.*;
import java.awt.*;

/**
 * Created by lewin on 15-4-8.
 */
public class FreamTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        Panel p = new Panel();
        p.add(new TextField(20));
        p.add(new Button("click me !!"));
        frame.add(p);
        frame.setBounds(30, 30, 250, 120);
        frame.setVisible(true);
    }
}
