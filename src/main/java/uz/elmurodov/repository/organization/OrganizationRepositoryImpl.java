package uz.elmurodov.repository.organization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.dtos.organization.OrganizationDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.utils.BaseUtils;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.List;

/**
 * @author Saydali Murodullayev, Tue 11:12 AM. 1/18/2022
 */
public class OrganizationRepositoryImpl extends BaseRepository {
    DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);


    public long createOrganization(OrganizationCreateDto org) {
        prepareArguments(("" + BaseUtils.gson.toJson(org)), SecurityHolder.session.getId());
        return (Long) callProcedure(property.get("org.create"), Types.BIGINT);
    }

    public List<OrganizationDto> getOrg(Long id) {
        prepareArguments(id);
        String jsons = (String) callProcedure(property.get("org.getList"), Types.BLOB);
        Type type = new TypeToken<List<OrganizationDto>>() {
        }.getType();
        return new Gson().fromJson(jsons, type);

    }

    public boolean blockOrg(String orgName) {
        prepareArguments(orgName, SecurityHolder.session.getId());
        return (boolean) callProcedure(property.get("org.block"), Types.BOOLEAN);
    }

    public boolean unblockOrg(String orgName) {
        prepareArguments(orgName, SecurityHolder.session.getId());
        return (boolean) callProcedure(property.get("org.unblock"), Types.BOOLEAN);
    }

    public boolean delete(String orgName) {
        prepareArguments(orgName, SecurityHolder.session.getId());
        return (boolean) callProcedure(property.get("org.delete"), Types.BOOLEAN);

    }
}
