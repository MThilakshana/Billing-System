
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class Billing_System_pro extends JFrame {

    protected static final int YES_NO_OPTION = 0;
    private JTextField time;
    String dis;
    JTable table;

    float amount, total, finalamount;

    Billing_System_pro() {

        setLayout(null);

        // add font --------------------------------------------------------------
        Font font1 = new Font("Roboto Slab", Font.BOLD, 25);
        Font font2 = new Font("Roboto Slab", Font.BOLD, 30);
        Font font3 = new Font("Roboto Slab", Font.BOLD, 20);
        Font font4 = new Font("Roboto Slab", Font.BOLD, 15);
        Font font5 = new Font("Roboto Slab", Font.PLAIN, 10);

        // add cursor ------------------------------------------------------------
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);

        // add labels ------------------------------------------------------------
        JLabel lb1 = new JLabel("Process Bill");
        lb1.setBounds(323, 19, 200, 39);
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

        JLabel lb6 = new JLabel("Amount");
        lb6.setBounds(65, 222, 85, 26);
        lb6.setFont(font3);
        lb6.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb6);

        JLabel lb7 = new JLabel("Invoice Number");
        lb7.setBounds(442, 158, 172, 26);
        lb7.setFont(font3);
        lb7.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb7);

        JLabel lb8 = new JLabel("Billing Date");
        lb8.setBounds(442, 190, 125, 26);
        lb8.setFont(font3);
        lb8.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb8);

        JLabel lb9 = new JLabel("Time");
        lb9.setBounds(442, 222, 50, 26);
        lb9.setFont(font3);
        lb9.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb9);

        JLabel lb10 = new JLabel("Total Amount");
        lb10.setBounds(608, 256, 140, 26);
        lb10.setFont(font3);
        lb10.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb10);

        JLabel lb11 = new JLabel("Discount");
        lb11.setBounds(608, 310, 95, 26);
        lb11.setFont(font3);
        lb11.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb11);

        JLabel lb12 = new JLabel("Discount(%)");
        lb12.setBounds(608, 366, 125, 26);
        lb12.setFont(font3);
        lb12.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb12);

        JLabel lb13 = new JLabel("Payment Method");
        lb13.setBounds(608, 420, 175, 26);
        lb13.setFont(font3);
        lb13.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb13);

        JLabel lb16 = new JLabel("Return Value");
        lb16.setBounds(608, 474, 140, 26);
        lb16.setFont(font3);
        lb16.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb16);

        JLabel lb17 = new JLabel("Final Amount");
        lb17.setBounds(608, 524, 150, 26);
        lb17.setFont(font3);
        lb17.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb17);

        JLabel lb18 = new JLabel("Payment");
        lb18.setBounds(608, 576, 95, 26);
        lb18.setFont(font3);
        lb18.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb18);

        JLabel lb14 = new JLabel("Balance");
        lb14.setBounds(608, 625, 150, 26);
        lb14.setFont(font3);
        lb14.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb14);

        // add combo box --------------------------------------------------------

        String type[] = { "Cash", "Card" };
        JComboBox paymentmethod = new JComboBox(type);
        paymentmethod.setFont(font3);
        paymentmethod.setBounds(608, 446, 185, 26);
        paymentmethod.setFont(font4);
        add(paymentmethod);

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

        JTextField invoice = new JTextField();
        invoice.setBounds(608, 158, 185, 26);
        invoice.setEditable(false);
        invoice.setFont(font4);
        add(invoice);

        JTextField date = new JTextField();
        date.setBounds(608, 190, 185, 26);
        date.setEditable(false); // this code not give permission to edot this text field
        date.setFont(font4);
        add(date);

        time = new JTextField();
        time.setBounds(608, 222, 185, 26);
        time.setEditable(false);
        time.setFont(font4);
        add(time);

        JTextField tamount = new JTextField();
        tamount.setBounds(608, 282, 185, 26);
        tamount.setFont(font4);
        add(tamount);

        JTextField discount = new JTextField();
        discount.setBounds(608, 338, 185, 26);
        discount.setFont(font4);
        add(discount);

        JTextField discountpr = new JTextField();
        discountpr.setBounds(608, 394, 185, 26);
        discountpr.setFont(font4);
        add(discountpr);

        JTextField rtnVal = new JTextField();
        rtnVal.setBounds(608, 500, 185, 26);
        rtnVal.setFont(font4);
        rtnVal.setEditable(false);
        add(rtnVal);

        JTextField famount = new JTextField();
        famount.setBounds(608, 550, 185, 26);
        famount.setFont(font4);
        famount.setEditable(false);
        add(famount);

        JTextField payment = new JTextField();
        payment.setBounds(608, 602, 185, 26);
        payment.setFont(font4);
        add(payment);

        JTextField balance = new JTextField();
        balance.setBounds(608, 650, 185, 26);
        balance.setFont(font4);
        balance.setEditable(false);
        add(balance);

        // add table --------------------------------------------------------------

        JPanel p = new JPanel();
        p.setBounds(65, 275, 517, 435);
        p.setBackground(new Color(160, 201, 232));
        add(p);

        Object[][] data = null;
        String[] columnName = { "Item Code", "Item name", "Quantity", "Unit Price", "Total Value" };
        DefaultTableModel model = new DefaultTableModel(data, columnName);

        table = new JTable(model);
        table.setBounds(0, 0, 517, 365);
        // JScrollPane sp = new JScrollPane(table);
        // sp.setBounds(0, 0, 517, 365);
        // sp.setVisible(true);
        // add(sp);
        p.add(new JScrollPane(table));
        // add buttons ------------------------------------------------------------

        JButton exit = new JButton("Exit");
        exit.setBounds(25, 740, 104, 35);
        exit.setFont(font4);
        exit.setForeground(Color.black);
        exit.setCursor(cur);
        add(exit);

        JButton saveprint = new JButton("Save & Print");
        saveprint.setBounds(685, 740, 130, 35);
        saveprint.setFont(font4);
        saveprint.setForeground(Color.black);
        saveprint.setCursor(cur);
        add(saveprint);

        JButton addreturn = new JButton("Add Returns");
        addreturn.setBounds(630, 85, 163, 35);
        addreturn.setFont(font4);
        addreturn.setForeground(Color.BLACK);
        addreturn.setCursor(cur);
        add(addreturn);

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

        // generate invoice number --------------------------------------------------

        Connection conn = null;
        String url = "jdbc:sqlite:D:/Java Codes (Practices)/3.Billing System/Databases/billingsystem.db";
        try {
            conn = DriverManager.getConnection(url);
            String sql = "SELECT COUNT(*) FROM details_of_bills";
            PreparedStatement ppst = conn.prepareStatement(sql);
            ResultSet rrs = ppst.executeQuery();
            String Countrow = "";
            while (rrs.next()) {
                Countrow = rrs.getString(1);

                invoice.setText("CAD" + (Integer.parseInt(Countrow) + 1));
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
        }

        // add date ---------------------------------------------------------------

        Date dt = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        date.setText(sf.format(dt));

        // call to the show time
        // ---------------------------------------------------------------

        clock();

        // define exit button ------------------------------------------------------
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitwindow();
            }
        });

        // define return button ------------------------------------------------------

        addreturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Return_item obj2 = new Return_item();
            }
        });

        // define save button --------------------------------------------------------

        saveprint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // data save in deatils_of_bills table
                // ------------------------------------------------------------------------------------------

                Connection conn = null;
                String url = "jdbc:sqlite:D:/Java Codes (Practices)/3.Billing System/Databases/billingsystem.db";

                if (!discount.getText().isEmpty()) {
                    dis = discount.getText();
                }
                if (!discountpr.getText().isEmpty()) {
                    float disA = Float.parseFloat(discountpr.getText()) * Float.parseFloat(tamount.getText()) / 100;
                    dis = Float.toString(disA);
                }
                try {
                    conn = DriverManager.getConnection(url);
                    String sql = "INSERT INTO details_of_bills(invoice_number,total_amount,discount,payment_method,return_amount,final_amount,payment,balance,date,time)VALUES (?,?,?,?,?,?,?,?,?,?) ";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, invoice.getText());
                    pst.setString(2, tamount.getText());
                    pst.setString(3, dis);
                    pst.setString(4, (String) paymentmethod.getSelectedItem());
                    pst.setString(5, rtnVal.getText());
                    pst.setString(6, famount.getText());
                    pst.setString(7, payment.getText());
                    pst.setString(8, balance.getText());
                    pst.setString(9, date.getText());
                    pst.setString(10, time.getText());
                    pst.executeUpdate();

                    // data save in selling_item table
                    // -----------------------------------------------------------------------------------------------------

                    String sql1 = "INSERT INTO selling_item(item_code,quantity,amount,invoice_number) VALUES(?,?,?,?)";
                    PreparedStatement pst1 = conn.prepareStatement(sql1);

                    int cnt = table.getRowCount();

                    for (int i = 0; i < cnt; i++) {
                        Object obj1 = GetData(table, i, 0);
                        Object obj2 = GetData(table, i, 2);
                        Object obj3 = GetData(table, i, 4);
                        String obj4 = invoice.getText();

                        pst1.setString(1, obj1.toString());
                        pst1.setString(2, obj2.toString());
                        pst1.setString(3, obj3.toString());
                        pst1.setString(4, obj4);

                        pst1.executeUpdate();
                    }

                    conn.close();
                    JOptionPane.showMessageDialog(null, "Data saved successfully");

                    dispose();
                    Billing_System_pro BSystem = new Billing_System_pro();

                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Error - " + e2);
                }
            }
        });

        // add key listeners --------------------------------------------------------

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

                        String sql1 = "SELECT selling_price FROM selling_price WHERE item_code = ?";
                        PreparedStatement pst1 = conn.prepareStatement(sql1);
                        pst1.setString(1, itmcode.getText());
                        ResultSet rs1 = pst1.executeQuery();

                        if (rs1.next()) {
                            String name1 = rs1.getString("selling_price");
                            uprice.setText(name1);
                            pst1.execute();
                            Billing_System_pro.this.amount = Float.parseFloat(name1);
                        }

                        if (rs.next()) {
                            String name = rs.getString("item_name");
                            itmname.setText(name);
                            pst.execute();

                            qunty.requestFocus(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid item code");
                            pst.execute();

                        }
                        conn.close();
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, "Error Found \n" + e1);
                    }
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }
                if (keypad == KeyEvent.VK_F1) {
                    discount.requestFocus();
                }

            }
        });

        qunty.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {
                    String n = qunty.getText();
                    float item_amount = Billing_System_pro.this.amount * Float.parseFloat(n);
                    amount.setText(Float.toString(item_amount));
                    amount.requestFocus();
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
                    Vector rowList = new Vector<Object>(5);

                    rowList.add(itmcode.getText());
                    rowList.add(itmname.getText());
                    rowList.add(qunty.getText());
                    rowList.add(uprice.getText());
                    rowList.add(amount.getText());

                    model.addRow(rowList);

                    // update total amount box -------------------------------

                    total = total + Float.parseFloat(amount.getText());
                    tamount.setText(Float.toString(total));

                    itmcode.setText("");
                    itmname.setText("");
                    uprice.setText("");
                    qunty.setText("");
                    amount.setText("");

                    itmcode.requestFocus();
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }
            }
        });

        discount.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {

                    if (!discount.getText().isEmpty()) {
                        finalamount = total - Float.parseFloat(discount.getText());
                        famount.setText(Float.toString(finalamount));
                    }
                    discountpr.requestFocus();
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }
            }
        });

        discountpr.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {
                    if (!discountpr.getText().isEmpty()) {
                        if (discount.getText().isEmpty()) {
                            float x = Float.parseFloat(discountpr.getText());
                            if (x <= 100 && x > 0) {
                                float dis = Float.parseFloat(discountpr.getText()) * total / 100;
                                finalamount = total - dis;
                                famount.setText(Float.toString(finalamount));
                                paymentmethod.requestFocus();
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid range");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Discount already added");
                            discountpr.setText("");
                            paymentmethod.requestFocus();
                        }
                    } else {
                        finalamount = total;
                        famount.setText(Float.toString(finalamount));
                        paymentmethod.requestFocus();
                    }

                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }
            }
        });

        paymentmethod.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {

                    if (paymentmethod.getSelectedIndex() == 1) {
                        float x = finalamount * 2 / 100;
                        finalamount = finalamount + x;
                        famount.setText(Float.toString(finalamount));
                    }
                    payment.requestFocus();
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }

            }
        });

        payment.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent ke) {
                int keypad = ke.getKeyCode();

                if (keypad == KeyEvent.VK_ENTER) {
                    float x = Float.parseFloat(payment.getText()) - finalamount;
                    balance.setText(Float.toString(x));
                    saveprint.requestFocus();
                }
                if (keypad == KeyEvent.VK_ESCAPE) {
                    exitwindow();
                }
            }
        });

    }

    // display_time----------------------------------------------------------------------------------------------

    public void clock() {

        Thread clockt = new Thread() {
            public void run() {
                try {
                    for (;;) { // never ending loop ( ===> while(true))
                        Calendar cal = new GregorianCalendar();

                        int h = cal.get(Calendar.HOUR);
                        int m = cal.get(Calendar.MINUTE);
                        int s = cal.get(Calendar.SECOND);

                        time.setText(h + ":" + m + ":" + s);

                        sleep(1000);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        clockt.start();

    }

    public Object GetData(JTable table, int row, int col) {

        return table.getModel().getValueAt(row, col);

    }

    void exitwindow() {

        int yes = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Message", YES_NO_OPTION);

        if (yes == JOptionPane.YES_OPTION) {
            dispose();
        }

    }

    public static void main(String[] args) {

        Billing_System_pro obj = new Billing_System_pro();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

    }

}