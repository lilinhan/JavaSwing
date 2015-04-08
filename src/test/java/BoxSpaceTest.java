import javax.swing.*;
import java.awt.*;

/**
 * Created by lewin on 15-4-8.
 */
public class BoxSpaceTest {
    private JFrame frame = new JFrame("Test");
    private Box horizontal = Box.createHorizontalBox();
    private Box vertical = Box.createVerticalBox();
    public void init() {
        horizontal.add(new Button("水平按钮1"));
        horizontal.add(Box.createHorizontalGlue());
        horizontal.add(new Button("水平按钮2"));
        horizontal.add(Box.createVerticalStrut(10));
        horizontal.add(new Button("水平按钮3"));
        vertical.add(new Button("垂直按钮1"));
        vertical.add(Box.createHorizontalGlue());
        vertical.add(new Button("垂直按钮2"));
        vertical.add(Box.createHorizontalStrut(10));
        vertical.add(new Button("垂直按钮3"));

        frame.add(horizontal , BorderLayout.NORTH);
        frame.add(vertical);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BoxSpaceTest().init();
    }
}
