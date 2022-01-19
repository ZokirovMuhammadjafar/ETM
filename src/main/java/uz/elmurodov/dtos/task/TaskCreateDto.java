package uz.elmurodov.dtos.task;

import lombok.*;
import uz.elmurodov.dtos.GenericBaseDto;

import java.util.Date;

/**
 * @author Saydali Murodullayev, Tue 11:25 AM. 1/18/2022
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TaskCreateDto implements GenericBaseDto {
    private Long organizationId;
    private Long projectId;
    private Long columnId;
    private String name;
    private String description;
    private Date deadline;
    private  short level;
    private  short priority;

}
