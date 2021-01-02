import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class B implements Runnable {
    int sleep = 200;

    @Override
    public void run() {
        int jishu = 0;
        while (true) {
            jingdutiaoshang.setValue(jishu);
            jishu++;
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (jishu == 100) {
                jishu = 0;
            }
        }
    }

    Thread T0 = new Thread(this);


    public B() {
        for (int i = 0; i <= 1000; i++) {
            comboBox1.addItem(String.valueOf(i * 2));
        }


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(comboBox1.getSelectedIndex());//输出选中的序号

                String temp = (String) comboBox1.getSelectedItem();
                String ok = "";
                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i) <= '9' && temp.charAt(i) >= '0') {
                        ok += temp.charAt(i);
                    }
                }
                System.out.println("selected:" + comboBox1.getSelectedItem()+'|'+"stringOK:"+ok);//输出选中的字符串
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                T0.start();
                System.out.println("线程已启动");
//                new Thread(new B()).start();
                new Thread(new updateSleepValue()).start();
                button1.setEnabled(false);
            }
        });
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderValue.setText("sliderValue:" + slider1.getValue());
                sleep = slider1.getValue() * 2;
            }
        });
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //100
                sleep = 100;
            }
        });
        a400RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //400
                sleep = 400;
            }
        });
        a800RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //800
                sleep = 800;
            }
        });
        a200RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sleep = 200;
            }
        });
        a600RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sleep = 600;
            }
        });
        a1000RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sleep = 1000;
            }
        });

        comboBox1.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                System.out.println("test-1");
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {
                System.out.println("test-2");
            }
        });
        comboBox1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                System.out.println("test-3");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("B");
        frame.setContentPane(new B().MainJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel MainJPanel;
    private JRadioButton radioButton1;
    private JRadioButton a400RadioButton;
    private JRadioButton a800RadioButton;
    private JButton button1;
    private JSlider slider1;
    private JProgressBar jingdutiaoshang;
    private JProgressBar jingdutiaoxia;
    private JComboBox comboBox1;
    private JLabel sliderValue;
    private JLabel sleepValue;
    private JRadioButton a200RadioButton;
    private JRadioButton a600RadioButton;
    private JRadioButton a1000RadioButton;

    class updateSleepValue implements Runnable {
        @Override
        public void run() {
            while (true) {
                sleepValue.setText("sleepValue:" + sleep);
            }
        }
    }
}
