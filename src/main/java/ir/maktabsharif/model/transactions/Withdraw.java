package ir.maktabsharif.model.transactions;

import ir.maktabsharif.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class Withdraw extends BaseModel<BigInteger> {

    @Column(name = "withdraw_acount",nullable = false,unique = true)
    //حساب برداشت / حساب مبدا
    private Long WithdrawAccountId;


    @Column(name = "money",nullable = false)
    @Check(constraints = "money > 0")
    //مبلغ انتقال
    private BigDecimal amount;

    public Withdraw(Long withdrawAccountId, BigDecimal amount) {
        WithdrawAccountId = withdrawAccountId;
        this.amount = amount;
    }

    public Withdraw() {

    }

    public Long getWithdrawAccountId() {
        return WithdrawAccountId;
    }

    public void setWithdrawAccountId(Long withdrawAccountId) {
        WithdrawAccountId = withdrawAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Withdraw withdraw = (Withdraw) o;
        return Objects.equals(WithdrawAccountId, withdraw.WithdrawAccountId) && Objects.equals(amount, withdraw.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(WithdrawAccountId, amount);
    }

    @Override
    public String toString() {
        return "Withdraw{" +
                "WithdrawAccountId=" + WithdrawAccountId +
                ", amount=" + amount +
                '}';
    }
}
