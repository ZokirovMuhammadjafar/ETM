package uz.elmurodov.repository.organization;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.utils.BaseUtils;

import java.sql.Types;

/**
 * @author Saydali Murodullayev, Tue 11:12 AM. 1/18/2022
 */
public class OrganizationRepositoryImpl extends BaseRepository {
    DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);


    public long createOrganization(OrganizationCreateDto org) {
        prepareArguments(("" + BaseUtils.gson.toJson(org)), SecurityHolder.session.getId());
        return (Long) callProcedure(property.get("org.create"), Types.BIGINT);
    }
}
