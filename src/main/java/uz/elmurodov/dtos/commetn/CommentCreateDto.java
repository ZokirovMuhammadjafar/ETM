package uz.elmurodov.dtos.commetn;

import lombok.*;
import uz.elmurodov.dtos.GenericBaseDto;

/**
 * @author Saydali Murodullayev, Tue 11:26 AM. 1/18/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommentCreateDto implements GenericBaseDto {
    private long OrganizationId;
    private long projectId;
    private long addTaskId;
    private long type;
    private String commentMessage;

}
