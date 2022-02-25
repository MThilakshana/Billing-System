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
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.KeyAdapter;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class ItemsStock extends JFrame {

    /**
     *
     */
    String Val;

    public ItemsStock() {

        setLayout(null);

        // add font --------------------------------------------------------------
        Font font1 = new Font("Roboto Slab", Font.BOLD, 25);
        Font font2 = new Font("Roboto Slab", Font.BOLD, 30);
        Font font3 = new Font("Roboto Slab", Font.BOLD, 20);
        Font font4 = new Font("Roboto Slab", Font.BOLD, 15);
        Font font5 = new Font("Roboto Slab", Font.PLAIN, 10);

        // add cursor ------------------------------------------------------------
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);

        // ------------------------------------------------------------------------------------------
        // add labels ------------------------------------------------------------
        JLabel lb1 = new JLabel("Add items to stock");
        lb1.setBounds(223, 19, 400, 39);
        lb1.setForeground(Color.black);
        lb1.setFont(font2);
        lb1.setHorizontalAlignment(SwingConstants.CENTER);
        add(lb1);

        JLabel lb2 = new JLabel("Item Code");
        lb2.setBounds(65, 94, 105, 26);
        lb2.setFont(font3);
        lb2.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb2);

        JLabel lb3 = new JLabel("Item Name");
        lb3.setBounds(65, 126, 115, 26);
        lb3.setFont(font3);
        lb3.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb3);

        JLabel lb4 = new JLabel("Unit Price");
        lb4.setBounds(65, 158, 100, 26);
        lb4.setFont(font3);
        lb4.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb4);

        JLabel lb5 = new JLabel("Quantity");
        lb5.setBounds(65, 190, 95, 26);
        lb5.setFont(font3);
        lb5.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb5);

        JLabel lb6 = new JLabel("Selling Price");
        lb6.setBounds(65, 222, 130, 26);
        lb6.setFont(font3);
        lb6.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb6);

        JLabel lb7 = new JLabel("Items In Racks");
        lb7.setBounds(65, 254, 140, 26);
        lb7.setFont(font3);
        lb7.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb7);

        // add textboxes ----------------------------------------------------------
        JTextField itmcode = new JTextField();
        itmcode.setBounds(224, 94, 185, 26);
        itmcode.setFont(font4);
        add(itmcode);

        JTextField itmname = new JTextField();
        itmname.setBounds(224, 126, 379, 26);
        itmname.setFont(font4);
        add(itmname);

        JTextField uprice = new JTextField();
        uprice.setBounds(224, 158, 185, 26);
        uprice.setFont(font4);
        add(uprice);

        JTextField qunty = new JTextField();
        qunty.setBounds(224, 190, 185, 26);
        qunty.setFont(font4);
        add(qunty);

        JTextField amount = new JTextField();
        amount.setBounds(224, 222, 185, 26);
        amount.setFont(font4);
        add(amount);

        JTextField rack = new JTextField();
        rack.setBounds(224, 254, 185, 26);
        rack.setFont(font4);
        add(rack);

        // add panel-----------------------------------------

        String[] columnName = { "Item Name", "Item Code", "Quantity", "Unit Price", "Selling Price", "Total Value",
                "Items in Stocks", "Items in Racks" };

        Object[][] data = null;

        DefaultTableModel model = new DefaultTableModel(data, columnName);

        JTable table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);

        sp.setBounds(65, 290, 707, 425);
        sp.setVisible(true);
        add(sp);

        table.getColumnModel().getColumn(0).setPreferredWidth(150);

        // add buttons ------------------------------------------------------------
        JButton exit = new JButton("Exit");
        exit.setBounds(25, 740, 104, 35);
        exit.setFont(font4);
        exit.setForeground(Color.black);
        exit.setCursor(cur);

        add(exit);

        JButton save = new JButton("Save");
        save.setBounds(685, 740, 130, 35);
        save.setFont(font4);
        save.setForeground(Color.black);
        save.setCursor(cur);
        add(save);

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

        // set window --------------------------------------------------------------
        setSize(850, 830);
        setTitle("Cadenza Billing System - 1.0");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        // add keylisteners -------------------------------------------------------

        // define exit button ------------------------------------------------------
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int yes = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Message", YES_NO_OPTION);

                if (yes == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        // define enter button (itemcode)----------------------------------------------

        itmcode.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();
                Connection conn = null;

                if (keypad == KeyEvent.VK_ENTER) {
                    try {
                        String url = "jdbc:sqlite:D:/Java Codes (Practices)/3.Billing System/Databases/billingsystem.db";
                        conn = DriverManager.getConnection(url);

                        String sql = "SELECT item_name FROM items WHERE item_code = ?";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        pst.setString(1, itmcode.getText());
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {

                            String name = rs.getString("item_name");
                            itmname.setText(name);

                            pst.execute();
                            conn.close();
                            uprice.requestFocus(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid item code");
                            pst.execute();
                            conn.close();
                        }

                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, "Error Found \n" + e1);
                    }
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }
                if (keypad == KeyEvent.VK_F1) {
                    save.requestFocus();
                }

            }

        });

        uprice.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {
                    if (uprice.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill this field.");
                    } else {
                        qunty.requestFocus();
                    }
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }
            }
        });

        qunty.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {
                    if (uprice.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill this field.");
                    } else {
                        amount.requestFocus();
                    }
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }
            }
        });

        amount.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {
                    if (uprice.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill this field.");
                    } else {
                        rack.requestFocus();
                    }
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }
            }
        });

        rack.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {
                    if (rack.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill this field.");
                    } else {

                        Connection conn = null;
                        String url = "jdbc:sqlite:D:/Java Codes (Practices)/3.Billing System/Databases/billingsystem.db";
                        try {
                            conn = DriverManager.getConnection(url);
                            String sql = "SELECT quantity FROM stock WHERE item_code = ?";
                            PreparedStatement pst = conn.prepareStatement(sql);
                            pst.setString(1, itmcode.getText());
                            ResultSet rs = pst.executeQuery();

                            if (rs.next()) {
                                int stVal = Integer.parseInt(rs.getString("quantity"));
                                stVal = stVal + Integer.parseInt(qunty.getText());
                                Val = String.valueOf(stVal);

                            } else {

                                Val = qunty.getText();

                            }

                            conn.close();

                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Error - " + e);
                        }

                        Vector rowList = new Vector<Object>(8);

                        float am = Float.parseFloat(uprice.getText());
                        float qt = Float.parseFloat(qunty.getText());
                        float total_value = am * qt;

                        rowList.add(itmname.getText());
                        rowList.add(itmcode.getText());
                        rowList.add(qunty.getText());
                        rowList.add(uprice.getText());
                        rowList.add(amount.getText());
                        rowList.add(Float.toString(total_value));
                        rowList.add(Val);
                        rowList.add(rack.getText());

                        model.addRow(rowList);

                        itmcode.setText("");
                        itmname.setText("");
                        qunty.setText("");
                        uprice.setText("");
                        amount.setText("");
                        rack.setText("");

                        itmcode.requestFocus();

                    }
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }
            }
        });

        // save button ---------------------------------------------------------

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conn = null;

                try {
                    String url = "jdbc:sqlite:D:/Java Codes (Practices)/3.Billing System/Databases/billingsystem.db";
                    conn = DriverManager.getConnection(url);

                    for (int i = 0; i < table.getRowCount(); i++) {

                        // check stock table ----------------------------------------------

                        String sql1 = "SELECT item_code FROM stock WHERE item_code = ?";
                        PreparedStatement pst1 = conn.prepareStatement(sql1);
                        pst1.setString(1, (String) table.getValueAt(i, 1));
                        ResultSet rs1 = pst1.executeQuery();

                        if (rs1.next()) {

                            String newSql2 = "UPDATE stock SET unit_price = ?, quantity = ?, items_in_rack = ? WHERE item_code = ?";
                            PreparedStatement newPst2 = conn.prepareStatement(newSql2);
                            newPst2.setString(1, (String) table.getValueAt(i, 3));
                            newPst2.setString(2, (String) table.getValueAt(i, 6));
                            newPst2.setString(3, (String) table.getValueAt(i, 7));
                            newPst2.setString(4, (String) table.getValueAt(i, 1));
                            newPst2.executeUpdate();

                        } else {

                            String newSql1 = "INSERT INTO stock (item_code , unit_price , quantity , items_in_rack) VALUES (?,?,?,?)";
                            PreparedStatement newPst1 = conn.prepareStatement(newSql1);
                            newPst1.setString(1, (String) table.getValueAt(i, 1));
                            newPst1.setString(2, (String) table.getValueAt(i, 3));
                            newPst1.setString(3, (String) table.getValueAt(i, 6));
                            newPst1.setString(4, (String) table.getValueAt(i, 7));
                            newPst1.executeUpdate();

                        }

                        // check selling_price table --------------------------------------------

                        String sql2 = "SELECT item_code FROM selling_price WHERE item_code = ?";
                        PreparedStatement pst2 = conn.prepareStatement(sql2);
                        pst2.setString(1, (String) table.getValueAt(i, 1));
                        ResultSet rs2 = pst2.executeQuery();

                        if (rs2.next()) {

                            String newSql4 = "UPDATE selling_price SET selling_price = ? WHERE item_code = ?";
                            PreparedStatement newPst4 = conn.prepareStatement(newSql4);
                            newPst4.setString(1, (String) table.getValueAt(i, 4));
                            newPst4.setString(2, (String) table.getValueAt(i, 1));
                            newPst4.executeUpdate();

                        } else {

                            String newSql3 = "INSERT INTO selling_price (item_code , selling_price) VALUES (?,?)";
                            PreparedStatement newPst3 = conn.prepareStatement(newSql3);
                            newPst3.setString(1, (String) table.getValueAt(i, 1));
                            newPst3.setString(2, (String) table.getValueAt(i, 4));
                            newPst3.executeUpdate();

                        }

                    }

                    conn.close();
                    JOptionPane.showMessageDialog(null, "Saved successfully!");
                    dispose();

                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Error - " + e1);
                }

            }
        });
    }

    void exitwindow() {

        int yes = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Message", YES_NO_OPTION);

        if (yes == JOptionPane.YES_OPTION) {
            dispose();
        }

    }

    public static void main(String[] args) {
        ItemsStock objj = new ItemsStock();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }

}
