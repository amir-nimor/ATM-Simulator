package ir.maktabsharif.model.transactions;

import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.math.BigInteger;
import java.util.Objects;

@Entity
public class ChangeUsername extends BaseModel<BigInteger> {

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(name = "old_Username",nullable = false)
    private String oldUsername;

    @Column(name = "new_Username",unique = true,nullable = false)
    private String newUsername;


    public ChangeUsername(User user, String oldUsername, String newUsername) {
        this.user = user;
        this.oldUsername = oldUsername;
        this.newUsername = newUsername;
    }


    public ChangeUsername() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOldUsername() {
        return oldUsername;
    }

    public void setOldUsername(String oldUsername) {
        this.oldUsername = oldUsername;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChangeUsername that = (ChangeUsername) o;
        return Objects.equals(user, that.user) && Objects.equals(oldUsername, that.oldUsername) && Objects.equals(newUsername, that.newUsername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, oldUsername, newUsername);
    }

    @Override
    public String toString() {
        return "ChangeUsername{" +
                "user=" + user +
                ", oldUsername='" + oldUsername + '\'' +
                ", newUsername='" + newUsername + '\'' +
                '}';
    }
}
