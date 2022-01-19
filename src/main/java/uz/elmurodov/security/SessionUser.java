package uz.elmurodov.security;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class SessionUser {

    @SerializedName("code")
    private String code;

    @SerializedName("is_super_user")
    private boolean isSuperUser;

    @SerializedName("roles")
    private List<RolesItem> roles;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("language")
    private String language;

    @SerializedName("phone")
    private String phone;

    @SerializedName("permissions")
    private List<PermissionsItem> permissions;

    @SerializedName("organization")
    private Organization organization;

    @SerializedName("id")
    private int id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;

}