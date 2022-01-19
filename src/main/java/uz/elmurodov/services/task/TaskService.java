package uz.elmurodov.services.task;

import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskDto;
import uz.elmurodov.repository.task.TaskRepositoryImpl;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.BaseService;

/**
 * @author Saydali Murodullayev, Thu 1:01 AM. 1/20/2022
 */
public class TaskService extends BaseService<TaskRepositoryImpl, TaskCreateDto, TaskDto, Long> {

    public TaskService(TaskRepositoryImpl taskRepository) {
        super(taskRepository);
    }

    @Override
    public ResponseEntity<Data<?>> create(TaskCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<TaskDto> get(Long id) {
        return null;
    }
}
