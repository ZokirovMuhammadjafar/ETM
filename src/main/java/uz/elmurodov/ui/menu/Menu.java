package uz.elmurodov.ui.menu;

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
            permissions.forEach(permissionsItem -> Print.println(Color.CYAN, permissionsItem.getName() + " -> " + permissionsItem.getCode()));
            Print.println(Color.YELLOW, "logout -> LOGOUT");
        }
        Print.println(Color.YELLOW, "Exit -> EXIT");
    }
/*
    private static void employeeMenu() {
        Print.println(Color.CYAN, "show my tasks -> SHOW_MY_TASKS");
        Print.println(Color.CYAN, "write comment -> WRITE_COMMENT");
        Print.println(Color.CYAN, "finish task -> FINISH_TASK");

    }


    private static void createEMPLOYEEMenu() {
        Print.println(Color.CYAN, "create EMPLOYEE -> CREATE_PROJECT");
        Print.println(Color.CYAN, "block EMPLOYEE -> BLOCK_PROJECT");
        Print.println(Color.CYAN, "unblock EMPLOYEE -> UNBLOCK_PROJECT");
        Print.println(Color.CYAN, "delete EMPLOYEE -> DELETE_PROJECT");
        Print.println(Color.CYAN, "list EMPLOYEE -> LIST_PROJECTS");
    }

    private static void createHRMenu() {
        Print.println(Color.CYAN, "create HR -> CREATE_PROJECT");
        Print.println(Color.CYAN, "block HR -> BLOCK_PROJECT");
        Print.println(Color.CYAN, "unblock HR -> UNBLOCK_PROJECT");
        Print.println(Color.CYAN, "delete HR -> DELETE_PROJECT");
        Print.println(Color.CYAN, "list HR -> LIST_PROJECTS");
    }

    private static void createMANAGERMenu() {
        Print.println(Color.CYAN, "create MANAGER -> CREATE_PROJECT");
        Print.println(Color.CYAN, "block MANAGER -> BLOCK_PROJECT");
        Print.println(Color.CYAN, "unblock MANAGER -> UNBLOCK_PROJECT");
        Print.println(Color.CYAN, "delete MANAGER -> DELETE_PROJECT");
        Print.println(Color.CYAN, "list MANAGER -> LIST_PROJECTS");
    }


    private static void projectMenu() {
        Print.println(Color.CYAN, "create project -> CREATE_PROJECT");
        Print.println(Color.CYAN, "block project -> BLOCK_PROJECT");
        Print.println(Color.CYAN, "unblock project -> UNBLOCK_PROJECT");
        Print.println(Color.CYAN, "delete project -> DELETE_PROJECT");
        Print.println(Color.CYAN, "list projects -> LIST_PROJECTS");
        Print.println(Color.CYAN, "update project -> UPDATE_PROJECT");
    }

    public static void projectUpdateMenu() {
        Print.println(Color.CYAN, "add members to project -> ADD_MEMBERS_TO_PROJECT");
        Print.println(Color.CYAN, "remove members from project -> REMOVE_MEMBERS_FROM_PROJECT");
        Print.println(Color.CYAN, "block members in project -> BLOCK_MEMBERS_IN_PROJECT");
        Print.println(Color.CYAN, "unblock members in project -> UNBLOCK_MEMBERS_IN_PROJECT");
        Print.println(Color.CYAN, "list members in project -> LIST_MEMBERS_IN_PROJECT");

        Print.println(Color.CYAN, "create column -> CREATE_COLUMN");
        Print.println(Color.CYAN, "delete column -> DELETE_COLUMN");
        Print.println(Color.CYAN, "list column -> LIST_COLUMN");
        Print.println(Color.CYAN, "update column -> UPDATE_COLUMN");

    }

    public static void columnUpdateMenu() {
        Print.println(Color.CYAN, "create task -> CREATE_TASK");
        Print.println(Color.CYAN, "block task -> BLOCK_TASK");
        Print.println(Color.CYAN, "unblock task -> UNBLOCK_TASK");
        Print.println(Color.CYAN, "delete task -> DELETE_TASK");
        Print.println(Color.CYAN, "list task -> LIST_TASK");
        Print.println(Color.CYAN, "update task -> UPDATE_TASK");
    }

    public static void taskUpdateMenu() {
        Print.println(Color.CYAN, "add members to task -> ADD_MEMBERS_TO_TASK");
        Print.println(Color.CYAN, "remove members from task -> REMOVE_MEMBERS_TO_TASK");
        Print.println(Color.CYAN, "list members to task -> LIST_MEMBERS_FROM_TASK");

        Print.println(Color.CYAN, "write comment -> WRITE_COMMENT");


    }*/
}
