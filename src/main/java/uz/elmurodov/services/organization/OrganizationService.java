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
    public ResponseEntity<Data<?>> create(OrganizationCreateDto dto) {
        try {
            long id = repository.createOrganization(dto);
            if (id > 0)
                return new ResponseEntity<>(new Data<>("Organisation successfully created"));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
        return null;
    }

    @Override
    public ResponseEntity<OrganizationDto> get(Long id) {
        return null;
    }

    private boolean checkOrganizationNameForExistence(String orgName) {
        return false;
    }

    public ResponseEntity<Data<?>> block(String orgName) {
        if (checkOrganizationNameForExistence(orgName)) {
            return new ResponseEntity<>(new Data<>("Organization is not exist"), 404);
        } else if (!OrganizationIsActive(orgName)) {
            return new ResponseEntity<>(new Data<>("Organization is not active"), 405);
        } else if (repository.blockOrg(orgName)) {
            return new ResponseEntity<>(new Data<>("Organization successfully blocked"), 201);
        } else
            return null;
    }

    private boolean OrganizationIsActive(String orgName) {
        return true;
    }

    public ResponseEntity<Data<?>> unblock(String orgName) {
        if (checkOrganizationNameForExistence(orgName)) {
            return new ResponseEntity<>(new Data<>("Organization is not exist"), 404);
        } else if (OrganizationIsActive(orgName)) {
            return new ResponseEntity<>(new Data<>("Organization is not blocked"), 405);
        } else if (repository.unblockOrg(orgName)) {
            return new ResponseEntity<>(new Data<>("Organization successfully unblocked"), 201);
        } else
            return null;
    }

    public ResponseEntity<Data<?>> delete(String orgName) {
        if (checkOrganizationNameForExistence(orgName)) {
            return new ResponseEntity<>(new Data<>("Organization is not exist"), 404);
        } else if (repository.delete(orgName)) {
            return new ResponseEntity<>(new Data<>("Organization successfully deleted"), 201);
        } else
            return null;
    }
}
