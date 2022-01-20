package uz.elmurodov.container;

import uz.elmurodov.property.ApplicationProperties;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.auth.AuthUserRepositoryImpl;
import uz.elmurodov.repository.column.ColumnRepositoryImpl;
import uz.elmurodov.repository.comment.CommentRepositoryImpl;
import uz.elmurodov.repository.label.LabelRepositoryImpl;
import uz.elmurodov.repository.organization.OrganizationRepositoryImpl;
import uz.elmurodov.repository.project.ProjectRepositoryImpl;
import uz.elmurodov.repository.task.TaskRepositoryImpl;
import uz.elmurodov.services.auth.AuthUserService;
import uz.elmurodov.services.column.ColumnService;
import uz.elmurodov.services.comment.CommentService;
import uz.elmurodov.services.label.LabelService;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.services.project.ProjectService;
import uz.elmurodov.services.task.TaskService;
import uz.elmurodov.ui.auth.AuthUI;
import uz.elmurodov.ui.column.ColumnUI;
import uz.elmurodov.ui.comment.CommentUI;
import uz.elmurodov.ui.organisation.OrganisationUI;
import uz.elmurodov.ui.project.ProjectUI;
import uz.elmurodov.ui.task.TaskUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class UNIContainer {
    private static Connection CONNECTION;
    private static final AuthUI AUTHUI;
    private static final OrganisationUI ORGANISATIONUI;
    private static final ProjectUI PROJECTUI;
    private static final TaskUI TASKUI;
    private static final CommentUI COMMENTUI;
    private static final ColumnUI COLUMNUI;
    private static final ApplicationProperties APPLICATION_PROPERTIES;
    private static final DatabaseProperties DATABASE_PROPERTIES;
    private static final AuthUserRepositoryImpl AUTH_USER_REPOSITORY;
    private static final AuthUserService AUTH_USER_SERVICE;
    private static final OrganizationRepositoryImpl ORGANIZATION_REPOSITORY;
    private static final OrganizationService ORGANIZATION_SERVICE;
    private static final ProjectRepositoryImpl PROJECT_REPOSITORY;
    private static final ProjectService PROJECT_SERVICE;
    private static final ColumnRepositoryImpl COLUMN_REPOSITORY;
    private static final ColumnService COLUMN_SERVICE;
    private static final TaskRepositoryImpl TASK_REPOSITORY;
    private static final TaskService TASK_SERVICE;
    private static final CommentRepositoryImpl COMMENT_REPOSITORY;
    private static final CommentService COMMENT_SERVICE;
    private static final LabelRepositoryImpl LABEL_REPOSITORY;
    private static final LabelService LABEL_SERVICE;


    static {
        AUTHUI = new AuthUI();
        ORGANISATIONUI = new OrganisationUI();
        PROJECTUI = new ProjectUI();
        TASKUI = new TaskUI();
        COMMENTUI = new CommentUI();
        COLUMNUI = new ColumnUI();

        APPLICATION_PROPERTIES = new ApplicationProperties();
        DATABASE_PROPERTIES = new DatabaseProperties();
        try {
            CONNECTION = DriverManager.getConnection(
                    APPLICATION_PROPERTIES.get("db.jdbc"),
                    APPLICATION_PROPERTIES.get("db.username"),
                    APPLICATION_PROPERTIES.get("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AUTH_USER_REPOSITORY = new AuthUserRepositoryImpl();
        AUTH_USER_SERVICE = new AuthUserService(AUTH_USER_REPOSITORY);

        ORGANIZATION_REPOSITORY = new OrganizationRepositoryImpl();
        ORGANIZATION_SERVICE = new OrganizationService(ORGANIZATION_REPOSITORY);

        PROJECT_REPOSITORY = new ProjectRepositoryImpl();
        PROJECT_SERVICE = new ProjectService(PROJECT_REPOSITORY);
        COLUMN_REPOSITORY = new ColumnRepositoryImpl();
        COLUMN_SERVICE = new ColumnService(COLUMN_REPOSITORY);
        TASK_REPOSITORY = new TaskRepositoryImpl();
        TASK_SERVICE = new TaskService(TASK_REPOSITORY);
        COMMENT_REPOSITORY = new CommentRepositoryImpl();
        COMMENT_SERVICE = new CommentService(COMMENT_REPOSITORY);
        LABEL_REPOSITORY = new LabelRepositoryImpl();
        LABEL_SERVICE = new LabelService(LABEL_REPOSITORY);


    }

    public static <T> T getBean(Class<T> bean) {
        return getBean(bean.getSimpleName().toUpperCase(Locale.ROOT));
    }

    public static <T> T getBean(String bean) {
        bean = bean.toUpperCase(Locale.ROOT);
        return switch (bean) {
            case "CONNECT" -> (T) CONNECTION;
            case "AUTHUI" -> (T) AUTHUI;
            case "ORGANISATIONUI" -> (T) ORGANISATIONUI;
            case "PROJECTUI" -> (T) PROJECTUI;
            case "TASKUI" -> (T) TASKUI;
            case "COMMENTUI" -> (T) COMMENTUI;
            case "COLUMNUI" -> (T) COLUMNUI;
            case "APPLICATIONPROPERTIES" -> (T) APPLICATION_PROPERTIES;
            case "DATABASEPROPERTIES" -> (T) DATABASE_PROPERTIES;
            case "AUTHUSERREPOSITORY" -> (T) AUTH_USER_REPOSITORY;
            case "AUTHUSERSERVICE" -> (T) AUTH_USER_SERVICE;
            case "ORGANIZATIONREPOSITORY" -> (T) ORGANIZATION_REPOSITORY;
            case "ORGANIZATIONSERVICE" -> (T) ORGANIZATION_SERVICE;
            case "PROJECTREPOSITORY" -> (T) PROJECT_REPOSITORY;
            case "PROJECTSERVICE" -> (T) PROJECT_SERVICE;
            case "COLUMNREPOSITORY" -> (T) COLUMN_REPOSITORY;
            case "COLUMNSERVICE" -> (T) COLUMN_SERVICE;
            case "TASKREPOSITORY" -> (T) TASK_REPOSITORY;
            case "TASKSERVICE" -> (T) TASK_SERVICE;
            case "COMMENTREPOSITORY" -> (T) COMMENT_REPOSITORY;
            case "COMMENTSERVICE" -> (T) COMMENT_SERVICE;
            case "LABELREPOSITORY" -> (T) LABEL_REPOSITORY;
            case "LABELSERVICE" -> (T) LABEL_SERVICE;


            default -> throw new RuntimeException("Bean Not Found");
        };
    }


}
