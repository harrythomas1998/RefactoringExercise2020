import javax.swing.*;
import java.util.Objects;

public class AdminSelected extends Menu implements MenuInterface{

    public AdminSelected(){

        boolean loop = true, loop2 = true;
        boolean cont = false;
        while(loop)
        {
            Object adminUsername = JOptionPane.showInputDialog(f, "Enter Administrator Username:");

            if(!adminUsername.equals("admin"))//search admin list for admin with matching admin username
            {
                int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Username. Try again?", JOptionPane.YES_NO_OPTION);
                switch (reply) {
                    case JOptionPane.YES_OPTION:
                        break;
                    case JOptionPane.NO_OPTION:
                        f1.dispose();
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
            Object adminPassword = JOptionPane.showInputDialog(f, "Enter Administrator Password;");

            if(!Objects.equals(adminPassword, "admin11"))//search admin list for admin with matching admin password
            {
                int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Password. Try again?", JOptionPane.YES_NO_OPTION);
                switch (reply) {
                    case JOptionPane.YES_OPTION:

                        break;
                    case JOptionPane.NO_OPTION:
                        f1.dispose();
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

            loop = false;
            admin();
        }
    }
}
