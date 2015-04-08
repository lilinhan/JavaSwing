import javax.swing.*;
import java.awt.*;

/**
 * Created by lewin on 15-4-8.
 */
public class CommonComponent {
    JFrame frame = new JFrame("Test");
    Button ok = new Button("确认");
    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox male = new Checkbox("男",cbg,true);
    Checkbox famale = new Checkbox("女",cbg , false);

    Checkbox married = new Checkbox("是否已婚?",false);
    Choice colorChooser = new Choice();

    List colorList = new List(6 , true);

    TextArea ta = new TextArea(5 , 20);

    TextField name = new TextField(50);

    public void init() {
        colorChooser.add("红色");
        colorChooser.add("绿色");
        colorChooser.add("蓝色");
        colorList.add("红色");
        colorList.add("绿色");
        colorList.add("蓝色");

        Panel bottom = new Panel();
        bottom.add(name);
        bottom.add(ok);

        frame.add(bottom , BorderLayout.SOUTH);

        Panel checkPanel = new Panel();
        checkPanel.add(colorChooser);
        checkPanel.add(male);
        checkPanel.add(famale);
        checkPanel.add(married);

        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(checkPanel);

        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);

        frame.add(top);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CommonComponent().init();
    }
}
