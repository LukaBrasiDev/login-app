package pl.lukabrasi.login.services;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value="session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class UserSession {

    private String login;//login zalogowanego uzytkownika
    private boolean isUserLogin;//czy uzytkownik jest zalogowany czy nie
}
