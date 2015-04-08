import javax.swing.*;
import java.awt.*;

/**
 * Created by lewin on 15-4-8.
 */
public class FreamTest1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setLayout(new FlowLayout(FlowLayout.LEFT , 20 , 50));
        for (int i = 0 ; i < 10 ; i++ )  {
            frame.add(new Button("button" + i));
        }
        frame.pack();
        frame.setVisible(true);
    }
}
