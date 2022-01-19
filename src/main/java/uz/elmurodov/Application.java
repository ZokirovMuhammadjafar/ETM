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

        else if ("CRETE ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("CRETE_ORGANIZATION"))  organisationUI.create();
        else if ("BLOCK ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("BLOCK_ORGANIZATION"))  organisationUI.block();
        else if ("UNBLOCK ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_ORGANIZATION"))  organisationUI.unblock();
        else if ("DELETE ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("DELETE_ORGANIZATION"))  organisationUI.delete();
        else if ("LIST ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("LIST_ORGANIZATION"))  organisationUI.list();

        else if ("CRETE ADMIN".equals(choice) && SecurityHolder.hasPermission("CRETE_ADMIN"))  authUI.createAdmin();
        else if ("BLOCK ADMIN".equals(choice) && SecurityHolder.hasPermission("BLOCK_ADMIN"))  authUI.blockAdmin();
        else if ("UNBLOCK ADMIN".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_ADMIN"))  authUI.unblockAdmin();
        else if ("DELETE ADMIN".equals(choice) && SecurityHolder.hasPermission("DELETE_ADMIN"))  authUI.deleteAdmin();
        else if ("UPDATE ADMIN".equals(choice) && SecurityHolder.hasPermission("UPDATE_ADMIN"))  authUI.updateAdmin();
        else if ("LIST ADMIN".equals(choice) && SecurityHolder.hasPermission("LIST_ADMIN"))  authUI.listAdmin();

        else if ("CRETE PROJECT".equals(choice) && SecurityHolder.hasPermission("CRETE_PROJECT"))  projectUI.create();
        else if ("BLOCK PROJECT".equals(choice) && SecurityHolder.hasPermission("BLOCK_PROJECT"))  projectUI.block();
        else if ("UNBLOCK PROJECT".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_PROJECT"))  projectUI.unblock();
        else if ("DELETE PROJECT".equals(choice) && SecurityHolder.hasPermission("DELETE_PROJECT"))  projectUI.delete();
        else if ("UPDATE PROJECT".equals(choice) && SecurityHolder.hasPermission("UPDATE_PROJECT"))  projectUI.update();
        else if ("LIST PROJECT".equals(choice) && SecurityHolder.hasPermission("LIST_PROJECT"))  projectUI.list();

        else if ("CRETE COLUMN".equals(choice) && SecurityHolder.hasPermission("CRETE_COLUMN"))  columnUI.create();
        else if ("BLOCK COLUMN".equals(choice) && SecurityHolder.hasPermission("BLOCK_COLUMN"))  columnUI.block();
        else if ("UNBLOCK COLUMN".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_COLUMN"))  columnUI.unblock();
        else if ("DELETE COLUMN".equals(choice) && SecurityHolder.hasPermission("DELETE_COLUMN"))  columnUI.delete();
        else if ("UPDATE COLUMN".equals(choice) && SecurityHolder.hasPermission("UPDATE_COLUMN"))  columnUI.update();
        else if ("LIST COLUMN".equals(choice) && SecurityHolder.hasPermission("LIST_COLUMN"))  columnUI.list();

        else if ("CRETE TASK".equals(choice) && SecurityHolder.hasPermission("CRETE_TASK"))  taskUI.create();
        else if ("BLOCK TASK".equals(choice) && SecurityHolder.hasPermission("BLOCK_TASK"))  taskUI.block();
        else if ("UNBLOCK TASK".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_TASK"))  taskUI.unblock();
        else if ("DELETE TASK".equals(choice) && SecurityHolder.hasPermission("DELETE_TASK"))  taskUI.delete();
        else if ("UPDATE TASK".equals(choice) && SecurityHolder.hasPermission("UPDATE_TASK"))  taskUI.update();
        else if ("LIST TASK".equals(choice) && SecurityHolder.hasPermission("LIST_TASK"))  taskUI.list();



        run();
    }
}
