package softuni.users.entity;

import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "users")
public class User {

    private long id;
    private String username;
    private String password;
    private String email;
    private byte[] profilePicture;
    private LocalDate registeredOn;
    private LocalDate lastTimeLoggedIn;
    private int age;
    private boolean isDeleted;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Required
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() < 4 || username.length() > 30){
            throw new IllegalArgumentException("Username length should be between 4 and 30 symbols.");
        }
        this.username = username;
    }

    @Required
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() < 6 || password.length() > 50){
            throw new IllegalArgumentException("Password length should be between 6 and 50 symbols.");
        }

        Pattern pattern = Pattern.compile("[a-z]");
        Matcher regex = pattern.matcher(password);
        if (!regex.find()){
            throw new IllegalArgumentException("Password should contain lowercase letter.");
        }

        pattern = Pattern.compile("[A-Z]");
        regex = pattern.matcher(password);
        if (!regex.find()){
            throw new IllegalArgumentException("Password should contain uppercase letter.");
        }

        pattern = Pattern.compile("[0-9]");
        regex = pattern.matcher(password);
        if (!regex.find()){
            throw new IllegalArgumentException("Password should contain digit letter.");
        }

        pattern = Pattern.compile("[!@#$%^&*()_+<>?]");
        regex = pattern.matcher(password);
        if (!regex.find()){
            throw new IllegalArgumentException("Password should contain of one (!, @, #, $, %, ^, &, *, (, ), _, +, <, >, ?) symbol.");
        }
        this.password = password;
    }

    @Required
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.matches("^[a-zA-Z0-9]+[\\w.-]+[a-zA-Z0-9]+@[a-zA-Z]+[a-zA-Z.]+[a-zA-Z]+$")){
            throw new IllegalArgumentException("Invalid e-mail.");
        }
        this.email = email;
    }

    @Column(name = "profile_picture", columnDefinition = "LONGBLOB")
    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        if (profilePicture.length > 1024 * 1024){
            throw new IllegalArgumentException("Profile picture can`t be of 1 MB.");
        }
        this.profilePicture = profilePicture;
    }

    @Column(name = "registered_on", columnDefinition = "DATETIME")
    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Column(name = "last_time_logged_in", columnDefinition = "DATETIME")
    public LocalDate getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(LocalDate lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1 || age > 120){
            throw new IllegalArgumentException("Invalid age.");
        }
        this.age = age;
    }

    @Column(name = "is_deleted")
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
