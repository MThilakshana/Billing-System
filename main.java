import java.awt.Color;
import java.awt.Font;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Cursor;
import java.awt.event.*;

public class main extends JFrame {

    JPanel p1;
    JLabel logo, pic1, pic2, lb1, lb2, lb3, lb4;
    JButton exit, printr, cpw, online, newBill, changeP, addnew, addtostock, contact;
    JComboBox reports;

    main() {
        setLayout(null);

        // add font ---------------------------------

        Font font1 = new Font("Roboto Slab", Font.BOLD, 15);
        Font font2 = new Font("Roboto Slab", Font.BOLD, 30);
        Font font3 = new Font("Roboto Slab", Font.BOLD, 20);
        Font font4 = new Font("Roboto Slab", Font.BOLD, 45);

        // add cursor -------------------------------

        Cursor cur = new Cursor(Cursor.HAND_CURSOR);

        // add combo box ----------------------------

        String rep[] = { "", "Daily sales report", "Item list", "Stock report", "Debtor details report" };
        reports = new JComboBox(rep);
        reports.setFont(font1);
        reports.setBounds(500, 130, 300, 26);
        reports.setBackground(new Color(168, 168, 168));
        add(reports);

        // add labels -------------------------------

        lb1 = new JLabel("Billing System");
        lb1.setBounds(273, 19, 300, 39);
        lb1.setFont(font2);
        lb1.setHorizontalAlignment(SwingConstants.CENTER);
        add(lb1);

        lb2 = new JLabel("Print Reports");
        lb2.setBounds(500, 94, 200, 26);
        lb2.setFont(font3);
        lb2.setHorizontalAlignment(SwingConstants.LEFT);
        add(lb2);

        // add Button -------------------------------

        newBill = new JButton("New Bill");
        newBill.setBounds(60, 100, 300, 102);
        newBill.setFont(font4);
        newBill.setBorder(BorderFactory.createBevelBorder(1));
        newBill.setCursor(cur);
        newBill.setAlignmentX(SwingConstants.CENTER);
        add(newBill);

        addnew = new JButton("Add new item");
        addnew.setBounds(60, 230, 300, 50);
        addnew.setCursor(cur);
        addnew.setFont(font3);
        addnew.setAlignmentX(SwingConstants.CENTER);
        add(addnew);

        addtostock = new JButton("Add items to stock");
        addtostock.setBounds(60, 290, 300, 50);
        addtostock.setCursor(cur);
        addtostock.setFont(font3);
        addtostock.setAlignmentX(SwingConstants.CENTER);
        add(addtostock);

        changeP = new JButton("Change item price");
        changeP.setBounds(60, 350, 300, 50);
        changeP.setCursor(cur);
        changeP.setFont(font3);
        changeP.setAlignmentX(SwingConstants.CENTER);
        add(changeP);

        online = new JButton("Online order");
        online.setBounds(60, 410, 300, 50);
        online.setCursor(cur);
        online.setFont(font3);
        online.setAlignmentX(SwingConstants.CENTER);
        add(online);

        cpw = new JButton("Change Password");
        cpw.setBounds(60, 470, 300, 50);
        cpw.setCursor(cur);
        cpw.setFont(font3);
        cpw.setAlignmentX(SwingConstants.CENTER);
        add(cpw);

        contact = new JButton("Contact us");
        contact.setBounds(60, 530, 300, 50);
        contact.setCursor(cur);
        contact.setFont(font3);
        contact.setAlignmentX(SwingConstants.CENTER);
        add(contact);

        exit = new JButton("Exit");
        exit.setBounds(685, 670, 130, 35);
        exit.setFont(font1);
        exit.setForeground(Color.BLACK);
        exit.setCursor(cur);
        add(exit);

        printr = new JButton("Print");
        printr.setBounds(500, 165, 100, 30);
        printr.setFont(font1);
        printr.setForeground(Color.BLACK);
        printr.setCursor(cur);
        add(printr);

        // add image --------------------------------

        pic1 = new JLabel();
        pic1.setIcon(new ImageIcon(getClass().getResource("rec2.png")));
        pic1.setBounds(25, 12, 790, 53);
        add(pic1);

        pic2 = new JLabel();
        pic2.setIcon(new ImageIcon(getClass().getResource("1_img.png")));
        pic2.setBounds(600, 400, 193, 239);
        add(pic2);

        pic2 = new JLabel();
        pic2.setIcon(new ImageIcon(getClass().getResource("rec1.png")));
        pic2.setBounds(25, 40, 790, 648);
        add(pic2);

        // add panel --------------------------------

        p1 = new JPanel();
        p1.setBounds(0, 0, 860, 840);
        p1.setBackground(new Color(0, 122, 159));
        add(p1);

        // set window -------------------------------

        setSize(850, 760);
        setTitle("Cadenza Billing System - 1.0");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        // set exit button --------------------------

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int yes = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Message", YES_NO_OPTION);
                if (yes == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // add commands for buttons ----------------

        addnew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add_new_item obj = new add_new_item();
            }
        });

        addtostock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ItemsStock obj = new ItemsStock();
            }
        });

        newBill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Billing_System_pro obj = new Billing_System_pro();
            }
        });

        changeP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Add_selling_price obj = new Add_selling_price();
            }
        });

        online.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This facility isn't available.", "Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        cpw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Change_password obj = new Change_password();
            }
        });

        contact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Tp - +94775275541\nFax - +94372224077\nEmail - redlinesoft@gmail.com\nAddress - Samanpura,Kurunegala",
                        "Contact Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ;

    }

    public static void main(String[] args) {
        main obj = new main();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }
}
