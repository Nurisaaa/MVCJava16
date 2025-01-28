package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table (name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue (generator = "user_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String nickname;
    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Book> books;


    public User(String firstName, String lastName, String nickname, String email, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
