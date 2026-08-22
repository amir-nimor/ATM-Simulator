package ir.maktabsharif.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User extends BaseModel<Long> {

    @Column(name = "full_name",nullable = false)
    private String fullName;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(name = "phone_number",nullable = false,unique = true)
    private String phoneNumber;
    @Check(constraints = "balance > 0")
    private BigDecimal balance;
    @Embedded
    private UserAddres userAddres;

    public User(String fullName, String username, String password, String phoneNumber, UserAddres userAddres) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userAddres = userAddres;
        this.balance = new BigDecimal(1);
    }

    public User() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public UserAddres getUserAddres() {
        return userAddres;
    }

    public void setUserAddres(UserAddres userAddres) {
        this.userAddres = userAddres;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", balance=" + balance +
                ", userAddres=" + userAddres +
                '}';
    }
}
