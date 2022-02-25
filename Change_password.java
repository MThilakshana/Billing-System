import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.*;

public class Change_password extends JFrame {

    /**
     *
     */

    Change_password() {

        // add fonts -------------------------------------------------------

        Font font1 = new Font("Roboto Slab", Font.BOLD, 20);
        Font font2 = new Font("Roboto Slab", Font.BOLD, 30);
        Font font3 = new Font("Roboto Slab", Font.BOLD, 15);

        // add Cursor ------------------------------------------------------

        Cursor Cur = new Cursor(Cursor.HAND_CURSOR);

        // add text box ----------------------------------------------------

        JTextField unb = new JTextField();
        unb.setBounds(282, 106, 247, 27);
        unb.setHorizontalAlignment(SwingConstants.LEFT);
        unb.setFont(font1);
        add(unb);

        JTextField emb = new JTextField();
        emb.setBounds(282, 153, 247, 27);
        emb.setHorizontalAlignment(SwingConstants.LEFT);
        emb.setFont(font1);
        add(emb);

        JTextField otpb = new JTextField();
        otpb.setBounds(282, 243, 247, 27);
        otpb.setHorizontalAlignment(SwingConstants.LEFT);
        otpb.setFont(font1);
        add(otpb);

        JPasswordField npb = new JPasswordField();
        npb.setBounds(282, 290, 247, 27);
        npb.setHorizontalAlignment(SwingConstants.LEFT);
        npb.setFont(font1);
        add(npb);

        JPasswordField cpb = new JPasswordField();
        cpb.setBounds(282, 337, 247, 27);
        cpb.setHorizontalAlignment(SwingConstants.LEFT);
        cpb.setFont(font1);
        add(cpb);

        // add buttons -----------------------------------------------------

        JButton send = new JButton("Send OTP Code");
        send.setBounds(325, 196, 175, 35);
        send.setFont(font3);
        send.setBackground(new Color(255, 255, 255));
        send.setCursor(Cur);
        add(send);

        JButton exit = new JButton("Exit");
        exit.setBounds(20, 412, 104, 35);
        exit.setFont(font3);
        exit.setBackground(new Color(255, 255, 255));
        exit.setCursor(Cur);
        add(exit);

        JButton cp = new JButton("Change Password");
        cp.setBounds(383, 412, 197, 35);
        cp.setFont(font3);
        cp.setBackground(new Color(255, 255, 255));
        cp.setCursor(Cur);
        add(cp);

        // add labels ------------------------------------------------------

        JLabel head = new JLabel("Change Password");
        head.setBounds(153, 26, 300, 39);
        head.setHorizontalAlignment(SwingConstants.CENTER);
        head.setForeground(new Color(0, 0, 0));
        head.setFont(font2);
        add(head);

        JLabel uname = new JLabel("User Name");
        uname.setBounds(75, 106, 115, 26);
        uname.setHorizontalAlignment(SwingConstants.LEFT);
        uname.setForeground(new Color(0, 0, 0));
        uname.setFont(font1);
        add(uname);

        JLabel email = new JLabel("Email");
        email.setBounds(75, 153, 65, 26);
        email.setHorizontalAlignment(SwingConstants.LEFT);
        email.setForeground(new Color(0, 0, 0));
        email.setFont(font1);
        add(email);

        JLabel otp = new JLabel("OTP Code");
        otp.setBounds(75, 244, 100, 26);
        otp.setHorizontalAlignment(SwingConstants.LEFT);
        otp.setForeground(new Color(0, 0, 0));
        otp.setFont(font1);
        add(otp);

        JLabel npw = new JLabel("New Password");
        npw.setBounds(75, 291, 150, 26);
        npw.setHorizontalAlignment(SwingConstants.LEFT);
        npw.setForeground(new Color(0, 0, 0));
        npw.setFont(font1);
        add(npw);

        JLabel cpw = new JLabel("Confirm Password");
        cpw.setBounds(75, 338, 185, 26);
        cpw.setHorizontalAlignment(SwingConstants.LEFT);
        cpw.setForeground(new Color(0, 0, 0));
        cpw.setFont(font1);
        add(cpw);

        // add images ------------------------------------------------------

        JLabel l1 = new JLabel();
        l1.setIcon(new ImageIcon(getClass().getResource("Rectangle 59.png")));
        l1.setBounds(20, 19, 560, 53);
        add(l1);

        JLabel l2 = new JLabel();
        l2.setIcon(new ImageIcon(getClass().getResource("Rectangle 21.png")));
        l2.setBounds(20, 84, 560, 323);
        add(l2);

        // add panel -------------------------------------------------------

        JPanel p = new JPanel();
        p.setBounds(0, 0, 610, 490);
        p.setBackground(new Color(0, 122, 159));
        add(p);

        // window -----------------------------------------------------------

        setSize(610, 490);
        setTitle("Cadenza Billing System - 1.0");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        // definr exit button ----------------------------------------------

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int yes = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Message", YES_NO_OPTION);
                if (yes == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

    }

    public static void main(String[] args) {
        Change_password obj = new Change_password();
    }
}
