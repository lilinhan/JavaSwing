import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by lewin on 15-4-12.
 */
public class JprogressBarTest {
    JFrame frame = new JFrame("Test");
    JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL);
    JCheckBox indeterminate = new JCheckBox("不确定进度条");
    JCheckBox noBorder = new JCheckBox("不绘制边框");
    public void init() {
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(indeterminate);
        box.add(noBorder);
        frame.setLayout(new FlowLayout());
        frame.add(box);
        frame.add(bar);
        bar.setMaximum(0);
        bar.setMaximum(100);
        bar.setOrientation(0);
        bar.setStringPainted(true);
        bar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                bar.setBorderPainted(!noBorder.isSelected());
            }
        });
        indeterminate.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                bar.setIndeterminate(indeterminate.isSelected());
                bar.setStringPainted(!indeterminate.isSelected());
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        for (int i = 0 ; i <= 100 ; i++)  {
            bar.setValue(i);
            try {
                Thread.sleep(1000);
            }catch (Exception e)  {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new JprogressBarTest().init();
    }


}
