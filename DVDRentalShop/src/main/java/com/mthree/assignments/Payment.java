package com.mthree.assignments;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {

	@Id
	@Column(name = "payment_id")
	private long payId;
	@Column(name = "customer_id")
	private long custId;
	@Column(name = "staff_id")
	private long staffId;
	@Column(name = "rental_id")
	private long rentId;
	@Column(name = "amount")
	private BigDecimal amount;
	@Column(name = "payment_date")
	private Date payDate;
	
	
	public Payment(long payId, long custId, long staffId, long rentId, BigDecimal amount, Date payDate) {
		super();
		this.payId = payId;
		this.custId = custId;
		this.staffId = staffId;
		this.rentId = rentId;
		this.amount = amount;
		this.payDate = payDate;
	}
	public long getPayId() {
		return payId;
	}
	public void setPayId(long payId) {
		this.payId = payId;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public long getRentId() {
		return rentId;
	}
	public void setRentId(long rentId) {
		this.rentId = rentId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	
}
