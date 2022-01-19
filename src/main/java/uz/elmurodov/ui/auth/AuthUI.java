package uz.elmurodov.ui.auth;


import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.auth.AuthUserService;
import uz.elmurodov.ui.BaseAbstractUI;
import uz.jl.utils.Input;

import java.util.Objects;

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
}
