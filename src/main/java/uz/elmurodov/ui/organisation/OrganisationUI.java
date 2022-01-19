package uz.elmurodov.ui.organisation;


import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.ui.BaseAbstractUI;
import uz.elmurodov.ui.BaseUI;
import uz.elmurodov.utils.BaseUtils;
import uz.jl.utils.Input;

import java.util.Objects;

/**
 * @author Saydali Murodullayev, Thu 12:28 PM. 1/13/2022
 */
public class OrganisationUI extends BaseAbstractUI implements BaseUI {


    @Override
    public void create() {
        OrganizationService organizationService = UNIContainer.getBean(OrganizationService.class);
        OrganizationCreateDto org = new OrganizationCreateDto();
        org.setName(Input.getStr("Enter name: "));
        org.setLogo(Input.getStr("Enter logo: "));
        org.setEmail(Input.getStr("Enter email: "));
        org.setLocation(BaseUtils.getFloat("Enter lat:") + ", " + BaseUtils.getFloat("Enter long: "));
        org.setRegNum(Input.getStr("Enter regNum: "));
        org.setWebsite(Input.getStr("Enter website: "));

        ResponseEntity<Data<?>> response = organizationService.createOrg(org);
        show(response);

    }

    @Override
    public void block() {

    }

    @Override
    public void unblock() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void list() {

    }
}
