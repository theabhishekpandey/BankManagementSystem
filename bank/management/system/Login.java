package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;
    Login()
    {
        super("ABC Bank of India");
        ImageIcon bankimg= new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bankim=bankimg.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon banki=new ImageIcon(bankim);
        JLabel image=new JLabel(banki);
        image.setBounds(350, 10, 100, 100);
        add(image);

        ImageIcon cardimg= new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image cardim=cardimg.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon cardi=new ImageIcon(cardim);
        JLabel cimage=new JLabel(cardi);
        cimage.setBounds(630, 350, 100, 100);
        add(cimage);

        label1=new  JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230, 125, 450, 40);
        add(label1);

        label2=new  JLabel("Card No.");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setBounds(150, 190, 375, 30);
        add(label2);

        textField2=new JTextField(15);
        textField2.setBounds(325, 190, 238, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField2);

        label3=new  JLabel("PIN");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Ralway", Font.BOLD, 28));
        label3.setBounds(150, 250, 375, 30);
        add(label3);

        passwordField3=new JPasswordField(15);
        passwordField3.setBounds(325,250, 238, 30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);

        button1=new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD,14));
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE); 
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2=new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD,14));
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE); 
        button2.setBounds(480,300,100,30);
        button2.addActionListener(this);
        add(button2);

        button3=new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD,14));
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.WHITE); 
        button3.setBounds(315,350,250,30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii3= new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image ii3=iii3.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(ii3);
        JLabel bimage=new JLabel(i3);
        bimage.setBounds(0, 0, 850, 480);
        add(bimage);

        setLayout(null);
        setSize(850, 480);
        setLocation(350, 180);
        //setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==button1)
            {
                Connect c = new Connect();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String q = "select * from login where cardno = '"+cardno+"' and  pin = '"+pin+"'";
                ResultSet resultSet=c.statement.executeQuery(q);
                if(resultSet.next())
                {
                    setVisible(false);
                    new main_Class(pin);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            }
            else if(e.getSource()==button2)
            {
                textField2.setText("");
                passwordField3.setText("");
            }
        else if (e.getSource() == button3){
            new Signup();
            setVisible(false);
        }
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        new Login();
    }
}