package pl.lukabrasi.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukabrasi.login.entities.LoginEntity;
import pl.lukabrasi.login.repositories.LoginRepository;

import java.util.Optional;

@Service
public class UserService {

    final LoginRepository loginRepository;
final UserSession userSession;

@Autowired
    public UserService(LoginRepository loginRepository, UserSession userSession) {
        this.loginRepository = loginRepository;
        this.userSession = userSession;
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

    public boolean tryLogin(String login, String password) {
        Optional<LoginEntity> userEntity = loginRepository.findByLoginAndPassword(login, password);

        if(userEntity.isPresent()){
            userSession.setUserLogin(true);
            userSession.setLogin(login);
        }
        return userEntity.isPresent();
    }

}
