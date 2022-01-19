package uz.elmurodov;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.ui.auth.AuthUI;
import uz.elmurodov.ui.column.ColumnUI;
import uz.elmurodov.ui.comment.CommentUI;
import uz.elmurodov.ui.menu.Menu;
import uz.elmurodov.ui.organisation.OrganisationUI;
import uz.elmurodov.ui.project.ProjectUI;
import uz.elmurodov.ui.task.TaskUI;
import uz.jl.utils.Input;

public class Application {

    private static AuthUI authUI;
    private static OrganisationUI organisationUI;
    private static ProjectUI projectUI;
    private static ColumnUI columnUI;
    private static TaskUI taskUI;
    private static CommentUI commentUI;

    public static void main(String[] args) {
        authUI = UNIContainer.getBean(AuthUI.class);
        organisationUI = UNIContainer.getBean(OrganisationUI.class);
        projectUI = UNIContainer.getBean(ProjectUI.class);
        columnUI = UNIContainer.getBean(ColumnUI.class);
        taskUI = UNIContainer.getBean(TaskUI.class);
        commentUI = UNIContainer.getBean(CommentUI.class);

        Application.run();
    }

    private static void run() {
        Menu.getMainMenu();
        String choice = Input.getStr("Your choice: ").toUpperCase();
        if ("LOGIN".equals(choice)) {
            authUI.login();
        } else if ("CREATE_ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("CREATE_ORGANIZATION")) {
            organisationUI.create();
        } else if ("BLOCK_ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("BLOCK_ORGANIZATION")) {
            organisationUI.block();
        } else if ("UNBLOCK_ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_ORGANIZATION")) {
            organisationUI.unblock();
        } else if ("DELETE_ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("DELETE_ORGANIZATION")) {
            organisationUI.delete();
        } else if ("UPDATE_ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("UPDATE_ORGANIZATION")) {
            organisationUI.update();
        } else if ("LIST_ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("LIST_ORGANIZATION")) {
            organisationUI.list();
        } else if ("CRETE_ADMIN".equals(choice) && SecurityHolder.hasPermission("CRETE_ADMIN")) {
            authUI.createAdmin();
        } else if ("BLOCK_ADMIN".equals(choice) && SecurityHolder.hasPermission("BLOCK_ADMIN")) {
            authUI.blockAdmin();
        } else if ("UNBLOCK_ADMIN".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_ADMIN")) {
            authUI.unblockAdmin();
        } else if ("DELETE ADMIN".equals(choice) && SecurityHolder.hasPermission("DELETE_ADMIN")) {
            authUI.deleteAdmin();
        } else if ("UPDATE ADMIN".equals(choice) && SecurityHolder.hasPermission("UPDATE_ADMIN")) {
            authUI.updateAdmin();
        } else if ("LIST ADMIN".equals(choice) && SecurityHolder.hasPermission("LIST_ADMIN")) {
            authUI.listAdmin();
        }

        run();
    }
}
