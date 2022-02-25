
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class add_new_item extends JFrame {

    private static final int YES_NO_OPTION = 0;

    add_new_item() {

        setLayout(null);
        // connect database ------------------------------------------

        // add font and cursor ----------------------------------------

        Font font1 = new Font("Roboto Slab", Font.BOLD, 30);
        Font font2 = new Font("Roboto Slab", Font.BOLD, 20);
        Font font3 = new Font("Roboto Slab", Font.BOLD, 15);

        Cursor Cur = new Cursor(Cursor.HAND_CURSOR);

        // add buttons ------------------------------------------------

        JButton exit = new JButton("Exit");
        exit.setBounds(19, 282, 104, 35);
        exit.setFont(font3);
        exit.setCursor(Cur);
        add(exit);

        JButton save = new JButton("Save");
        save.setBounds(705, 282, 104, 35);
        save.setFont(font3);
        save.setCursor(Cur);
        add(save);

        // add Labels -------------------------------------------------

        JLabel lb1 = new JLabel("Add New Items");
        lb1.setBounds(294, 25, 230, 39);
        lb1.setHorizontalAlignment(SwingConstants.CENTER);
        lb1.setFont(font1);
        add(lb1);

        JLabel lb2 = new JLabel("Item Code");
        lb2.setBounds(88, 118, 105, 26);
        lb2.setHorizontalAlignment(SwingConstants.LEFT);
        lb2.setFont(font2);
        add(lb2);

        JLabel lb3 = new JLabel("Item Name");
        lb3.setBounds(88, 161, 110, 26);
        lb3.setHorizontalAlignment(SwingConstants.LEFT);
        lb3.setFont(font2);
        add(lb3);

        JLabel lb4 = new JLabel("Type Of Unit");
        lb4.setBounds(88, 204, 130, 26);
        lb4.setHorizontalAlignment(SwingConstants.LEFT);
        lb4.setFont(font2);
        add(lb4);

        // add text box ----------------------------------------------

        JTextField itemcode = new JTextField();
        itemcode.setBounds(270, 118, 185, 26);
        itemcode.setFont(font3);
        add(itemcode);

        JTextField Itemname = new JTextField();
        Itemname.setBounds(270, 161, 485, 26);
        Itemname.setFont(font3);
        add(Itemname);

        // JTextField unittype = new JTextField();
        // unittype.setBounds(270,204,185,26);
        // unittype.setFont(font3);
        // add(unittype);

        String type[] = { "", "Kilogram", "Kilse", "Liter", "Pices", "Other" };
        JComboBox unittype = new JComboBox(type);
        unittype.setFont(font3);
        unittype.setBounds(270, 204, 185, 26);
        add(unittype);

        // add images --------------------------------------------------

        JLabel pic1 = new JLabel();
        pic1.setIcon(new ImageIcon(getClass().getResource("Rectangle 54.png")));
        pic1.setBounds(19, 84, 790, 186);
        add(pic1);

        JLabel pic2 = new JLabel();
        pic2.setIcon(new ImageIcon(getClass().getResource("rec2.png")));
        pic2.setBounds(19, 19, 790, 53);
        add(pic2);

        // add panels --------------------------------------------------

        JPanel p = new JPanel();
        p.setBounds(0, 0, 843, 365);
        p.setBackground(new Color(0, 122, 159));
        add(p);

        // window -----------------------------------------------------

        setSize(843, 365);
        setTitle("Cadenza Billing System - 1.0");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        // enter button work------------------------------------------

        itemcode.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {

                    if (itemcode.getText().isEmpty()) {

                        JOptionPane.showMessageDialog(null, " Item Code is Empty" + ".");
                    } else {

                        Itemname.requestFocus(true);
                    }
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }
            }
        });

        Itemname.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {

                    if (itemcode.getText().isEmpty()) {

                        JOptionPane.showMessageDialog(null, " Item Name is Empty" + ".");
                    } else {

                        unittype.requestFocus(true);
                    }
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }
            }
        });

        unittype.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {

                    if (itemcode.getText().isEmpty()) {

                        JOptionPane.showMessageDialog(null, " Type of unit is Empty" + ".");
                    } else {

                        save.requestFocus(true);
                    }
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }

            }

        });

        // define exit button -----------------------------------------

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitwindow();
            }
        });

        // define save button -----------------------------------------

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conn = null;

                if (itemcode.getText().isEmpty() || Itemname.getText().isEmpty()
                        || (String) unittype.getSelectedItem() == "") {
                    JOptionPane.showMessageDialog(null, "All Fields Required");
                } else {
                    try {
                        String url = "jdbc:sqlite:D:/Java Codes (Practices)/3.Billing System/Databases/billingsystem.db";
                        conn = DriverManager.getConnection(url);

                        String sql1 = "SELECT item_code FROM items WHERE item_code = ?";
                        PreparedStatement pst = conn.prepareStatement(sql1);
                        pst.setString(1, itemcode.getText());
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Item code already added");
                            conn.close();
                        } else {
                            String sql = "INSERT INTO items(item_code , item_name, type_of_unit) VALUES (? , ?, ?)";
                            PreparedStatement pstmt = conn.prepareStatement(sql);
                            pstmt.setString(1, itemcode.getText());
                            pstmt.setString(2, Itemname.getText());
                            pstmt.setString(3, (String) unittype.getSelectedItem());
                            pstmt.executeUpdate();
                            conn.close();
                            JOptionPane.showMessageDialog(null, "Saved Successfully");
                            itemcode.setText("");
                            Itemname.setText("");
                            unittype.setSelectedIndex(0);
                        }

                    } catch (SQLException e1) {
                        System.out.println(e1);
                    }

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

        // look and feel
        // code--------------------------------------------------------------------------------

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        add_new_item obj = new add_new_item();
    }
}
