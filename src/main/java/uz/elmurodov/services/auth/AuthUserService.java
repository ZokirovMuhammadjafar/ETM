package uz.elmurodov.services.auth;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.auth.AuthUserCreateDto;
import uz.elmurodov.dtos.auth.AuthUserDto;
import uz.elmurodov.exception.CustomerSQLException;
import uz.elmurodov.repository.auth.AuthUserRepositoryImpl;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.BaseService;

import static uz.elmurodov.security.SecurityHolder.hasPermission;

public class AuthUserService extends BaseService<AuthUserRepositoryImpl,
        AuthUserCreateDto,
        AuthUserDto,
        Long> {

    public AuthUserService(AuthUserRepositoryImpl repository) {
        super(repository);
    }

    public ResponseEntity<Data<?>> login(String userName, String password) {
        try {
            SecurityHolder.setSession(repository.login(userName, password));
            return new ResponseEntity<>(new Data<>("Successfully logged in"));
        } catch (CustomerSQLException e) {
            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<?>> create(AuthUserCreateDto dto) {
        try {
            hasPermission("CREATE_ADMIN");
            return new ResponseEntity<>(new Data<>(UNIContainer.getBean(AuthUserRepositoryImpl.class).create_admin(dto)));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ResponseEntity<AuthUserDto> get(Long id) {
        try {
            hasPermission("CREATE_ORGANIZATION");
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
