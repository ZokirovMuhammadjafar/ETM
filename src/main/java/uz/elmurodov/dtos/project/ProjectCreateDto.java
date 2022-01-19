package uz.elmurodov.dtos.project;

import lombok.*;
import uz.elmurodov.dtos.GenericBaseDto;

/**
 * @author Saydali Murodullayev, Tue 11:25 AM. 1/18/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProjectCreateDto implements GenericBaseDto {
    private  String name;
    private  String description;
    private  String tz;
    private  String background;
    private  long  organization_id;
}
