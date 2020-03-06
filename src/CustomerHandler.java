import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

public class CustomerHandler extends Menu implements MenuInterface {

    public CustomerHandler(Customer e1){

        f = new JFrame("Customer Menu");
        e = e1;
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });
        f.setVisible(true);

        if(e.getAccounts().size() == 0)
        {
            JOptionPane.showMessageDialog(f, "This customer does not have any accounts yet. \n An admin must create an account for this customer \n for them to be able to use customer functionality. " ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
            f.dispose();
            menuStart();
        }
        else
        {
            JPanel buttonPanel = new JPanel();
            JPanel boxPanel = new JPanel();
            JPanel labelPanel = new JPanel();

            JLabel label = new JLabel("Select Account:");
            labelPanel.add(label);

            JButton returnButton = new JButton("Return");
            buttonPanel.add(returnButton);
            JButton continueButton = new JButton("Continue");
            buttonPanel.add(continueButton);

            JComboBox<String> box = new JComboBox<>();
            for (int i =0; i < e.getAccounts().size(); i++)
            {
                box.addItem(e.getAccounts().get(i).getNumber());
            }

            for(int i = 0; i<e.getAccounts().size(); i++)
            {
                if(e.getAccounts().get(i).getNumber() == box.getSelectedItem() )
                {
                    acc = e.getAccounts().get(i);
                }
            }

            boxPanel.add(box);
            content = f.getContentPane();
            content.setLayout(new GridLayout(3, 1));
            content.add(labelPanel);
            content.add(boxPanel);
            content.add(buttonPanel);

            returnButton.addActionListener(ae -> {
                f.dispose();
                menuStart();
            });

            continueButton.addActionListener(ae -> {

                f.dispose();

                f = new JFrame("Customer Menu");
                f.setSize(400, 300);
                f.setLocation(200, 200);
                f.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) { System.exit(0); }
                });
                f.setVisible(true);

                JPanel statementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JButton statementButton = new JButton("Display Bank Statement");
                statementButton.setPreferredSize(new Dimension(250, 20));

                statementPanel.add(statementButton);

                JPanel lodgementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JButton lodgementButton = new JButton("Lodge money into account");
                lodgementPanel.add(lodgementButton);
                lodgementButton.setPreferredSize(new Dimension(250, 20));

                JPanel withdrawalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JButton withdrawButton = new JButton("Withdraw money from account");
                withdrawalPanel.add(withdrawButton);
                withdrawButton.setPreferredSize(new Dimension(250, 20));

                JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                JButton returnButton1 = new JButton("Exit Customer Menu");
                returnPanel.add(returnButton1);

                JLabel label1 = new JLabel("Please select an option");

                content = f.getContentPane();
                content.setLayout(new GridLayout(5, 1));
                content.add(label1);
                content.add(statementPanel);
                content.add(lodgementPanel);
                content.add(withdrawalPanel);
                content.add(returnPanel);

                statementButton.addActionListener(ae1 -> {
                    f.dispose();
                    f = new JFrame("Customer Menu");
                    f.setSize(400, 600);
                    f.setLocation(200, 200);
                    f.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent we) { System.exit(0); }
                    });
                    f.setVisible(true);

                    JLabel label11 = new JLabel("Summary of account transactions: ");

                    JPanel returnPanel1 = new JPanel();
                    JButton returnButton11 = new JButton("Return");
                    returnPanel1.add(returnButton11);

                    JPanel textPanel = new JPanel();

                    textPanel.setLayout( new BorderLayout() );
                    JTextArea textArea = new JTextArea(40, 20);
                    textArea.setEditable(false);
                    textPanel.add(label11, BorderLayout.NORTH);
                    textPanel.add(textArea, BorderLayout.CENTER);
                    textPanel.add(returnButton11, BorderLayout.SOUTH);

                    JScrollPane scrollPane = new JScrollPane(textArea);
                    textPanel.add(scrollPane);

                    for (int i = 0; i < acc.getTransactionList().size(); i ++)
                    {
                        textArea.append(acc.getTransactionList().get(i).toString());
                    }

                    textPanel.add(textArea);
                    content.removeAll();

                    Container content = f.getContentPane();
                    content.setLayout(new GridLayout(1, 1));
                    //	content.add(label1);
                    content.add(textPanel);
                    //content.add(returnPanel);

                    returnButton11.addActionListener(ae11 -> {
                        f.dispose();
                        customer(e);
                    });
                });

                lodgementButton.addActionListener(ae12 -> {
                    boolean loop;
                    boolean on = true;
                    double balance = 0;

                    if(acc instanceof CustomerCurrentAccount)
                    {
                        int count = 3;
                        int checkPin = ((CustomerCurrentAccount) acc).getAtm().getPin();
                        loop = true;

                        while(loop)
                        {
                            if(count == 0)
                            {
                                JOptionPane.showMessageDialog(f, "Pin entered incorrectly 3 times. ATM card locked."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
                                ((CustomerCurrentAccount) acc).getAtm().setValid(false);
                                customer(e);
                                loop = false;
                                on = false;
                            }

                            String Pin = JOptionPane.showInputDialog(f, "Enter 4 digit PIN;");
                            int i = Integer.parseInt(Pin);

                            if(on)
                            {
                                if(checkPin == i)
                                {
                                    loop = false;
                                    JOptionPane.showMessageDialog(f, "Pin entry successful" ,  "Pin", JOptionPane.INFORMATION_MESSAGE);

                                }
                                else
                                {
                                    count --;
                                    JOptionPane.showMessageDialog(f, "Incorrect pin. " + count + " attempts remaining."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
                                }

                            }
                        }

                    }
                    if(on)
                    {
                        String balanceTest = JOptionPane.showInputDialog(f, "Enter amount you wish to lodge:");//the isNumeric method tests to see if the string entered was numeric.
                        if(IsNumeric.isNumeric(balanceTest))
                        {
                            balance = Double.parseDouble(balanceTest);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(f, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
                        }

                        String euro = "\u20ac";
                        acc.setBalance(acc.getBalance() + balance);
                        // String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                        Date date = new Date();
                        String date2 = date.toString();
                        String type = "Lodgement";
                        double amount = balance;

                        AccountTransaction transaction = new AccountTransaction(date2, type, amount);
                        acc.getTransactionList().add(transaction);

                        JOptionPane.showMessageDialog(f, balance + euro + " added do you account!" ,"Lodgement",  JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() + euro ,"Lodgement",  JOptionPane.INFORMATION_MESSAGE);
                    }

                });

                withdrawButton.addActionListener(ae13 -> {
                    boolean loop;
                    boolean on = true;
                    double withdraw = 0;

                    if(acc instanceof CustomerCurrentAccount)
                    {
                        int count = 3;
                        int checkPin = ((CustomerCurrentAccount) acc).getAtm().getPin();
                        loop = true;

                        while(loop)
                        {
                            if(count == 0)
                            {
                                JOptionPane.showMessageDialog(f, "Pin entered incorrectly 3 times. ATM card locked."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
                                ((CustomerCurrentAccount) acc).getAtm().setValid(false);
                                customer(e);
                                loop = false;
                                on = false;
                            }

                            String Pin = JOptionPane.showInputDialog(f, "Enter 4 digit PIN;");
                            int i = Integer.parseInt(Pin);

                            if(on)
                            {
                                if(checkPin == i)
                                {
                                    loop = false;
                                    JOptionPane.showMessageDialog(f, "Pin entry successful" ,  "Pin", JOptionPane.INFORMATION_MESSAGE);

                                }
                                else
                                {
                                    count --;
                                    JOptionPane.showMessageDialog(f, "Incorrect pin. " + count + " attempts remaining."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
                                }

                            }
                        }

                    }
                    if(on)
                    {
                        String balanceTest = JOptionPane.showInputDialog(f, "Enter amount you wish to withdraw (max 500):");//the isNumeric method tests to see if the string entered was numeric.
                        if(IsNumeric.isNumeric(balanceTest))
                        {

                            withdraw = Double.parseDouble(balanceTest);

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(f, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
                        }
                        if(withdraw > 500)
                        {
                            JOptionPane.showMessageDialog(f, "500 is the maximum you can withdraw at a time." ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
                            withdraw = 0;
                        }
                        if(withdraw > acc.getBalance())
                        {
                            JOptionPane.showMessageDialog(f, "Insufficient funds." ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
                            withdraw = 0;
                        }

                        String euro = "\u20ac";
                        acc.setBalance(acc.getBalance()-withdraw);
                        //recording transaction:
                        //		String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                        Date date = new Date();
                        String date2 = date.toString();

                        String type = "Withdraw";
                        double amount = withdraw;

                        AccountTransaction transaction = new AccountTransaction(date2, type, amount);
                        acc.getTransactionList().add(transaction);

                        JOptionPane.showMessageDialog(f, withdraw + euro + " withdrawn." ,"Withdraw",  JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() + euro ,"Withdraw",  JOptionPane.INFORMATION_MESSAGE);
                    }

                });

                returnButton1.addActionListener(ae14 -> {
                    f.dispose();
                    menuStart();
                });		});
        }
    }


}
