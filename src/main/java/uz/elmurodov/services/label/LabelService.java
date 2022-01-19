package uz.elmurodov.services.label;

import uz.elmurodov.dtos.label.LabelCreateDto;
import uz.elmurodov.dtos.label.LabelDto;
import uz.elmurodov.repository.label.LabelRepositoryImpl;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.BaseService;

/**
 * @author Saydali Murodullayev, Thu 1:56 AM. 1/20/2022
 */
public class LabelService extends BaseService<LabelRepositoryImpl, LabelCreateDto, LabelDto, Long> {
    public LabelService(LabelRepositoryImpl labelRepository) {
        super(labelRepository);
    }

    @Override
    public ResponseEntity<Data<?>> create(LabelCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<LabelDto> get(Long id) {
        return null;
    }
}
