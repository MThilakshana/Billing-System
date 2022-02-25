
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Return_item extends JFrame {

    int total;

    Return_item() {

        setLayout(null);

        // ----------------------------------------------------------------------------------------------------------------------------
        // add font --------------------------------------------------------------
        Font font1 = new Font("Roboto Slab", Font.BOLD, 25);
        Font font2 = new Font("Roboto Slab", Font.BOLD, 30);
        Font font3 = new Font("Roboto Slab", Font.BOLD, 20);
        Font font4 = new Font("Roboto Slab", Font.BOLD, 15);
        Font font5 = new Font("Roboto Slab", Font.PLAIN, 10);

        // add cursor ------------------------------------------------------------
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);

        // add labels ------------------------------------------------------------

        JLabel lb1 = new JLabel("Add return items");
        lb1.setBounds(290, 19, 300, 39);
        lb1.setForeground(Color.black);
        lb1.setFont(font2);
        lb1.setHorizontalAlignment(SwingConstants.CENTER);
        add(lb1);

        JLabel lb2 = new JLabel("Invoice Number");
        lb2.setBounds(65, 94, 155, 26);
        lb2.setFont(font3);
        lb2.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb2);

        JLabel lb3 = new JLabel("Item Code");
        lb3.setBounds(65, 126, 115, 26);
        lb3.setFont(font3);
        lb3.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb3);

        JLabel lb4 = new JLabel("Item Name");
        lb4.setBounds(65, 158, 100, 26);
        lb4.setFont(font3);
        lb4.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb4);

        JLabel lb5 = new JLabel("Return Quantity");
        lb5.setBounds(65, 190, 195, 26);
        lb5.setFont(font3);
        lb5.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb5);

        JLabel lb6 = new JLabel("Amount");
        lb6.setBounds(65, 222, 130, 26);
        lb6.setFont(font3);
        lb6.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb6);

        JLabel lb7 = new JLabel("Billing Date");
        lb7.setBounds(465, 94, 155, 26);
        lb7.setFont(font3);
        lb7.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb7);

        JLabel lb8 = new JLabel("Time");
        lb8.setBounds(465, 126, 155, 26);
        lb8.setFont(font3);
        lb8.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb8);

        JLabel lb9 = new JLabel("Date");
        lb9.setBounds(465, 190, 155, 26);
        lb9.setFont(font3);
        lb9.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb9);

        JLabel lb10 = new JLabel("Time");
        lb10.setBounds(465, 222, 155, 26);
        lb10.setFont(font3);
        lb10.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb10);

        JLabel lb11 = new JLabel("Total Return Amount");
        lb11.setBounds(520, 302, 255, 26);
        lb11.setFont(font3);
        lb11.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb11);

        JLabel lb12 = new JLabel("Discount");
        lb12.setBounds(520, 388, 405, 26);
        lb12.setFont(font3);
        lb12.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb12);

        JLabel lb13 = new JLabel("Final Return Value");
        lb13.setBounds(520, 482, 405, 26);
        lb13.setFont(font3);
        lb13.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb13);

        JTextField returnAmount = new JTextField();
        returnAmount.setBounds(520, 335, 185, 26);
        returnAmount.setFont(font4);
        add(returnAmount);

        JTextField discount = new JTextField();
        discount.setBounds(520, 425, 185, 26);
        discount.setFont(font4);
        add(discount);

        JTextField returnValue = new JTextField();
        returnValue.setBounds(520, 522, 185, 26);
        returnValue.setFont(font4);
        add(returnValue);

        // add textboxes ----------------------------------------------------------
        JTextField invoicNumber = new JTextField();
        invoicNumber.setBounds(224, 94, 185, 26);
        invoicNumber.setFont(font4);
        add(invoicNumber);

        JTextField itemCode = new JTextField();
        itemCode.setBounds(224, 126, 185, 26);
        itemCode.setFont(font4);
        add(itemCode);

        JTextField itmname = new JTextField();
        itmname.setBounds(224, 158, 559, 26);
        itmname.setFont(font4);
        add(itmname);

        JTextField returnQuantity = new JTextField();
        returnQuantity.setBounds(224, 190, 185, 26);
        returnQuantity.setFont(font4);
        add(returnQuantity);

        JTextField amount = new JTextField();
        amount.setBounds(224, 222, 185, 26);
        amount.setFont(font4);
        add(amount);

        JTextField billingDate = new JTextField();
        billingDate.setBounds(595, 94, 185, 26);
        billingDate.setFont(font4);
        billingDate.setEditable(false);
        add(billingDate);

        JTextField time1 = new JTextField();
        time1.setBounds(595, 126, 185, 26);
        time1.setFont(font4);
        time1.setEditable(false);
        add(time1);

        JTextField date = new JTextField();
        date.setBounds(595, 190, 185, 26);
        date.setFont(font4);
        date.setEditable(false);
        add(date);

        JTextField time2 = new JTextField();
        time2.setBounds(595, 222, 185, 26);
        time2.setFont(font4);
        time2.setEditable(false);
        add(time2);

        // add Table----------------

        Object[][] data = {};

        String[] columnName = { "Item Code", "Item name", "Quantity", "Unit Price", "Total Value" };

        DefaultTableModel model = new DefaultTableModel(data, columnName);

        JTable table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);

        sp.setBounds(65, 290, 407, 425);
        sp.setVisible(true);
        add(sp);

        table.getColumnModel().getColumn(2).setPreferredWidth(150);

        // add buttons ------------------------------------------------------------
        JButton exit = new JButton("Exit");
        exit.setBounds(25, 740, 104, 35);
        exit.setFont(font4);
        exit.setForeground(Color.black);
        exit.setCursor(cur);

        add(exit);

        JButton addbill = new JButton("Add to Bill");
        addbill.setBounds(685, 740, 130, 35);
        addbill.setFont(font4);
        addbill.setForeground(Color.black);
        addbill.setCursor(cur);
        add(addbill);

        // define exit button ------------------------------------------------------
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int yes = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Message", YES_NO_OPTION);

                if (yes == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        // add keylesteners -----------------------------------------------------------

        invoicNumber.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();
                if (keypad == KeyEvent.VK_ENTER) {
                    Connection conn = null;

                    if (invoicNumber.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Enter Invoice Numnber");
                    } else {
                        try {
                            String url = "jdbc:sqlite:D:/Java Codes (Practices)/3.Billing System/Databases/billingsystem.db";
                            conn = DriverManager.getConnection(url);

                            String sql = "SELECT date FROM details_of_bills WHERE invoice_number = ?";
                            PreparedStatement pst = conn.prepareStatement(sql);
                            pst.setString(1, invoicNumber.getText());
                            ResultSet rs1 = pst.executeQuery();

                            if (rs1.next()) {
                                String date1 = rs1.getString("date");
                                billingDate.setText(date1);

                                itemCode.requestFocus();
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Invoice Number");
                            }

                            String sql1 = "SELECT time FROM details_of_bills WHERE invoice_number = ?";
                            PreparedStatement pst1 = conn.prepareStatement(sql1);
                            pst1.setString(1, invoicNumber.getText());
                            ResultSet rs2 = pst1.executeQuery();

                            if (rs2.next()) {
                                String t = rs2.getString("time");
                                time1.setText(t);
                            }

                            conn.close();

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Databse Error!\nPlease contact your system developer");
                        }
                    }

                }

                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitW();
                }
            }
        });

        itemCode.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {
                    try {
                        Connection conn = null;
                        String url = "jdbc:sqlite:D:/Java Codes (Practices)/3.Billing System/Databases/billingsystem.db";
                        conn = DriverManager.getConnection(url);

                        String it_code = itemCode.getText();

                        String sql = "SELECT item_code FROM selling_item WHERE item_code = ?";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        pst.setString(1, it_code);
                        ResultSet rs1 = pst.executeQuery();

                        if (rs1.next()) {
                            rs1.getString("item_code");

                            String sqlN = "SELECT item_name FROM items WHERE item_code = ?";
                            PreparedStatement pstN = conn.prepareStatement(sqlN);
                            pstN.setString(1, it_code);
                            ResultSet rsN = pstN.executeQuery();

                            if (rsN.next()) {
                                String i_name = rsN.getString("item_name");
                                itmname.setText(i_name);
                                returnQuantity.requestFocus();
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "This item was not in the bill");
                        }

                        conn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Databse Error!\nPlease contact your system developer");
                    }
                }

                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitW();
                }
            }
        });

        returnQuantity.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {
                    try {
                        Connection conn = null;
                        String url = "jdbc:sqlite:D:/Java Codes (Practices)/3.Billing System/Databases/billingsystem.db";
                        conn = DriverManager.getConnection(url);

                        String sql = "SELECT quantity FROM selling_item WHERE item_code = ?";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        pst.setString(1, itemCode.getText());
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {
                            String q = rs.getString("quantity");
                            int qun = Integer.parseInt(q);

                            int Nq = Integer.parseInt(returnQuantity.getText());

                            if (Nq <= qun) {
                                String sql2 = "SELECT selling_price FROM selling_price WHERE item_code = ?";
                                PreparedStatement pst2 = conn.prepareStatement(sql2);
                                pst2.setString(1, itemCode.getText());
                                ResultSet rs2 = pst.executeQuery();

                                if (rs.next()) {
                                    int price = Integer.parseInt(rs.getString("selling_price"));
                                    total = total + (Nq * price);
                                    returnAmount.setText(Integer.toString(total));
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Quantity out of range");
                            }
                        }

                        conn.close();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Databse Error!\nPlease contact your system developer");
                    }
                }

                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitW();
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

    public void exitW() {
        int yes = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Message", YES_NO_OPTION);

        if (yes == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    public static void main(String[] args) {
        Return_item obj = new Return_item();
    }

}
