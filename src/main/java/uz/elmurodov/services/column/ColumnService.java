package uz.elmurodov.services.column;

import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnDto;
import uz.elmurodov.repository.column.ColumnRepositoryImpl;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.BaseService;

/**
 * @author Saydali Murodullayev, Thu 12:51 AM. 1/20/2022
 */
public class ColumnService extends BaseService<ColumnRepositoryImpl, ColumnCreateDto, ColumnDto, Long> {
    public ColumnService(ColumnRepositoryImpl columnRepository) {
        super(columnRepository);
    }

    @Override
    public ResponseEntity<Data<?>> create(ColumnCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<ColumnDto> get(Long id) {
        return null;
    }
}
