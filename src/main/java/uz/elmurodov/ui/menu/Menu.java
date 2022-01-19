package uz.elmurodov.ui.menu;

import uz.elmurodov.security.PermissionsItem;
import uz.elmurodov.security.SecurityHolder;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.Objects;

import static uz.elmurodov.security.SecurityHolder.permissions;

public class Menu {


    public static void getMainMenu() {
        if (Objects.isNull(SecurityHolder.session)) {
            Print.println(Color.YELLOW, "Login -> LOGIN");
        } else {
            for (PermissionsItem permission : permissions) {
                Print.println(Color.YELLOW, permission.getName() + " -> " + permission.getCode());
            }
            Print.println(Color.YELLOW, "Logout -> LOGOUT");
        }
        Print.println(Color.YELLOW, "Exit -> EXIT");

    }
}
