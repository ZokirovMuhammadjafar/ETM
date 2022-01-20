package uz.elmurodov.services.project;

import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.project.ProjectDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.project.ProjectRepositoryImpl;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.BaseService;

/**
 * @author Saydali Murodullayev, Thu 12:26 AM. 1/20/2022
 */
public class ProjectService extends BaseService<ProjectRepositoryImpl, ProjectCreateDto, ProjectDto, String> {


    public ProjectService(ProjectRepositoryImpl projectRepository) {
        super(projectRepository);
    }

    @Override
    public ResponseEntity<Data<?>> create(ProjectCreateDto dto) {
        try {
            long id = repository.create(dto);
            if (id > 0)
                return new ResponseEntity<>(new Data<>("Project successfully created"));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
        return null;
    }

    @Override
    public ResponseEntity<ProjectDto> get(String id) {
        return null;
    }


    public ResponseEntity<Data<?>> block(String projectName) {

        return null;

    }
}
