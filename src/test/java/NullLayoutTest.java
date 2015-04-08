import javax.swing.*;
import java.awt.*;

/**
 * Created by lewin on 15-4-8.
 */
public class NullLayoutTest {
    JFrame frame = new JFrame("Test");
    Button b1 = new Button("FirstButton");
    Button b2 = new Button("SecondButton");
    public void init(){
        frame.setLayout(null);
        b1.setBounds(20, 30, 90, 28);
        frame.add(b1);
        b2.setBounds(50, 45, 120, 35);
        frame.add(b2);
        frame.setBounds(50,50,200,100);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new NullLayoutTest().init();
    }
}
