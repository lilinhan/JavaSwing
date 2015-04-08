import javax.swing.*;
import java.awt.*;

/**
 * Created by lewin on 15-4-8.
 */
public class GirdLayoutTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("计算器");
        Panel p1 = new Panel();
        p1.add(new TextField(30));
        frame.add(p1,BorderLayout.NORTH);
        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(3,5,8,8));
        String [] name = {"0","1","2","3","4","5","6","7","8","9","+","-","*","/","="};
        for (int i = 0 ; i < name.length ; i++ ) {
            p2.add(new Button(name[i]));
        }
        frame.add(p2);
        frame.pack();
        frame.setVisible(true);
    }
}
