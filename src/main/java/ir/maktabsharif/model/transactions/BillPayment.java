package ir.maktabsharif.model.transactions;

import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.model.Operation.Payment;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class BillPayment extends BaseModel<BigInteger> {

    @Column(name = "withdraw_acount",nullable = false,unique = true)
    //حساب برداشت / حساب مبدا
    private Long WithdrawAccountId;


    @OneToOne
    @JoinColumn(name = "payment_id",unique = true)
    private Payment payment;


    public BillPayment(Long withdrawAccountId, Payment payment) {
        WithdrawAccountId = withdrawAccountId;
        this.payment = payment;
    }

    public BillPayment() {

    }


    public Long getWithdrawAccountId() {
        return WithdrawAccountId;
    }

    public void setWithdrawAccountId(Long withdrawAccountId) {
        WithdrawAccountId = withdrawAccountId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BillPayment that = (BillPayment) o;
        return Objects.equals(WithdrawAccountId, that.WithdrawAccountId) && Objects.equals(payment, that.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), WithdrawAccountId, payment);
    }

    @Override
    public String toString() {
        return "BillPayment{" +
                "WithdrawAccountId=" + WithdrawAccountId +
                ", payment=" + payment +
                '}';
    }
}
