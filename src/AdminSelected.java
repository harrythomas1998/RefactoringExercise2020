import javax.swing.*;

public class AdminSelected {

    Menu menu;


    public void selectedAdmin(){
        boolean loop = true, loop2 = true;
        boolean cont = false;
        while(loop)
        {
            Object adminUsername = JOptionPane.showInputDialog(menu.f, "Enter Administrator Username:");

            if(!adminUsername.equals("admin"))//search admin list for admin with matching admin username
            {
                int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Username. Try again?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    loop = true;
                }
                else if(reply == JOptionPane.NO_OPTION)
                {
                    menu.f1.dispose();
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
            Object adminPassword = JOptionPane.showInputDialog(menu.f, "Enter Administrator Password;");

            if(!adminPassword.equals("admin11"))//search admin list for admin with matching admin password
            {
                int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Password. Try again?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {

                }
                else if(reply == JOptionPane.NO_OPTION){
                    menu.f1.dispose();
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
            menu.f1.dispose();
            loop = false;
            menu.admin();
        }

    }
}
