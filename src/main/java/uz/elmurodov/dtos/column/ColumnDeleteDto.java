package uz.elmurodov.dtos.column;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ColumnDeleteDto {

    private Long organizationId;
    private Long projectId;
    private Long columnId;

}
