import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by lewin on 15-4-8.
 */
public class CardLayoutTest {
    JFrame frame = new JFrame("Text");
    String[] name = {"first","second","third","fourth","fifth"};
    Panel p = new Panel();

    public void init(){
        final CardLayout c = new CardLayout();
        p.setLayout(c);
        for (int i = 0 ; i < name.length ; i++) {
            p.add(name[i] , new Button(name[i]));
        }
        final Panel p = new Panel();
        Button previous = new Button("LastPage");
        previous.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.previous(p);
            }
        });

        Button next = new Button("NextPage");
        next.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.next(p);
            }
        });

        Button first = new Button("FirstPage");
        first.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.first(p);
            }
        });

        Button last = new Button("LastPage");
        last.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.last(p);
            }
        });

        Button third = new Button("TheThirdPage");
        third.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.show(p,"TheThirdPage");
            }
        });

        p.add(previous);
        p.add(next);
        p.add(first);
        p.add(last);
        p.add(third);
        frame.add(p);
        frame.add(p,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new CardLayoutTest().init();
    }
}
