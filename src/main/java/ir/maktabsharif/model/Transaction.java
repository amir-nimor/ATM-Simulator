package ir.maktabsharif.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigInteger;

@Entity
public class Transaction extends BaseModel<BigInteger> {

    @Enumerated(EnumType.STRING)
    @Column(name = "event",nullable = false)
    private Status status;


    private double Withdraw;
    private double Deposit;

    private Long WithdrawAccountId;
    private Long DepositAccountId;

    private Integer billPaymentNumber;

    private String NewPassword;
    private String PreviousPassword;

    private String NewUsername;
    private String previousUsername;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getWithdraw() {
        return Withdraw;
    }

    public void setWithdraw(double withdraw) {
        Withdraw = withdraw;
    }

    public double getDeposit() {
        return Deposit;
    }

    public void setDeposit(double deposit) {
        Deposit = deposit;
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

    public Integer getBillPaymentNumber() {
        return billPaymentNumber;
    }

    public void setBillPaymentNumber(Integer billPaymentNumber) {
        this.billPaymentNumber = billPaymentNumber;
    }

    public String getNewPassword() {
        return NewPassword;
    }

    public void setNewPassword(String newPassword) {
        NewPassword = newPassword;
    }

    public String getPreviousPassword() {
        return PreviousPassword;
    }

    public void setPreviousPassword(String previousPassword) {
        PreviousPassword = previousPassword;
    }

    public String getNewUsername() {
        return NewUsername;
    }

    public void setNewUsername(String newUsername) {
        NewUsername = newUsername;
    }

    public String getPreviousUsername() {
        return previousUsername;
    }

    public void setPreviousUsername(String previousUsername) {
        this.previousUsername = previousUsername;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "status=" + status +
                ", Withdraw=" + Withdraw +
                ", Deposit=" + Deposit +
                ", WithdrawAccountId=" + WithdrawAccountId +
                ", DepositAccountId=" + DepositAccountId +
                ", billPaymentNumber=" + billPaymentNumber +
                ", NewPassword='" + NewPassword + '\'' +
                ", PreviousPassword='" + PreviousPassword + '\'' +
                ", NewUsername='" + NewUsername + '\'' +
                ", previousUsername='" + previousUsername + '\'' +
                '}';
    }
}
