import javax.swing.*;
import java.awt.*;

/**
 * Created by lewin on 15-4-8.
 */
public class BorderLayoutTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setLayout(new BorderLayout(30,5));
        frame.add(new Button("S"),BorderLayout.SOUTH);
        frame.add(new Button("N"),BorderLayout.NORTH);
        frame.add(new Button("MID"),BorderLayout.CENTER);
        frame.add(new Button("EAST"),BorderLayout.EAST);
        frame.add(new Button("WEST"),BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);

    }
}
