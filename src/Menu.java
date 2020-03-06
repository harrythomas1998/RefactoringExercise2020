import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements MenuInterface {

	String password;
	int position = 0;
	Customer customer = null;
	CustomerAccount acc = new CustomerAccount();
	JFrame f, f1;
	JLabel firstNameLabel, surnameLabel, pPPSLabel, dOBLabel;
	JTextField firstNameTextField, surnameTextField, pPSTextField, dOBTextField;
	JLabel customerIDLabel, passwordLabel;
	JTextField customerIDTextField, passwordTextField;
	Container content;
	Customer e;
	JPanel panel2;
	JButton add;
	String 	PPS,firstName,surname,DOB,CustomerID;

	public static void main(String[] args) {
		Menu driver = new Menu();
		driver.menuStart();
	}

	public void menuStart() {

		f = new JFrame("User Type");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});

		JPanel userTypePanel = new JPanel();
		final ButtonGroup userType = new ButtonGroup();
		JRadioButton radioButton;
		userTypePanel.add(radioButton = new JRadioButton("Existing Customer"));
		radioButton.setActionCommand("Customer");
		userType.add(radioButton);

		userTypePanel.add(radioButton = new JRadioButton("Administrator"));
		radioButton.setActionCommand("Administrator");
		userType.add(radioButton);

		userTypePanel.add(radioButton = new JRadioButton("New Customer"));
		radioButton.setActionCommand("New Customer");
		userType.add(radioButton);

		JPanel continuePanel = new JPanel();
		JButton continueButton = new JButton("Continue");
		continuePanel.add(continueButton);

		Container content = f.getContentPane();
		content.setLayout(new GridLayout(2, 1));
		content.add(userTypePanel);
		content.add(continuePanel);

		continueButton.addActionListener(ae -> {
			String user = userType.getSelection().getActionCommand(  );

			if(user.equals("New Customer")) {
				new NewCustomerSelected();
			}

			if(user.equals("Administrator")	) {
				new AdminSelected();
			}

			if(user.equals("Customer")	) {
				new CustomerSelected();
			}

		});f.setVisible(true);
	}

	public void admin() {
		new AdminHandler();
	}

	public void customer(Customer e1) {
		new CustomerHandler(e1);
	}

	public void setFields(){
		firstNameTextField.setText(customerList.get(position).getFirstName());
		surnameTextField.setText(customerList.get(position).getSurname());
		pPSTextField.setText(customerList.get(position).getPPS());
		dOBTextField.setText(customerList.get(position).getDOB());
		customerIDTextField.setText(customerList.get(position).getCustomerID());
		passwordTextField.setText(customerList.get(position).getPassword());
	}

	public void setFieldZero(){
		firstNameTextField.setText(customerList.get(0).getFirstName());
		surnameTextField.setText(customerList.get(0).getSurname());
		pPSTextField.setText(customerList.get(0).getPPS());
		dOBTextField.setText(customerList.get(0).getDOB());
		customerIDTextField.setText(customerList.get(0).getCustomerID());
		passwordTextField.setText(customerList.get(0).getPassword());
	}

	public void setLabels(){
		firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
		surnameLabel = new JLabel("Surname:", SwingConstants.LEFT);
		pPPSLabel = new JLabel("PPS Number:", SwingConstants.LEFT);
		dOBLabel = new JLabel("Date of birth", SwingConstants.LEFT);
		customerIDLabel = new JLabel("CustomerID:", SwingConstants.LEFT);
		passwordLabel = new JLabel("Password:", SwingConstants.LEFT);
		firstNameTextField = new JTextField(20);
		surnameTextField = new JTextField(20);
		pPSTextField = new JTextField(20);
		dOBTextField = new JTextField(20);
		customerIDTextField = new JTextField(20);
		passwordTextField = new JTextField(20);
	}
}

