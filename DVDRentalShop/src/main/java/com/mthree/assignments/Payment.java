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
	private int payId;
	@Column(name = "customer_id")
	private int custId;
	@Column(name = "staff_id")
	private int staffId;
	@Column(name = "rental_id")
	private int rentId;
	@Column(name = "amount")
	private BigDecimal amount;
	@Column(name = "payment_date")
	private Date payDate;
	
	
	public Payment(int payId, int custId, int staffId, int rentId, BigDecimal amount, Date payDate) {
		super();
		this.payId = payId;
		this.custId = custId;
		this.staffId = staffId;
		this.rentId = rentId;
		this.amount = amount;
		this.payDate = payDate;
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getRentId() {
		return rentId;
	}
	public void setRentId(int rentId) {
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
