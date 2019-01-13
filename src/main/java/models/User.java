package models;

import javax.persistence.*;


@Entity
@Table(name ="Gebruiker")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String emailaddress;
    private String password;


    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // Constructors
    public User() {}

    public User(String emailaddress, String password) {
        this.emailaddress = emailaddress;
        this.password = password;
    }

    public User(int userId, String emailaddress, String password) {
        this.userId = userId;
        this.emailaddress = emailaddress;
        this.password = password;

    }

    // Methods
    @Override
    public String toString() {
        return this.emailaddress;
    }

    public boolean matches(String emailaddress) {
        return this.getEmailaddress().equals(emailaddress);
    }
}
