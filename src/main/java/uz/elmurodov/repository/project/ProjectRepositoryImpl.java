package uz.elmurodov.repository.project;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.utils.BaseUtils;

import java.sql.Types;

/**
 * @author Saydali Murodullayev, Wed 1:08 AM. 1/19/2022
 */
public class ProjectRepositoryImpl extends BaseRepository {
    DatabaseProperties databaseProperties = UNIContainer.getBean(DatabaseProperties.class);

    public Long create(ProjectCreateDto dto) {
        prepareArguments(BaseUtils.gson.toJson(dto), SecurityHolder.session.getId());
        return (Long) callProcedure(databaseProperties.get("project.create"), Types.BIGINT);
    }
}
