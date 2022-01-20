package uz.elmurodov;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.ui.auth.AuthUI;
import uz.elmurodov.ui.column.ColumnUI;
import uz.elmurodov.ui.comment.CommentUI;
import uz.elmurodov.ui.label.LabelUI;
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
    private static LabelUI labelUI;

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
        organisationUI.list();
        if ("LOGIN".equals(choice)) authUI.login();
        else if ("CREATE ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("CREATE_ORGANIZATION"))
            organisationUI.create();
        else if ("LIST_ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("LIST_ORGANIZATION"))
            organisationUI.list();
        else if ("CREATE ADMIN".equals(choice) && SecurityHolder.hasPermission("CREATE_ADMIN")) authUI.createAdmin();
        else if ("LIST ADMIN".equals(choice) && SecurityHolder.hasPermission("LIST_ADMIN")) authUI.listAdmin();
        else if ("CREATE PROJECT".equals(choice) && SecurityHolder.hasPermission("CREATE_PROJECT")) projectUI.create();
        else if ("LIST PROJECT".equals(choice) && SecurityHolder.hasPermission("LIST_PROJECT")) projectUI.list();

        else if ("CREATE COLUMN".equals(choice) && SecurityHolder.hasPermission("CREATE_COLUMN")) columnUI.create();
        else if ("LIST PROJECT".equals(choice) && SecurityHolder.hasPermission("LIST_PROJECT")) projectUI.list();

        else if ("CREATE COLUMN".equals(choice) && SecurityHolder.hasPermission("CREATE_COLUMN")) columnUI.create();
        else if ("LIST COLUMN".equals(choice) && SecurityHolder.hasPermission("LIST_COLUMN")) columnUI.list();

        else if ("CREATE TASK".equals(choice) && SecurityHolder.hasPermission("CREATE_TASK")) taskUI.create();
        else if ("UPDATE TASK".equals(choice) && SecurityHolder.hasPermission("UPDATE_TASK")) taskUI.update();
        else if ("LIST TASK".equals(choice) && SecurityHolder.hasPermission("LIST_TASK")) taskUI.list();
        else if ("ADD MEMBER TO PROJECT".equals(choice) && SecurityHolder.hasPermission("UPDATE_LABEL"))
            taskUI.update();
        else if ("ADD_MEMBERS_TO_TASK".equals(choice) && SecurityHolder.hasPermission("ADD_MEMBERS_TO_TASK"))
            taskUI.addMember();


//        else if ("BLOCK ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("BLOCK_ORGANIZATION"))
//            organisationUI.block();
//        else if ("UNBLOCK_ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_ORGANIZATION"))
//            organisationUI.unblock();
//        else if ("DELETE_ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("DELETE_ORGANIZATION"))
//            organisationUI.delete();
//        else if ("UPDATE_ORGANIZATION".equals(choice) && SecurityHolder.hasPermission("UPDATE_ORGANIZATION"))
//            organisationUI.update();
//        else if ("BLOCK ADMIN".equals(choice) && SecurityHolder.hasPermission("BLOCK_ADMIN")) authUI.blockAdmin();
//        else if ("UNBLOCK ADMIN".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_ADMIN")) authUI.unblockAdmin();
//        else if ("DELETE ADMIN".equals(choice) && SecurityHolder.hasPermission("DELETE_ADMIN")) authUI.deleteAdmin();
//        else if ("UPDATE ADMIN".equals(choice) && SecurityHolder.hasPermission("UPDATE_ADMIN")) authUI.updateAdmin();

//        else if ("BLOCK PROJECT".equals(choice) && SecurityHolder.hasPermission("BLOCK_PROJECT")) projectUI.block();
//        else if ("UNBLOCK PROJECT".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_PROJECT"))
//            projectUI.unblock();
//        else if ("DELETE PROJECT".equals(choice) && SecurityHolder.hasPermission("DELETE_PROJECT")) projectUI.delete();
//        else if ("UPDATE PROJECT".equals(choice) && SecurityHolder.hasPermission("UPDATE_PROJECT")) projectUI.update();
//        else if ("BLOCK COLUMN".equals(choice) && SecurityHolder.hasPermission("BLOCK_COLUMN")) columnUI.block();
//        else if ("UNBLOCK COLUMN".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_COLUMN")) columnUI.unblock();
//        else if ("DELETE COLUMN".equals(choice) && SecurityHolder.hasPermission("DELETE_COLUMN")) columnUI.delete();
//        else if ("UPDATE COLUMN".equals(choice) && SecurityHolder.hasPermission("UPDATE_COLUMN")) columnUI.update();
//        else if ("BLOCK TASK".equals(choice) && SecurityHolder.hasPermission("BLOCK_TASK")) taskUI.block();
//        else if ("UNBLOCK TASK".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_TASK")) taskUI.unblock();
//        else if ("DELETE TASK".equals(choice) && SecurityHolder.hasPermission("DELETE_TASK")) taskUI.delete();

//        else if ("CREATE COMMENT".equals(choice) && SecurityHolder.hasPermission("CREATE_TASK")) taskUI.create();

//        else if ("CREATE LABEL".equals(choice) && SecurityHolder.hasPermission("CREATE_LABEL")) taskUI.create();
//        else if ("DELETE LABEL".equals(choice) && SecurityHolder.hasPermission("DELETE_LABEL")) taskUI.delete();
//        else if ("LIST LABEL".equals(choice) && SecurityHolder.hasPermission("LIST_LABEL")) taskUI.list();
//        else if ("UPDATE LABEL".equals(choice) && SecurityHolder.hasPermission("UPDATE_LABEL")) taskUI.update();
//

//        else if ("UPDATE LABEL".equals(choice) && SecurityHolder.hasPermission("UPDATE_LABEL")) taskUI.update();
//        else if ("CREATE HR".equals(choice) && SecurityHolder.hasPermission("CREATE_HR")) authUI.createHR();
//        else if ("BLOCK HR".equals(choice) && SecurityHolder.hasPermission("BLOCK_HR")) authUI.blockHR();
//        else if ("UNBLOCK HR".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_HR")) authUI.unblockHR();
//        else if ("DELETE HR".equals(choice) && SecurityHolder.hasPermission("DELETE_HR")) authUI.deleteHR();
//        else if ("UPDATE HR".equals(choice) && SecurityHolder.hasPermission("UPDATE_HR")) authUI.updateHR();
//        else if ("LIST HR".equals(choice) && SecurityHolder.hasPermission("LIST_HR")) authUI.listHR();
//
//        else if ("CREATE MANAGER".equals(choice) && SecurityHolder.hasPermission("CREATE_MANAGER"))
//            authUI.createMANAGER();
//        else if ("BLOCK MANAGER".equals(choice) && SecurityHolder.hasPermission("BLOCK_MANAGER")) authUI.blockMANAGER();
//        else if ("UNBLOCK MANAGER".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_MANAGER"))
//            authUI.unblockMANAGER();
//        else if ("DELETE MANAGER".equals(choice) && SecurityHolder.hasPermission("DELETE_MANAGER"))
//            authUI.deleteMANAGER();
//        else if ("UPDATE MANAGER".equals(choice) && SecurityHolder.hasPermission("UPDATE_MANAGER"))
//            authUI.updateMANAGER();
//        else if ("LIST MANAGER".equals(choice) && SecurityHolder.hasPermission("LIST_MANAGER")) authUI.listMANAGER();
//
//        else if ("CREATE EMPLOYEE".equals(choice) && SecurityHolder.hasPermission("CREATE_EMPLOYEE"))
//            authUI.createEMPLOYEE();
//        else if ("BLOCK EMPLOYEE".equals(choice) && SecurityHolder.hasPermission("BLOCK_EMPLOYEE"))
//            authUI.blockEMPLOYEE();
//        else if ("UNBLOCK EMPLOYEE".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_EMPLOYEE"))
//            authUI.unblockEMPLOYEE();
//        else if ("DELETE EMPLOYEE".equals(choice) && SecurityHolder.hasPermission("DELETE_EMPLOYEE"))
//            authUI.deleteEMPLOYEE();
//        else if ("UPDATE EMPLOYEE".equals(choice) && SecurityHolder.hasPermission("UPDATE_EMPLOYEE"))
//            authUI.updateEMPLOYEE();
//        else if ("LIST EMPLOYEE".equals(choice) && SecurityHolder.hasPermission("LIST_EMPLOYEE")) authUI.listEMPLOYEE();
//
//

//        else if ("REMOVE_MEMBERS_TO_TASK".equals(choice) && SecurityHolder.hasPermission("REMOVE_MEMBERS_TO_TASK"))
//            taskUI.removeMember();
//        else if ("BLOCK_MEMBERS_TO_TASK".equals(choice) && SecurityHolder.hasPermission("BLOCK_MEMBERS_TO_TASK"))
//            taskUI.blockMember();
//        else if ("UNBLOCK_MEMBERS_TO_TASK".equals(choice) && SecurityHolder.hasPermission("UNBLOCK_MEMBERS_TO_TASK"))
//            taskUI.UnblockMember();
//        else if ("LIST_MEMBERS_TO_TASK".equals(choice) && SecurityHolder.hasPermission("LIST_MEMBERS_TO_TASK"))
//            taskUI.listMembers();

        run();
    }
}
