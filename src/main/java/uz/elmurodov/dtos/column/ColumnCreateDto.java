package uz.elmurodov.dtos.column;

import lombok.*;
import uz.elmurodov.dtos.GenericBaseDto;

/**
 * @author Saydali Murodullayev, Wed 1:09 AM. 1/19/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ColumnCreateDto implements GenericBaseDto {
    private String emoji;
    private String projectId;
    private String name;
}
