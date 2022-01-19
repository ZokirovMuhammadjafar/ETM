package uz.elmurodov.dtos.organization;

import lombok.*;
import uz.elmurodov.dtos.GenericBaseDto;

/**
 * @author Saydali Murodullayev, Tue 11:24 AM. 1/18/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrganizationCreateDto implements GenericBaseDto {
    private String name;
    private String website;
    private String email;
    private String logo;
    private String regNum;
    private String location;
}
