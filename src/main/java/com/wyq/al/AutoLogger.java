package com.wyq.al;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 王艳青 on 14-2-22.
 */
public class AutoLogger extends JFrame {

    public static void main(String[] str){
        JFrame jFrame=new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea();

        panel.setLayout(new GridLayout());
        textArea.setText("test");
        //当TextArea里的内容过长时生成滚动条
        panel.add(new JScrollPane(textArea));
        jFrame.add(panel);
        jFrame.setSize(300,200);
        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize(); // 获得显示器大小对象
        Dimension frameSize = jFrame.getSize();             // 获得窗口大小对象
        if (frameSize.width > displaySize.width)
            frameSize.width = displaySize.width;           // 窗口的宽度不能大于显示器的宽度
        if (frameSize.height > displaySize.height)
            frameSize.height = displaySize.height;          // 窗口的高度不能大于显示器的高度
        jFrame.setLocation((displaySize.width - frameSize.width) / 2,
                (displaySize.height - frameSize.height) / 2); // 设置窗口居中显示器显示
        jFrame.setVisible(true);

        if(SystemTray.isSupported()){ //检查当前系统是否支持系统托盘
            SystemTray tray = SystemTray.getSystemTray();//获取表示桌面托盘区的 SystemTray 实例。
        }

    }
}
