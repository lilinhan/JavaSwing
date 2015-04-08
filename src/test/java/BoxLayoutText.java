import javax.swing.*;
import java.awt.*;

/**
 * Created by lewin on 15-4-8.
 */
public class BoxLayoutText {
    private JFrame frame = new JFrame("Test");
    private Panel p = new Panel();
    public void init(){
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(new Button("FirstButton"));
        p.add(new Button("SecondButton"));
        frame.add(p);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BoxLayoutText().init();
    }
}
