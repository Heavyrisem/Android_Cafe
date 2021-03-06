import javax.swing.*;

import java.awt.color.*;
import jdk.nashorn.internal.codegen.Label;

import java.awt.event.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.applet.Applet;

import java.util.*;

public class Kiosk extends JFrame {

    public final static int width = 840;
    public final static double height = 840/12.9;
    static Cafe twosomeplace;
    
    public static void main(String[] args) {

        twosomeplace = new Cafe("투썸플레이스");
        JFrame frame = new JFrame(twosomeplace.name);
 
        JPanel North_panel = new JPanel();

        JPanel p1 = new JPanel();
        JPanel menu_panel = new JPanel();
        JPanel number_panel = new JPanel();
        JPanel p4 = new JPanel();
        p4.add(new JLabel("P4라벨"), BorderLayout.CENTER);
        
        CardLayout card = new CardLayout();
        JPanel superpanel = new JPanel();
        superpanel.setLayout(card);
        superpanel.add(p1);
        superpanel.add(menu_panel);
        superpanel.add(number_panel);
        superpanel.add(p4);

        JLabel label = new JLabel("주문 하기를 눌러주세요.");
        JLabel input_label = new JLabel();
        
        JButton order_orderBtn = new JButton("주문하기");
        order_orderBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                label.setText("메뉴를 골라 주세요");
            }
        });

        ActionListener next_evnt = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) superpanel.getLayout();
                cardLayout.next(superpanel);   
            }
        };
        ActionListener add_num = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                input_label.setText(input_label.getText() + e.getActionCommand());
            }
        };
        ActionListener del_num = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if (input_label.getText().equals("")) {
                    return;
                } else {
                    input_label.setText(input_label.getText().substring(0, input_label.getText().length() - 1));
                }
            }
        };
        ActionListener cls_num = new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                input_label.setText("");
            }
        };

        
        order_orderBtn.addActionListener(next_evnt);

        final JButton[] btns = new JButton[13];
        for (int i = 0; i < 10; i++) {
            if (i == 0) continue;
            btns[i] = new JButton(""+i);
            btns[i].addActionListener(add_num);
            number_panel.add(btns[i]);
        }

        btns[10] = new JButton("C");
        btns[10].addActionListener(cls_num);
        number_panel.add(btns[10]);
        
        btns[11] = new JButton("0");
        btns[11].addActionListener(add_num);
        number_panel.add(btns[11]);

        btns[12] = new JButton("<-");
        btns[12].addActionListener(del_num);        
        number_panel.add(btns[12]);

        Coffee[] menus = twosomeplace.getMenus();
        JButton[] menus_btns = new JButton[menus.length];
        for (int i = 0; i < menus.length; i++) {
            menus_btns[i] = new JButton("<html><p>" + menus[i].getName() + "<br>" + menus[i].getPrice() + "</p></html>");
            menus_btns[i].setPreferredSize(new Dimension((int)width/4, (int)(height*0.7*0.2)));
            menus_btns[i].setActionCommand(i+"");
            menus_btns[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    int menu_idx = Integer.parseInt(e.getActionCommand());
                    if (twosomeplace.select(menus[menu_idx])) {
                        label.setText("<html><p>" + menus[menu_idx].getName() + "의 가격은" + menus[menu_idx].getPrice() + "원 입니다<br></p></html>");
                        CardLayout cardLayout = (CardLayout) superpanel.getLayout();
                        cardLayout.next(superpanel);
                    }
                }
            });
            menu_panel.add(menus_btns[i]);
        }
        
        for (int i = menus.length; i <4*3; i++){
            menu_panel.add(new JLabel());
        }

        frame.setLayout(new BorderLayout());
        number_panel.setLayout(new GridLayout(4, 3));
        menu_panel.setLayout(new GridLayout(4, 3));
        
        // North_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        North_panel.setLayout(new BoxLayout(North_panel, BoxLayout.Y_AXIS));
        North_panel.setPreferredSize(new Dimension(300, 200));
        
 
 
        North_panel.add(label);
        North_panel.add(input_label);

        p1.add(order_orderBtn);
 
        frame.add(North_panel, BorderLayout.NORTH);
        frame.add(superpanel, BorderLayout.CENTER);
 
 
 
        frame.setResizable(false);
 
        frame.setVisible(true);
 
        frame.setPreferredSize(new Dimension( width , (int)(height*0.3) ));
 
        frame.setSize(840, 840/12*9);
 
        frame.setLocationRelativeTo(null);
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    }
}