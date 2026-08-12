package ir.maktabsharif.model.transactions;

import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.prefs.BackingStoreException;

@Entity
public class ChangePassword extends BaseModel<BigInteger> {

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


    @Column(name = "old_password",nullable = false)
    private String oldPassword;

    @Column(name = "new_password",unique = true,nullable = false)
    private String newPassword;

    public ChangePassword(User user, String oldPassword, String newPassword) {
        this.user = user;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public ChangePassword() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChangePassword that = (ChangePassword) o;
        return Objects.equals(user, that.user) && Objects.equals(oldPassword, that.oldPassword) && Objects.equals(newPassword, that.newPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, oldPassword, newPassword);
    }

    @Override
    public String toString() {
        return "ChangePassword{" +
                "user=" + user +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
