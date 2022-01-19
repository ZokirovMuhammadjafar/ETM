package uz.elmurodov.container;

import uz.elmurodov.property.ApplicationProperties;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.auth.AuthUserRepositoryImpl;
import uz.elmurodov.repository.organization.OrganizationRepositoryImpl;
import uz.elmurodov.services.auth.AuthUserService;
import uz.elmurodov.services.organization.OrganizationService;
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
    private static final AuthUI AUTHUI;
    private static final OrganisationUI ORGANISATIONUI;
    private static final ProjectUI PROJECTUI;
    private static final TaskUI TASKUI;
    private static final CommentUI COMMENTUI;
    private static final ColumnUI COLUMNUI;
    private static final ApplicationProperties APPLICATION_PROPERTIES;
    private static final DatabaseProperties DATABASE_PROPERTIES;
    private static Connection CONNECTION;
    private final static AuthUserRepositoryImpl AUTH_USER_REPOSITORY;
    private final static AuthUserService AUTH_USER_SERVICE;
    private final static OrganizationService ORGANIZATION_SERVICE;
    private final static OrganizationRepositoryImpl ORGANIZATION_REPOSITORY;


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
    }

    public static <T> T getBean(Class<T> bean) {
        return getBean(bean.getSimpleName().toUpperCase(Locale.ROOT));
    }

    public static <T> T getBean(String bean) {
        bean = bean.toUpperCase(Locale.ROOT);
        return switch (bean) {
            case "APPLICATIONPROPERTIES" -> (T) APPLICATION_PROPERTIES;
            case "DATABASEPROPERTIES" -> (T) DATABASE_PROPERTIES;
            case "CONNECTION" -> (T) CONNECTION;
            case "AUTHUSERSERVICE" -> (T) AUTH_USER_SERVICE;
            case "AUTHUSERREPOSITORY" -> (T) AUTH_USER_REPOSITORY;
            case "AUTHUI" -> (T) AUTHUI;
            case "ORGANISATIONUI" -> (T) ORGANISATIONUI;
            case "PROJECTUI" -> (T) PROJECTUI;
            case "TASKUI" -> (T) TASKUI;
            case "COMMENTUI" -> (T) COMMENTUI;
            case "COLUMNUI" -> (T) COLUMNUI;
            default -> throw new RuntimeException("Bean Not Found");
        };
    }


}
