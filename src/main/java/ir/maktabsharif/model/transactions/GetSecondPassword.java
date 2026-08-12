package ir.maktabsharif.model.transactions;

import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.model.User;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;
import java.util.UUID;

@Entity
public class GetSecondPassword extends BaseModel<BigInteger> {

    @OneToOne
    @JoinColumn(name = "user_id",unique = true,nullable = false)
    private User user;



    private UUID secondPassword;


    public GetSecondPassword(User user) {
        this.user = user;
        secondPassword = UUID.randomUUID();
    }

    public GetSecondPassword() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(UUID secondPassword) {
        this.secondPassword = secondPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GetSecondPassword that = (GetSecondPassword) o;
        return Objects.equals(user, that.user) && Objects.equals(secondPassword, that.secondPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, secondPassword);
    }

    @Override
    public String toString() {
        return "GetSecondPassword{" +
                "user=" + user +
                ", secondPassword=" + secondPassword +
                '}';
    }
}
