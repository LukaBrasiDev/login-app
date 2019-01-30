package pl.lukabrasi.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukabrasi.login.entities.LoginEntity;
import pl.lukabrasi.login.repositories.LoginRepository;

@Service
public class UserService {

    final LoginRepository loginRepository;

    @Autowired
    public UserService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    public boolean addUser(String login, String password, String email) {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setLogin(login);
        loginEntity.setPassword(password);
        loginEntity.setEmail(email);

        if (loginRepository.existsByLogin(login)) {
            return false;
        }
        return loginRepository.save(loginEntity) != null;
    }

}
