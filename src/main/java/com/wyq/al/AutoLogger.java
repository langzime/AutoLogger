package com.wyq.al;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.net.URL;

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

        TrayIcon trayIcon = null;
        if(SystemTray.isSupported()){ //检查当前系统是否支持系统托盘
            SystemTray tray = SystemTray.getSystemTray();//获取表示桌面托盘区的 SystemTray 实例。
            Image image  = Toolkit.getDefaultToolkit().getImage("D:\\kissjava.gif");
            PopupMenu popupMenu = new PopupMenu();
            MenuItem  exitItem  = null;
            try {
                exitItem = new MenuItem(new String("关闭".getBytes("UTF-8"),"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            MenuItem  menuItema  = new MenuItem("menu a");
            MenuItem  menuItemb = new MenuItem("menu b");
            MenuItem  menuItemc  = new MenuItem("menu c");
            MenuItem  menuItemd = new MenuItem("menu d");
            exitItem.addActionListener(new  ActionListener(){
                public void actionPerformed(ActionEvent e)     {
                    try{
                        System.exit(0);
                    }catch(Exception   ex)   {
                        ex.printStackTrace();
                    }
                }
            });
            popupMenu.add(menuItema);
            popupMenu.add(menuItemb);
            popupMenu.add(menuItemc);
            popupMenu.add(menuItemd);
            popupMenu.add(exitItem);
            trayIcon = new TrayIcon(image, "系统托盘{kissjava}",  popupMenu);
            trayIcon.addMouseListener(new java.awt.event.MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount()==2){
                        //showIT(true);
                    }
                }
            });
            try{
                tray.add(trayIcon);  // 将 TrayIcon 添加到 SystemTray。
            } catch   (AWTException   e)     {
                System.err.println(e);
            }
        }else {
            System.out.println("您的系统不支持托盘");
        }
        ImageIcon icon = new ImageIcon();
        try{
            URL url = new URL("http://img1.qq.com/ent/pics/11436/11436218.jpg");
            icon = new ImageIcon(url);
        }catch(Exception e){

        }
        JLabel label = new JLabel();
        label.setIcon(icon);
        jFrame.add(label);

    }
}
