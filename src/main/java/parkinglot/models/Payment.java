package parkinglot.models;

import parkinglot.models.enums.PaymentMode;
import parkinglot.models.enums.PaymentStatus;

import java.util.Date;

//Bill is different from Payment
//Bill is something handled by operator. Payment is maybe something handled by third party payment gateway
//So we need bill status and payment status separately
public class Payment extends BaseModel{
    private double amount;
    private Date time;
    private String referenceNo;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
