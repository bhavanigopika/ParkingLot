package parkinglot.models;

import parkinglot.models.enums.BillStatus;
import parkinglot.models.enums.FeeCalculationStrategyType;

import java.util.Date;
import java.util.List;

//Bill is different from Payment
//Bill is something handled by operator. Payment is maybe something handled by third party payment gateway
//So we need bill status and payment status separately
public class Bill extends BaseModel{
    private double amount;
    private Date exitTime;
    private Ticket ticket;
    private List<Payment> paymentList;
    private Gate gate;
    private BillStatus billStatus;
    //bill also calculated by strategy type based on fees calculation
    private FeeCalculationStrategyType feeCalculationStrategyType;

    //getters and setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategyType(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }
}
