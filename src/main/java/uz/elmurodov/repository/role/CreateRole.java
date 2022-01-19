package uz.elmurodov.repository.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.dtos.GenericBaseDto;
@Getter
@Setter
@AllArgsConstructor
public class CreateRole implements GenericBaseDto {
    public  Long userId;
    public Long organizationId;
    public String roleCode;
    public String roleName;
}
