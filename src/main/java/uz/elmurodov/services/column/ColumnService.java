package uz.elmurodov.services.column;

import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnDeleteDto;
import uz.elmurodov.dtos.column.ColumnDto;
import uz.elmurodov.exception.CustomerSQLException;
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

        try {
            long id = repository.createColumn(dto);
            if (id > 0)
                return new ResponseEntity<>(new Data<>("Organisation successfully created"));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
        return null;
    }

    public ResponseEntity<Data<?>> delete(ColumnDeleteDto dto) {

        try {
            boolean action = repository.deleteColumn(dto);
            if (action)
                return new ResponseEntity<>(new Data<>("Organisation successfully created"));

        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }

        return null;

    }

    public ResponseEntity<Data<?>> list(ColumnDeleteDto dto) {
        return null;
    }


    @Override
    public ResponseEntity<ColumnDto> get(Long id) {
        return null;
    }
}
