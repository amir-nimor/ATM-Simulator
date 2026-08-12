package ir.maktabsharif.model.transactions;

import ir.maktabsharif.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class Deposit extends BaseModel<BigInteger> {

    @Column(name = "deposit_acount",nullable = false,unique = true)
    // حساب واریز / حساب مقصد
    private Long DepositAccountId;

    @Column(name = "money",nullable = false)
    @Check(constraints = "money > 0")
    //مبلغ انتقال
    private BigDecimal amount;

    public Deposit(Long depositAccountId, BigDecimal amount) {
        DepositAccountId = depositAccountId;
        this.amount = amount;
    }

    public Deposit() {

    }

    public Long getDepositAccountId() {
        return DepositAccountId;
    }

    public void setDepositAccountId(Long depositAccountId) {
        DepositAccountId = depositAccountId;
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
        Deposit deposit = (Deposit) o;
        return Objects.equals(DepositAccountId, deposit.DepositAccountId) && Objects.equals(amount, deposit.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DepositAccountId, amount);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "DepositAccountId=" + DepositAccountId +
                ", amount=" + amount +
                '}';
    }
}
