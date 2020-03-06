import javax.swing.*;

public class CustomerSelected extends Menu implements MenuInterface{


    public CustomerSelected(){

        boolean loop = true, loop2 = true;
        boolean cont = false;
        boolean found = false;
        Customer customer = null;
        while(loop)
        {
            Object customerID = JOptionPane.showInputDialog(f, "Enter Customer ID:");

            for (Customer aCustomer: customerList){

                if(aCustomer.getCustomerID().equals(customerID))//search customer list for matching customer ID
                {
                    found = true;
                    customer = aCustomer;
                }
            }

            if(!found)
            {
                int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
                switch (reply) {
                    case JOptionPane.YES_OPTION:
                        break;
                    case JOptionPane.NO_OPTION:
                        f.dispose();
                        loop = false;
                        loop2 = false;
                        menuStart();
                        break;
                }
            }
            else
            {
                loop = false;
            }

        }

        while(loop2)
        {
            Object customerPassword = JOptionPane.showInputDialog(f, "Enter Customer Password;");

            if(!customer.getPassword().equals(customerPassword))//check if custoemr password is correct
            {
                int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect password. Try again?", JOptionPane.YES_NO_OPTION);
                switch (reply) {
                    case JOptionPane.YES_OPTION:

                        break;
                    case JOptionPane.NO_OPTION:

                        loop2 = false;
                        menuStart();
                        break;
                }
            }
            else
            {
                loop2 =false;
                cont = true;
            }
        }

        if(cont)
        {

            customer(customer);
        }
    }
}
