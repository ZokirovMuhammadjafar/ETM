package uz.elmurodov.security;

import lombok.*;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Getter
@ToString
public class SecurityHolder {
    public static SessionUser session;
    public static SessionOrganization sessionOrganization;
    public static SessionProject sessionProject;
    public static SessionColumn sessionColumn;
    public static SessionTask sessionTask;
    public static SessionComment sessionComment;

    public static List<PermissionsItem> permissions;

    public static boolean hasPermission(String permission) {
        if (Objects.isNull(session))
            throw new RuntimeException("NOT_AUTHORIZED");
        for (PermissionsItem sessionPermission : session.getPermissions()) {
            if (sessionPermission.getCode().equals(permission)) return true;
        }
        return false;
    }

    public static void setSession(SessionUser just_session) {
        permissions = just_session.getPermissions();
        session = just_session;
    }



}
