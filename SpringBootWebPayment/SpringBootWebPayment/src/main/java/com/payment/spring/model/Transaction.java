package com.payment.spring.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Transaction {
	@Id
	private int transactionid;
	
	@OneToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="receiverBIC")
	private Bank receiver;
	
	private String receiveraccountholdernumber;
	
	private String receiveraccountholdername;
	
	@OneToOne
	@JoinColumn(name="transfertypecode")
	private Transfertypes transfertypes;
	
	@OneToOne
	@JoinColumn(name="messagecode")
	private Message message;
	
	private double amount;
	
	private double transferfees;
	
	private LocalDate transferdate;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transactionid, Customer customerid, Bank receiverBIC,
			String receiveraccountholdernumber, String receiveraccountholdername, Transfertypes transfertypecode,
			Message messagecode, double transferfees, double amount, LocalDate transferdate) {
		super();
		this.transactionid = transactionid;
		this.customer = customerid;
		this.receiver = receiverBIC;
		this.receiveraccountholdernumber = receiveraccountholdernumber;
		this.receiveraccountholdername = receiveraccountholdername;
		this.transfertypes = transfertypecode;
		this.message = messagecode;
		this.transferfees = transferfees;
		this.amount = amount;
		this.transferdate = transferdate;
	}
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public Customer getCustomerid() {
		return customer;
	}
	public void setCustomerid(Customer customerid) {
		this.customer = customerid;
	}
	
	public Bank getReceiverBIC() {
		return receiver;
	}
	public void setReceiverBIC(Bank receiverBIC) {
		this.receiver= receiverBIC;
	}
	public String getReceiveraccountholdernumber() {
		return receiveraccountholdernumber;
	}
	public void setReceiveraccountholdernumber(String receiveraccountholdernumber) {
		this.receiveraccountholdernumber = receiveraccountholdernumber;
	}
	public String getReceiveraccountholdername() {
		return receiveraccountholdername;
	}
	public void setReceiveraccountholdername(String receiveraccountholdername) {
		this.receiveraccountholdername = receiveraccountholdername;
	}
	public Transfertypes getTransfertypecode() {
		return transfertypes;
	}
	public void setTransfertypecode(Transfertypes transfertypecode) {
		this.transfertypes = transfertypecode;
	}
	public Message getMessagecode() {
		return message;
	}
	public void setMessagecode(Message messagecode) {
		this.message = messagecode;
	}
	
	public double getTransferfees() {
		return transferfees;
	}
	public void setTransferfees(double transferfees) {
		this.transferfees = transferfees;
	}
	public double getamount() {
		return amount;
	}
	public void setamount(double amount) {
		this.amount = amount;
	}
	public LocalDate getTransferdate() {
		return transferdate;
	}
	public void setTransferdate(LocalDate transferdate) {
		this.transferdate = transferdate;
	}
	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", customerid=" + customer + " , receiverBIC=" + receiver
				+ ", receiveraccountholdernumber=" + receiveraccountholdernumber + ", receiveraccountholdername="
				+ receiveraccountholdername + ", transfertypecode=" + transfertypes+ ", messagecode=" + message
				+ ",transferfees=" + transferfees + ", amount=" + amount
				+ ", transferdate=" + transferdate + "]";
	}
	
	
	
	
}