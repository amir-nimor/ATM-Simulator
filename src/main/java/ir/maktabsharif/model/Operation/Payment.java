package ir.maktabsharif.model.Operation;

import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.model.transactions.BillPayment;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Payment extends BaseModel<Long> {

    @Column(name = "payment_name",nullable = false)
    private String paymentName;

    @Column(name = "payment_amount",nullable = false)
    @Check(constraints = "payment_amount > 0")
    private BigDecimal paymentAmount;

    @Enumerated(EnumType.STRING)
    private OperationStatus status;

    @OneToOne(mappedBy = "payment")
    private BillPayment billPayment;


    public Payment(String paymentName, BigDecimal paymentAmount) {
        this.paymentName = paymentName;
        this.paymentAmount = paymentAmount;
        status = OperationStatus.UNPAID;
    }

    public Payment() {
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public BillPayment getBillPayment() {
        return billPayment;
    }

    public void setBillPayment(BillPayment billPayment) {
        this.billPayment = billPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentName, payment.paymentName) && Objects.equals(paymentAmount, payment.paymentAmount) && status == payment.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentName, paymentAmount, status);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentName='" + paymentName + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", status=" + status +
                '}';
    }
}
