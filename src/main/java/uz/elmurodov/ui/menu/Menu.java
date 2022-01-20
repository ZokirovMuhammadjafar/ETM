package uz.elmurodov.ui.menu;

import uz.elmurodov.security.PermissionsItem;
import uz.elmurodov.security.RolesItem;
import uz.elmurodov.security.SecurityHolder;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

import static uz.elmurodov.security.SecurityHolder.permissions;

public class Menu {


    public static void getMainMenu() {
        if (Objects.isNull(SecurityHolder.session)) {
            Print.println(Color.YELLOW, "Login -> LOGIN");
        } else {
            for (RolesItem rolesItem : SecurityHolder.session.getRoles()) {
                if (rolesItem.getName().toUpperCase(Locale.ROOT).equals("ADMIN")) {


                    Print.println(Color.CYAN, "add members to project -> ADD_MEMBERS_TO_PROJECT");
                    Print.println(Color.CYAN, "remove members to project -> REMOVE_MEMBERS_TO_PROJECT");
                    Print.println(Color.CYAN, "block members to project -> BLOCK_MEMBERS_TO_PROJECT");
                    Print.println(Color.CYAN, "unblock members to project -> UNBLOCK_MEMBERS_TO_PROJECT");
                    Print.println(Color.CYAN, "list members to project -> LIST_MEMBERS_TO_PROJECT");

                    Print.println(Color.CYAN, "create project -> CREATE_PROJECT");
                    Print.println(Color.CYAN, "block project -> BLOCK_PROJECT");
                    Print.println(Color.CYAN, "unblock project -> UNBLOCK_PROJECT");
                    Print.println(Color.CYAN, "delete project -> DELETE_PROJECT");
                    Print.println(Color.CYAN, "update project -> UPDATE_PROJECT");

                    Print.println(Color.CYAN, "create column -> CREATE_COLUMN");
                    Print.println(Color.CYAN, "block column -> BLOCK_COLUMN");
                    Print.println(Color.CYAN, "unblock column -> UNBLOCK_COLUMN");
                    Print.println(Color.CYAN, "delete column -> DELETE_COLUMN");
                    Print.println(Color.CYAN, "update column -> UPDATE_COLUMN");
                    Print.println(Color.CYAN, "list column -> LIST_COLUMN");

                    Print.println(Color.CYAN, "create task -> CREATE_TASK");
                    Print.println(Color.CYAN, "block task -> BLOCK_TASK");
                    Print.println(Color.CYAN, "unblock task -> UNBLOCK_TASK");
                    Print.println(Color.CYAN, "delete task -> DELETE_TASK");
                    Print.println(Color.CYAN, "update task -> UPDATE_TASK");
                    Print.println(Color.CYAN, "list task -> LIST_TASK");

                    Print.println(Color.CYAN, "create comment -> CREATE_COMMENT");








                } else if (rolesItem.getName().toUpperCase(Locale.ROOT).equals("SUPER_USER")) {
                } else if (Pattern.matches("((SUPER_USER) | (EMPLOYEE) | (HR))", rolesItem.getName().toUpperCase(Locale.ROOT))) {
                    permissions.forEach(permissionsItem -> Print.println(Color.CYAN, permissionsItem.getName() + " -> " + permissionsItem.getCode()));
                } else if (rolesItem.getName().toUpperCase(Locale.ROOT).equals("MANAGER")) {

                }
            }
        }
        Print.println(Color.YELLOW, "Exit -> EXIT");
    }
}
