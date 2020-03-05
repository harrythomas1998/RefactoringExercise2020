import javax.swing.*;
import java.util.ArrayList;

public class CustomerSelected implements CustomerArrayInterface {

    Menu menu;




    public void customerSelected(){

        boolean loop = true, loop2 = true;
        boolean cont = false;
        boolean found = false;
        Customer customer = null;
        while(loop)
        {
            Object customerID = JOptionPane.showInputDialog(menu.f, "Enter Customer ID:");

            for (Customer aCustomer: customerList){

                if(aCustomer.getCustomerID().equals(customerID))//search customer list for matching customer ID
                {
                    found = true;
                    customer = aCustomer;
                }
            }

            if(found == false)
            {
                int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    loop = true;
                }
                else if(reply == JOptionPane.NO_OPTION)
                {
                    menu.f.dispose();
                    loop = false;
                    loop2 = false;
                    menu.menuStart();
                }
            }
            else
            {
                loop = false;
            }

        }

        while(loop2)
        {
            Object customerPassword = JOptionPane.showInputDialog(menu.f, "Enter Customer Password;");

            if(!customer.getPassword().equals(customerPassword))//check if custoemr password is correct
            {
                int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect password. Try again?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {

                }
                else if(reply == JOptionPane.NO_OPTION){
                    menu.f.dispose();
                    loop2 = false;
                    menu.menuStart();
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
            menu.f.dispose();
            loop = false;
            menu.customer(customer);
        }
    }
}
