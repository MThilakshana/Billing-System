import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;

import static javax.swing.JOptionPane.YES_NO_OPTION;

import javax.swing.*;

public class Add_selling_price extends JFrame {

    Connection conn = null;
    String url = "jdbc:sqlite:D:/Java Codes (Practices)/3.Billing System/Databases/billingsystem.db";

    Add_selling_price() {

        setLayout(null);

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

        JLabel lb1 = new JLabel("Add Selling Price");
        lb1.setBounds(291, 25, 255, 39);
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

        JLabel lb4 = new JLabel("Selling Price of Unit");
        lb4.setBounds(88, 204, 200, 26);
        lb4.setHorizontalAlignment(SwingConstants.LEFT);
        lb4.setFont(font2);
        add(lb4);

        // add text box ----------------------------------------------

        JTextField itemcode = new JTextField();
        itemcode.setBounds(314, 118, 185, 26);
        itemcode.setFont(font3);
        add(itemcode);

        JTextField Itemname = new JTextField();
        Itemname.setBounds(314, 161, 485, 26);
        Itemname.setFont(font3);
        add(Itemname);

        JTextField unittype = new JTextField();
        unittype.setBounds(314, 204, 185, 26);
        unittype.setFont(font3);
        add(unittype);

        JTextField unit = new JTextField();
        unit.setBounds(508, 204, 100, 26);
        unit.setFont(font3);
        add(unit);

        // add images --------------------------------------------------

        JLabel pic1 = new JLabel();
        pic1.setIcon(new ImageIcon(getClass().getResource("Rectangle 54.png")));
        pic1.setBounds(19, 84, 790, 186);
        add(pic1);

        JLabel pic2 = new JLabel();
        pic2.setIcon(new ImageIcon(getClass().getResource("rec2.png")));
        pic2.setBounds(19, 19, 790, 53);
        add(pic2);

        // add panels -------------------------------------------------

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

        // add keyListeners --------------------------------------------

        itemcode.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {
                    if (itemcode.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Enter Item Code");
                    } else {

                        try {
                            conn = DriverManager.getConnection(url);

                            // item name -----------------------------------------------------

                            String sql = "SELECT item_name FROM items WHERE item_code = ?";
                            PreparedStatement pst = conn.prepareStatement(sql);
                            pst.setString(1, itemcode.getText());
                            ResultSet rs = pst.executeQuery();

                            if (rs.next()) {
                                Itemname.setText(rs.getString("item_name"));
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Item Code");
                            }

                            // add unity type ------------------------------------------------

                            String sql2 = "SELECT type_of_unit FROM items WHERE item_code = ?";
                            PreparedStatement pst2 = conn.prepareStatement(sql2);
                            pst2.setString(1, itemcode.getText());
                            ResultSet rs2 = pst2.executeQuery();

                            if (rs2.next()) {
                                unit.setText(rs2.getString("type_of_unit"));
                            }

                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Error - " + e);
                        }

                        unittype.requestFocus();
                    }
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitWindow();
                }
            }
        });

        unittype.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {
                    if (unittype.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Fill This Field");
                    } else {
                        save.requestFocus();
                    }
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitWindow();
                }
            }
        });

        // define buttons -----------------------------------------------

        exit.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitWindow();
            }

        });

        // define save button -------------------------------------------

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String sql = "UPDATE selling_price SET selling_price = ? WHERE item_code = ?";
                try {
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, unittype.getText());
                    pst.setString(2, itemcode.getText());
                    pst.executeUpdate();

                    conn.close();
                    JOptionPane.showMessageDialog(null, "Data Updated!");

                    dispose();

                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Erro - " + e1);
                }

            }
        });

    }

    public void exitWindow() {
        int yes = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Messege", YES_NO_OPTION);

        if (yes == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    public static void main(String[] args) {
        Add_selling_price obj = new Add_selling_price();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }
}
