package uz.elmurodov.repository.auth;

import com.google.gson.Gson;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.auth.AuthUserCreateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.repository.role.CreateRole;
import uz.elmurodov.security.SessionUser;
import uz.elmurodov.utils.BaseUtils;

import java.lang.reflect.Type;
import java.sql.Types;

import static uz.elmurodov.security.SecurityHolder.session;

public class AuthUserRepositoryImpl extends BaseRepository {

    private final DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);

    public SessionUser login(String userName, String password) {
        prepareArguments(userName,password);
        String jsonDATA = (String) callProcedure(property.get("auth.login"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(jsonDATA, SessionUser.class);
    }

    public long create_admin(AuthUserCreateDto dto) {
        prepareArguments(new Gson().toJson(dto),session.getId());
        long id = Long.parseLong( (String) callProcedure(property.get("user.create"), Types.BIGINT));
        CreateRole createRole=new CreateRole(id,dto.getOrganizationId(),"ADMIN","admin");
        prepareArguments(new Gson().toJson(createRole),session.getId());
        long roleId = Long.parseLong( (String) callProcedure(property.get("user.addRole"), Types.BIGINT));
        prepareArguments(roleId,14);
        Boolean response = (Boolean) callProcedure(property.get("user.addPermission"), Types.BOOLEAN);
        if(response){
            return -1;
        }else{
           return  0;
        }
    }
}
