package uz.elmurodov.ui.auth;


import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.auth.AuthUserCreateDto;
import uz.elmurodov.dtos.organization.OrganizationDto;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.auth.AuthUserService;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.ui.BaseAbstractUI;
import uz.jl.utils.Input;

import java.util.List;

import static uz.elmurodov.security.SecurityHolder.session;
import static uz.jl.utils.Input.getNum;

/**
 * @author Saydali Murodullayev, Thu 12:28 PM. 1/13/2022
 */
public class AuthUI extends BaseAbstractUI{

    public void login() {
        AuthUserService service = UNIContainer.getBean(AuthUserService.class);
        String username = Input.getStr("Username : ");
        String password = Input.getStr("Password : ");
        ResponseEntity<Data<?>> response = service.login(username, password);
        show(response);
    }

    public void createAdmin() {
        long id=1;
        List<OrganizationDto>org= UNIContainer.getBean(OrganizationService.class).getOrganization(session.getId(),"");
        if(session.isSuperUser() &&org.size()>1){
            for (int i = 0, orgSize = org.size(); i < orgSize; i++) {
                OrganizationDto organizationDto = org.get(i);
                System.out.println(i+1+" "+organizationDto.getName() );
            }
            int choice =getNum("enter index org");
            id=org.get(choice-1).getId();
        }
        AuthUserService service = UNIContainer.getBean(AuthUserService.class);
        String username =Input.getStr("enter username");
        String firstname=Input.getStr("enter firstName");
        String lastname=Input.getStr("enter firstName");
        String password=Input.getStr("enter password");
        String email=Input.getStr("enter email");
        String phone=Input.getStr("enter phone number (998936432434)");
        AuthUserService authUserService=UNIContainer.getBean(AuthUserService.class);
        ResponseEntity<Data<?>> response=authUserService.create(new AuthUserCreateDto(username,password,email,phone,"en",firstname,lastname,id));
    }

    public void blockAdmin() {

    }

    public void unblockAdmin() {

    }

    public void deleteAdmin() {

    }

    public void updateAdmin() {


    }

    public void listAdmin() {

    }

    public void createHR() {


    }

    public void blockHR() {

    }

    public void unblockHR() {

    }

    public void deleteHR() {

    }

    public void updateHR() {

    }

    public void listHR() {

    }

    public void createMANAGER() {

    }

    public void blockMANAGER() {

    }

    public void unblockMANAGER() {
    }

    public void deleteMANAGER() {

    }

    public void updateMANAGER() {

    }

    public void listMANAGER() {

    }

    public void createEMPLOYEE() {

    }

    public void blockEMPLOYEE() {

    }

    public void unblockEMPLOYEE() {

    }

    public void deleteEMPLOYEE() {

    }

    public void updateEMPLOYEE() {

    }

    public void listEMPLOYEE() {

    }
}
