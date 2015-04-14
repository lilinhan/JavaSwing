import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lewin on 15-4-12.
 */
public class pattern extends JFrame{
    public static Panel  panel = new Panel();
    public static JLabel patternTime = new JLabel();
    public static JLabel patternPower = new JLabel();
    public static JLabel textBloodSugar = new JLabel();
    public static JLabel textInsulin = new JLabel();
    public static JProgressBar bloodSugerBar = new JProgressBar();
    public static JProgressBar insulinBar = new JProgressBar();
    public static JButton startButton = new JButton("Start");
    public static JButton endButton = new JButton("End");
    public static JButton addPowerButton = new JButton("Charging");
    public static JButton addInsulinButton = new JButton("SuppleInsulin");
    public static Label suggest = new Label();
    public static int bloodSugerCon;
    public static int flag = 0;
    public static int allInsulin = 1000;
    public void init() {
        final timeThread t = new timeThread();
        t.start();
        final powerThread p = new powerThread();
        p.start();
        setBounds(100, 100, 450, 250);
        panel.setBounds(100, 100, 450, 250);
        panel.setLayout(null);
        //显示时间
        panel.add(patternTime);
        patternTime.setBounds(0,-69,200,150);
        patternTime.setVisible(true);
        //显示电量
        panel.add(patternPower);
        patternPower.setBounds(370,-94,200,200);
        patternPower.setVisible(true);
        //设置血糖标签
        textBloodSugar.setText("血糖:");
        textBloodSugar.setBounds(50,50, 50, 50);
        textBloodSugar.setVisible(true);
        panel.add(textBloodSugar);
        //设置胰岛素含量标签
        textInsulin.setText("胰岛素:");
        textInsulin.setBounds(50, 100, 50, 50);
        textInsulin.setVisible(true);
        panel.add(textInsulin);

        //血糖含量检测条
        bloodSugerBar.setMaximum(200);
        bloodSugerBar.setMinimum(0);
        bloodSugerBar.setOrientation(0);
        bloodSugerBar.setPreferredSize(new Dimension(200,30));
        bloodSugerBar.setBorderPainted(true);
        panel.add(bloodSugerBar);
        bloodSugerBar.setBounds(110,65,250,20);
        bloodSugerBar.setVisible(true);
        //胰岛素状态条
        insulinBar.setMaximum(0);
        insulinBar.setMaximum(1000);
        insulinBar.setValue(1000);
        insulinBar.setOrientation(0);
        insulinBar.setPreferredSize(new Dimension(200,30));
        insulinBar.setBorderPainted(true);
        panel.add(insulinBar);
        insulinBar.setBounds(110,115,250,20);
        insulinBar.setVisible(true);
        //添加开始按钮
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bloodSuger b = new bloodSuger();
                insulinContent i = new insulinContent();
                b.start();
                i.start();
            }
        });
        startButton.setVisible(true);
        startButton.setBounds(60,150,150,40);
        panel.add(startButton);

        //添加结束按钮
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        endButton.setVisible(true);
        endButton.setBounds(250,150,150,40);
        panel.add(endButton);

        //设置充电按钮
        addPowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setPower();
            }
        });
        addPowerButton.setVisible(true);
        addPowerButton.setBounds(60,200,150,40);
        panel.add(addPowerButton);

        //设置添加胰岛素按钮
        addInsulinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allInsulin = 1000;
            }
        });
        addInsulinButton.setVisible(true);
        addInsulinButton.setBounds(250,200,150,40);
        panel.add(addInsulinButton);

        //增加建议以及胰岛素泵状态显示
        suggest.setVisible(true);
        suggest.setBounds(370, 100, 70, 50);
        panel.add(suggest);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


    public class timeThread extends Thread{
        public void run() {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            while (true) {
                patternTime.setText("时间:"+date.format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public class powerThread extends Thread {
        int power = 100;

        public void run() {
            while (true) {
                if (power < 2)  {
                    try{
                        JOptionPane.showMessageDialog(null,"No Power!!!" , "" , JOptionPane.ERROR_MESSAGE);
                        Thread.sleep(3000);
                        System.exit(0);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                patternPower.setText("电量:" + power + "%");
                power--;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void setPower() {
            power = 100;
        }

    }

    public class bloodSuger  extends Thread{
        public synchronized void run() {
            while (true)  {
                bloodSugerCon = (int)(Math.random()*1000)%200 + 1;
                if ( bloodSugerCon > 180 ) {
                    bloodSugerBar.setForeground(Color.red);
                }
                else if ( bloodSugerCon >= 110  && bloodSugerCon < 180) {
                    bloodSugerBar.setForeground(Color.yellow);
                }
                else {
                    bloodSugerBar.setForeground(Color.GREEN);
                }


                bloodSugerBar.setValue(bloodSugerCon);
                flag = 1;
                try {
                    Thread.sleep(1500);
                }catch (Exception e)  {
                    e.printStackTrace();
                }
            }
        }

    }

    public class insulinContent extends Thread {
        public synchronized void run()  {
            while (true)  {
                if ( flag == 0  )  {
                    continue;
                }
                else {
                    if( allInsulin < 2 ) {
                        try {
                            JOptionPane.showMessageDialog(null, "No Insulin!!!", "", JOptionPane.ERROR_MESSAGE);
                            Thread.sleep(3000);
                            System.exit(0);
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if ( bloodSugerCon >= 180 ) {
                        suggest.setText("需要就医");
                    }
                    else if ( bloodSugerCon >= 150  && bloodSugerCon < 180 ) {
                        allInsulin -= 20;
                        insulinBar.setValue(allInsulin);
                        suggest.setText("大量注射");
                    }else if ( bloodSugerCon >= 110 && bloodSugerCon < 150 ) {
                        allInsulin -= 10;
                        insulinBar.setValue(allInsulin);
                        suggest.setText("微量注射");
                    }else if ( bloodSugerCon > 50 && bloodSugerCon < 110)  {
                        suggest.setText("血糖正常");
                    }else if ( bloodSugerCon < 50 )  {
                        suggest.setText("低血糖");
                    }
                    try {
                        Thread.sleep(1500);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
