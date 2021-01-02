import javax.swing.*;
import java.awt.*;

public class A {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("");
        jFrame.setSize(400, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        HORIZONTAL_SPLIT    //水平分割
          VERTICAL_SPLIT    //垂直分割
                    left    //左边
                   right    //右边
         */
        JSplitPane jSplitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jSplitPane.setLeftComponent(new JButton("左边按钮"));
        JSplitPane jSplitPane1=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setLeftComponent(new JButton("上面按钮"));
        jSplitPane1.setRightComponent(new JButton("下面按钮"));
        jSplitPane.setRightComponent(jSplitPane1);
        jFrame.add(jSplitPane, BorderLayout.CENTER);


        jFrame.setVisible(true);
    }
    
    

}
