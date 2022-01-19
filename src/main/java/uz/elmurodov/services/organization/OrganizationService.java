package uz.elmurodov.services.organization;

import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.dtos.organization.OrganizationDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.organization.OrganizationRepositoryImpl;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.BaseService;

/**
 * @author Saydali Murodullayev, Tue 11:12 AM. 1/18/2022
 */
public class OrganizationService extends BaseService<OrganizationRepositoryImpl,
        OrganizationCreateDto,
        OrganizationDto,
        Long> {

    public OrganizationService(OrganizationRepositoryImpl repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Long> create(OrganizationCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<OrganizationDto> get(Long id) {
        return null;
    }

    public ResponseEntity<Data<?>> createOrg(OrganizationCreateDto org) {
        try {
            Long id = repository.createOrganization(org);
            System.out.println(id);
            return new ResponseEntity<>(new Data<>("Organisation successfully created"));
        }catch (CustomerSQLException e){
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }

    }
}
