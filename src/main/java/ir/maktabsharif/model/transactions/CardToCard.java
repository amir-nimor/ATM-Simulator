package ir.maktabsharif.model.transactions;

import ir.maktabsharif.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class CardToCard extends BaseModel<BigInteger> {

    @Column(name = "withdraw_acount",nullable = false,unique = true)
    //حساب برداشت / حساب مبدا
    private Long WithdrawAccountId;

    @Column(name = "deposit_acount",nullable = false,unique = true)
    // حساب واریز / حساب مقصد
    private Long DepositAccountId;

    @Column(name = "money",nullable = false)
    @Check(constraints = "money > 0")
    //مبلغ انتقال
    private BigDecimal amount;


    public CardToCard(Long withdrawAccountId, Long depositAccountId, BigDecimal amount) {
        WithdrawAccountId = withdrawAccountId;
        DepositAccountId = depositAccountId;
        this.amount = amount;
    }

    public CardToCard() {

    }

    public Long getWithdrawAccountId() {
        return WithdrawAccountId;
    }

    public void setWithdrawAccountId(Long withdrawAccountId) {
        WithdrawAccountId = withdrawAccountId;
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
        CardToCard that = (CardToCard) o;
        return Objects.equals(WithdrawAccountId, that.WithdrawAccountId) && Objects.equals(DepositAccountId, that.DepositAccountId) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(WithdrawAccountId, DepositAccountId, amount);
    }

    @Override
    public String toString() {
        return "CardToCard{" +
                "WithdrawAccountId=" + WithdrawAccountId +
                ", DepositAccountId=" + DepositAccountId +
                ", amount=" + amount +
                '}';
    }
}
