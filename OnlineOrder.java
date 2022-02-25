/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shiran
 */
public class OnlineOrder extends JFrame {

    OnlineOrder() {

        setLayout(null);

        // ----------------------------------------------------------------------------------------------------------------------------
        // add font --------------------------------------------------------------
        Font font1 = new Font("Roboto Slab", Font.BOLD, 22);
        Font font2 = new Font("Roboto Slab", Font.BOLD, 30);
        Font font3 = new Font("Roboto Slab", Font.BOLD, 20);
        Font font4 = new Font("Roboto Slab", Font.BOLD, 15);
        Font font5 = new Font("Roboto Slab", Font.PLAIN, 10);
        Font font6 = new Font("Roboto Slab", Font.BOLD, 20);

        // add cursor ------------------------------------------------------------
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);

        // add labels ------------------------------------------------------------
        JLabel lb1 = new JLabel("Online Orders");
        lb1.setBounds(290, 19, 300, 39);
        lb1.setForeground(Color.black);
        lb1.setFont(font2);
        lb1.setHorizontalAlignment(SwingConstants.CENTER);
        add(lb1);

        JLabel lb2 = new JLabel("Order List");
        lb2.setBounds(120, 87, 300, 39);
        lb2.setForeground(Color.black);
        lb2.setFont(font2);
        lb2.setHorizontalAlignment(SwingConstants.CENTER);
        add(lb2);

        JLabel lb3 = new JLabel("Order Number");
        lb3.setBounds(380, 90, 300, 39);
        lb3.setForeground(Color.black);
        lb3.setFont(font6);
        lb3.setHorizontalAlignment(SwingConstants.CENTER);
        add(lb3);

        // radio Button--------------------------------------------------------
        JRadioButton rb1 = new JRadioButton("Take away");
        rb1.setOpaque(false);
        rb1.setBounds(610, 490, 100, 30);

        JRadioButton rb2 = new JRadioButton("Delivery");
        rb2.setOpaque(false);
        rb2.setBounds(500, 490, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);

        add(rb1);
        add(rb2);

        JRadioButton rb3 = new JRadioButton("Cash Payment");
        rb3.setOpaque(false);
        rb3.setBounds(610, 630, 120, 30);

        JRadioButton rb4 = new JRadioButton("Card Payment");
        rb4.setOpaque(false);
        rb4.setBounds(500, 630, 120, 30);

        ButtonGroup bg2 = new ButtonGroup();
        bg.add(rb3);
        bg.add(rb4);

        add(rb3);
        add(rb4);

        // ---------------------------------------------------------------------------------

        JLabel lb4 = new JLabel("Delivery Date & Time");
        lb4.setBounds(390, 530, 300, 39);
        lb4.setForeground(Color.black);
        lb4.setFont(font4);
        lb4.setHorizontalAlignment(SwingConstants.CENTER);
        add(lb4);

        JLabel lb5 = new JLabel("Select Payment Method");
        lb5.setBounds(400, 590, 300, 39);
        lb5.setForeground(Color.black);
        lb5.setFont(font4);
        lb5.setHorizontalAlignment(SwingConstants.CENTER);
        add(lb5);

        JTextField time2 = new JTextField();
        time2.setBounds(628, 535, 160, 26);
        time2.setFont(font4);
        add(time2);

        JTextField orderNum = new JTextField();
        orderNum.setBounds(628, 97, 160, 26);
        orderNum.setFont(font4);
        add(orderNum);

