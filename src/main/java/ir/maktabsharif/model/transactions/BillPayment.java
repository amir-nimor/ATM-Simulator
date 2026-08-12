package ir.maktabsharif.model.transactions;

import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.model.Operation.Payment;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
public class BillPayment extends BaseModel<BigInteger> {

    @Column(name = "withdraw_acount",nullable = false,unique = true)
    //حساب برداشت / حساب مبدا
    private Long WithdrawAccountId;


    @OneToOne
    @JoinColumn(name = "payment_id",unique = true)
    private Payment payment;



}
