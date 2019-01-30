package pl.lukabrasi.login.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class LoginEntity {
    private @Id @GeneratedValue int id;
    private @Column(name = "login") String login;
    private @Column(name = "password") String password;
    private @Column(name = "email") String email;
}
