package regEx;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegistrationForm1 extends JFrame implements ActionListener {

    // Class-level variables
    JTextField tfusername;
    JPasswordField tfpassword;
    JTextField tfemail;
    JTextField tfmobile;

    JRadioButton rbmale;
    JRadioButton rbfemale;

    JButton btnregister;

    RegistrationForm1() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // ---------------- USERNAME ----------------

        JLabel lblusername = new JLabel("USERNAME =");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(180, 20, 150, 30);
        add(tfusername);

        // ---------------- PASSWORD ----------------

        JLabel lblpassword = new JLabel("PASSWORD =");
        lblpassword.setBounds(40, 80, 100, 30);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(180, 80, 150, 30);
        add(tfpassword);

        // ---------------- EMAIL ----------------

        JLabel lblemail = new JLabel("E-Mail =");
        lblemail.setBounds(40, 140, 100, 30);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(180, 140, 150, 30);
        add(tfemail);

        // ---------------- MOBILE ----------------

        JLabel lblmobile = new JLabel("Mobile No. =");
        lblmobile.setBounds(40, 200, 100, 30);
        add(lblmobile);

        tfmobile = new JTextField();
        tfmobile.setBounds(180, 200, 150, 30);
        add(tfmobile);

        // ---------------- GENDER ----------------

        JLabel lblgender = new JLabel("GENDER =");
        lblgender.setBounds(40, 260, 100, 30);
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(180, 260, 70, 30);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(250, 260, 80, 30);
        add(rbfemale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbmale);
        genderGroup.add(rbfemale);

        // ---------------- REGISTER BUTTON ----------------

        btnregister = new JButton("REGISTER");
        btnregister.setBounds(180, 310, 150, 40);
        add(btnregister);

        btnregister.addActionListener(this);

        // ---------------- IMAGE ----------------

        ImageIcon icon = new ImageIcon("src/regEx/registration.png");

        Image img = icon.getImage();

        Image newImg = img.getScaledInstance(
                200,
                250,
                Image.SCALE_SMOOTH
        );

        JLabel imageLabel = new JLabel(new ImageIcon(newImg));
        imageLabel.setBounds(350, 50, 200, 250);
        add(imageLabel);

        // ---------------- FRAME ----------------

        setSize(600, 400);
        setLocation(450, 200);
        setVisible(true);
    }

    // ---------------- ACTION PERFORMED ----------------

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = tfusername.getText();

        String password = new String(tfpassword.getPassword());

        String email = tfemail.getText();

        String mobile = tfmobile.getText();

        // ---------------- REGEX ----------------

        String usernameRegex = "^[A-Za-z]{3,20}$";

        String passwordRegex =
                "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";

        String emailRegex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        String mobileRegex =
                "^[6-9][0-9]{9}$";

        // ---------------- USERNAME VALIDATION ----------------

        if (!username.matches(usernameRegex)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username"
            );

            return;
        }

        // ---------------- PASSWORD VALIDATION ----------------

        if (!password.matches(passwordRegex)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Password\n"
                    + "Password must contain:\n"
                    + "1 uppercase\n"
                    + "1 lowercase\n"
                    + "1 number\n"
                    + "1 special character\n"
                    + "Minimum 8 characters"
            );

            return;
        }

        // ---------------- EMAIL VALIDATION ----------------

        if (!email.matches(emailRegex)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Email"
            );

            return;
        }

        // ---------------- MOBILE VALIDATION ----------------

        if (!mobile.matches(mobileRegex)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Mobile Number"
            );

            return;
        }

        // ---------------- GENDER VALIDATION ----------------

        if (!rbmale.isSelected() && !rbfemale.isSelected()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please Select Gender"
            );

            return;
        }

        // ---------------- SUCCESS ----------------

        JOptionPane.showMessageDialog(
                this,
                "Registration Successful!"
        );
    }

    // ---------------- MAIN ----------------

    public static void main(String[] args) {

        new RegistrationForm1();
    }
}