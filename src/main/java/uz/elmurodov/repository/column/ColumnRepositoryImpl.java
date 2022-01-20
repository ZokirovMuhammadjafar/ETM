package uz.elmurodov.repository.column;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnDeleteDto;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.BaseRepository;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.utils.BaseUtils;

import java.sql.Types;

/**
 * @author Saydali Murodullayev, Wed 1:08 AM. 1/19/2022
 */
public class ColumnRepositoryImpl extends BaseRepository {
    DatabaseProperties property = UNIContainer.getBean(DatabaseProperties.class);


    public long createColumn(ColumnCreateDto column) {
        prepareArguments(("" + BaseUtils.gson.toJson(column)), SecurityHolder.session.getId());
        return (Long) callProcedure(property.get("column.create"), Types.BIGINT);
    }

    public boolean deleteColumn(ColumnDeleteDto column) {
        prepareArguments(("" + BaseUtils.gson.toJson(column)), SecurityHolder.session.getId());
        return  (boolean)callProcedure(property.get("column.delete"), Types.BOOLEAN);
    }

}