        // add Table----------------
        Object[][] data = { { null, null, null },
                { null, null, null },
                { null, null, null },
                { null, null, null },
                { null, null, null },
                { null, null, null },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 }
        };

        String[] columnName = { "  ", "Date & Time", "Order Number", "Status" };

        // JPanel p = new JPanel();
        // // p.add(BorderLayout.CENTER);
        // p.setBounds(65, 290, 707, 425);
        // p.setBackground(new Color(204, 255, 255));
        // add(p);
        // p.add(new JScrollPane(table));
        DefaultTableModel model = new DefaultTableModel(data, columnName);
        // TableColumnModel model = table.getColumnModel(data, columnName);

        JTable table = new JTable(model);
        // table.setBounds(0,0,1007, 425);
        // table.setFillsViewportHeight(true);
        // table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // table.setRowHeight(30);

        JScrollPane sp = new JScrollPane(table);
        // model.addColumn("Item");
        // model.addColumn("Item1");
        // model.addColumn("Item2");
        // model.addColumn("Item3");
        // model.addColumn("Item4");
        // model.addColumn("Item5");
        sp.setBounds(37, 140, 407, 565);
        sp.setVisible(true);
        add(sp);

        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);

        // add Table----------------
        Object[][] data2 = { { null, null, null },
                { null, null, null },
                { null, null, null },
                { null, null, null },
                { null, null, null },
                { null, null, null },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 },
                { 101, "shiran", 23 },
                { 101, "shiran", 21 },
                { 101, "shiran", 32 }
        };

        String[] columnName2 = { "  ", "Item Code", "Item Name ", "Unit Price", "Quantity" };

        // JPanel p = new JPanel();
        // // p.add(BorderLayout.CENTER);
        // p.setBounds(65, 290, 707, 425);
        // p.setBackground(new Color(204, 255, 255));
        // add(p);
        // p.add(new JScrollPane(table));
        DefaultTableModel model2 = new DefaultTableModel(data2, columnName2);
        // TableColumnModel model = table.getColumnModel(data, columnName);

        JTable table2 = new JTable(model2);
        // table.setBounds(0,0,1007, 425);
        // table.setFillsViewportHeight(true);
        // table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // table.setRowHeight(30);

        JScrollPane sp2 = new JScrollPane(table2);
        // model.addColumn("Item");
        // model.addColumn("Item1");
        // model.addColumn("Item2");
        // model.addColumn("Item3");
        // model.addColumn("Item4");
        // model.addColumn("Item5");
        sp2.setBounds(449, 140, 340, 325);
        sp2.setVisible(true);
        add(sp2);

        table2.getColumnModel().getColumn(0).setPreferredWidth(10);
        table2.getColumnModel().getColumn(2).setPreferredWidth(150);

        // add buttons ------------------------------------------------------------
        JButton exit = new JButton("Exit");
        exit.setBounds(25, 740, 104, 35);
        exit.setFont(font4);
        exit.setForeground(Color.black);
        exit.setCursor(cur);
        add(exit);

        JButton cancelsOrder = new JButton("Cancel Order");
        cancelsOrder.setBounds(271, 740, 140, 35);
        cancelsOrder.setFont(font4);
        cancelsOrder.setForeground(Color.black);
        cancelsOrder.setCursor(cur);
        add(cancelsOrder);

        JButton sendMesssage = new JButton("Send Message");
        sendMesssage.setBounds(441, 740, 160, 35);
        sendMesssage.setFont(font4);
        sendMesssage.setForeground(Color.black);
        sendMesssage.setCursor(cur);
        add(sendMesssage);

        JButton saveProcess = new JButton("Save & Process Bill");
        saveProcess.setBounds(621, 740, 190, 35);
        saveProcess.setFont(font4);
        saveProcess.setForeground(Color.black);
        saveProcess.setCursor(cur);
        add(saveProcess);

        // define exit button ------------------------------------------------------
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int yes = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Message", YES_NO_OPTION);

                if (yes == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        // set window
        // --------------------------------------------------------------------------------------------------------------
        // add backgroud blue images ---------------------------------------------
        JLabel pic1 = new JLabel();
        pic1.setIcon(new ImageIcon(getClass().getResource("rec2.png")));
        pic1.setBounds(25, 12, 790, 53);
        add(pic1);

        JLabel pic2 = new JLabel();
        pic2.setIcon(new ImageIcon(getClass().getResource("Rectangle 52.png")));
        pic2.setBounds(25, 74, 790, 648);
        add(pic2);

        // add panels --------------------------------------------------------------
        JPanel p2 = new JPanel();
        p2.setBounds(0, 0, 860, 840);
        p2.setBackground(new Color(0, 122, 159));
        add(p2);

        setSize(850, 830);
        setTitle("Cadenza Billing System - 1.0");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    public static void main(String[] args) {
        OnlineOrder obj3 = new OnlineOrder();
    }

}
