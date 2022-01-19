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
        if ("LOGIN".equals(choice)) authUI.login();
        else if ("CRETE ORGANISATION".equals(choice) && SecurityHolder.hasPermission("CRETE_ORGANISATION"))
            organisationUI.create();
        else if ("BLOCK ORGANISATION".equals(choice) && SecurityHolder.hasPermission("BLOCK_ORGANISATION"))
            organisationUI.block();
        else if ("UNBLOCK ORGANISATION".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_ORGANISATION"))
            organisationUI.unblock();
        else if ("DELETE ORGANISATION".equals(choice) && SecurityHolder.hasPermission("DELETE_ORGANISATION"))
            organisationUI.delete();
        else if ("LIST ORGANISATION".equals(choice) && SecurityHolder.hasPermission("LIST_ORGANISATION"))
            organisationUI.list();
        else if ("CRETE ADMIN".equals(choice) && SecurityHolder.hasPermission("CRETE_ADMIN"))
            authUI.createAdmin();
        else if ("BLOCK ADMIN".equals(choice) && SecurityHolder.hasPermission("BLOCK_ADMIN"))
            authUI.blockAdmin();
        else if ("UNBLOCK ADMIN".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_ADMIN"))
            authUI.unblockAdmin();
        else if ("DELETE ADMIN".equals(choice) && SecurityHolder.hasPermission("DELETE_ADMIN"))
            authUI.deleteAdmin();
        else if ("UPDATE ADMIN".equals(choice) && SecurityHolder.hasPermission("UPDATE_ADMIN"))
            authUI.updateAdmin();
        else if ("LIST ADMIN".equals(choice) && SecurityHolder.hasPermission("LIST_ADMIN"))
            authUI.listAdmin();



            /*else if ("UPDATE ORGANISATION".equals(choice) && SecurityHolder.hasPermission("UPDATE_ORGANISATION")) {
            organisationUI.update();
        }*/
        run();
    }
}
