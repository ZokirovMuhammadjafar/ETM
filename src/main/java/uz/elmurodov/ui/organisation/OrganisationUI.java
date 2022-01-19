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

import java.lang.ref.WeakReference;
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

        ResponseEntity<Data<?>> response = organizationService.create(org);

    }

    @Override
    public void block() {
        OrganizationService organizationService = UNIContainer.getBean(OrganizationService.class);
        listOfUnblockOrganizations();
        String orgName = Input.getStr("Enter organization name which you want to block: ");
        ResponseEntity<Data<?>> response = organizationService.block(orgName);
        show(response);


    }

    private void listOfUnblockOrganizations() {

    }

    @Override
    public void unblock() {
        OrganizationService organizationService = UNIContainer.getBean(OrganizationService.class);
        listOfBlockedOrganizations();
        String orgName = Input.getStr("Enter organization name which you want to unblock: ");
        ResponseEntity<Data<?>> response = organizationService.unblock(orgName);
        show(response);
    }

    private void listOfBlockedOrganizations() {

    }

    @Override
    public void delete() {
        OrganizationService organizationService = UNIContainer.getBean(OrganizationService.class);
        list();
        String orgName = Input.getStr("Enter organization name which you want to delete: ");
        ResponseEntity<Data<?>> response = organizationService.delete(orgName);
        show(response);
    }

    @Override
    public void update() {
        OrganizationService organizationService = UNIContainer.getBean(OrganizationService.class);
        list();
        String orgName = Input.getStr("Enter organization name which you want to update: ");



        ResponseEntity<Data<?>> response = organizationService.delete(orgName);
        show(response);

    }

    @Override
    public void list() {

    }
}
