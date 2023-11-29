package app.blogging.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "UserEntity")
@Table(name="blogging_app_user")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="user_name",nullable = false,length = 200)
    private String name;
    @Column(name="user_email",nullable = false,length = 200,unique = true)
    private String email;
    @Column(name="user_password",nullable = false,length = 200)
    private String password;
    @Column(name="user_about",nullable = true,length = 20000)
    private String about;


}
