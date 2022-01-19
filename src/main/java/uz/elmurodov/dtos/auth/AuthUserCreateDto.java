package uz.elmurodov.dtos.auth;

import lombok.*;
import uz.elmurodov.dtos.GenericBaseDto;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuthUserCreateDto implements GenericBaseDto {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String language;
    private String firstName;
    private String lastName;
    private Long organizationId;
}
