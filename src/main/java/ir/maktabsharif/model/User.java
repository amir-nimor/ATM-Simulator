package ir.maktabsharif.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Check(constraints = "balance > 0")
public class User extends BaseModel<Long>{
    @Column(name = "user_name",nullable = false,unique = true)
    private String username;
    @Column(unique = true,nullable = false)
    private String password;
    @Column(name = "full_name",nullable = false)
    private String fullName;
    private BigDecimal balance;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    public User(String username, String password, String fullName, String phoneNumber) {
        setUsername(username);
        setPassword(password);
        setFullName(fullName);
        setPhoneNumber(phoneNumber);
        this.balance = BigDecimal.valueOf(0);
    }

    public User() {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", balance=" + balance +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
