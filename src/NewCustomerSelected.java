import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class NewCustomerSelected implements CustomerArrayInterface{

    Menu menu;
    String PPS, surname, firstName, DOB, CustomerID, password;



    public void newCustomerSelected(){

        menu.f.dispose();
        menu.f1 = new JFrame("Create New Customer");
        menu.f1.setSize(400, 300);
        menu.f1.setLocation(200, 200);
        menu.f1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });
        Container content = menu.f1.getContentPane();
        content.setLayout(new BorderLayout());

        menu.firstNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
        menu.surnameLabel = new JLabel("Surname:", SwingConstants.RIGHT);
        menu.pPPSLabel = new JLabel("PPS Number:", SwingConstants.RIGHT);
        menu.dOBLabel = new JLabel("Date of birth", SwingConstants.RIGHT);
        menu.firstNameTextField = new JTextField(20);
        menu.surnameTextField = new JTextField(20);
        menu.pPSTextField = new JTextField(20);
        menu.dOBTextField = new JTextField(20);
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(menu.firstNameLabel);
        panel.add(menu.firstNameTextField);
        panel.add(menu.surnameLabel);
        panel.add(menu.surnameTextField);
        panel.add(menu.pPPSLabel);
        panel.add(menu.pPSTextField);
        panel.add(menu.dOBLabel);
        panel.add(menu.dOBTextField);

        menu.panel2 = new JPanel();
        menu.add = new JButton("Add");

        menu.add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                PPS = menu.pPSTextField.getText();
                firstName = menu.firstNameTextField.getText();
                surname = menu.surnameTextField.getText();
                DOB = menu.dOBTextField.getText();
                password = "";

                menu.CustomerID = "ID"+menu.PPS ;






                menu.add.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        menu.f1.dispose();

                        boolean loop = true;
                        while(loop){
                            password = JOptionPane.showInputDialog(menu.f, "Enter 7 character Password;");

                            if(password.length() != 7)//Making sure password is 7 characters
                            {
                                JOptionPane.showMessageDialog(null, null, "Password must be 7 charatcers long", JOptionPane.OK_OPTION);
                            }
                            else
                            {
                                loop = false;
                            }
                        }




                        ArrayList<CustomerAccount> accounts = new ArrayList<CustomerAccount> ();
                        Customer customer = new Customer(PPS, surname, firstName, DOB, CustomerID, password, accounts);

                        customerList.add(customer);

                        JOptionPane.showMessageDialog(menu.f, "CustomerID = " + CustomerID +"\n Password = " + password  ,"Customer created.",  JOptionPane.INFORMATION_MESSAGE);
                        menu.menuStart();
                        menu.f.dispose();
                    }
                });
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.f1.dispose();
                menu.menuStart();
            }
        });

        menu.panel2.add(menu.add);
        menu.panel2.add(cancel);

        content.add(panel, BorderLayout.CENTER);
        content.add(menu.panel2, BorderLayout.SOUTH);

        menu.f1.setVisible(true);
    }
}
