package com.milan.Ghumgham_travels.login.service.UserRoleImpl;

//import com.addon.cbps.security.customuser.CustomUserDetails;
import com.milan.Ghumgham_travels.login.model.Dto.LoginDto;
import com.milan.Ghumgham_travels.login.model.Login;
import com.milan.Ghumgham_travels.login.repository.SecurityUserRepository;
import com.milan.Ghumgham_travels.login.service.UserRoleServiceInterface.UserRoleServiceInterface;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleServiceInterface {
    @Autowired
    private SecurityUserRepository securityUserRepository;


    @Override
    public Login saveUser(Login user) {
        return securityUserRepository.save(user);
    }

    @Override
    public Login getByUser(String username){
        return securityUserRepository.getUserByUsername(username);
    }

    @Override
    public Login updateRole(LoginDto loginDto) {
        Login login = securityUserRepository.findById(loginDto.getId()).orElse(null);
        //Login login = securityUserRepository.findById(loginDto.getId()).orElse(null);
        //Product existingProduct = repository.findById(product.getId()).orElse(null);

//        PersonRole personRole = login.getUserRole();
//        personRole.setRoleName(loginDto.getUserRole());
//        return securityUserRepository.save(login);
        return login;
    }
//    public User currentUser() {
//        CustomUserDetails customUserDetails = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        Login login = securityUserRepository.getUserByUsername(customUserDetails.getEmail());
//        return login.getUser();
//    }

}
