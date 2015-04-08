import javax.swing.*;
import java.awt.*;

/**
 * Created by lewin on 15-4-8.
 */
public class BorderLayoutTest2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setLayout(new BorderLayout(30,5));
        frame.add(new Button("S"),BorderLayout.SOUTH);
        frame.add(new Button("N"),BorderLayout.NORTH);
        Panel p = new Panel();
        p.add(new TextField(20));
        p.add(new Button("click me !!"));
        frame.add(p);
        frame.add(new Button("E"),BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);
    }
}
