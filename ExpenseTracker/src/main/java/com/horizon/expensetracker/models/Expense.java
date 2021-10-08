package com.horizon.expensetracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
	
	// ==== Primary Key =================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // ==== Member Variables ============
    @NotNull
    @Size(min = 3, max = 200, message="Name must be at least 3 characters.")
    private String name;
    
    @NotNull
    @Size(min = 3, max = 200, message="Expense must be at least 3 characters.")
    private String description;
    
    @NotNull
    @Size(min = 3, max = 200, message="Vendor must be at least 3 characters.")
    private String vendor;
    
    @DecimalMin("0.01")
    @Digits(integer=2,fraction=2)
    private double amount;
    
	// ==== Data Creation Trackers ======
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // ==== Constructors ================
    public Expense() {}
    
	public Expense(String name, String description, String vendor, double amount) {
		this.name = name;
		this.description = description;
		this.vendor = vendor;
		this.amount = amount;
	}
    
	// ==== Data Creation Event =========
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	// ==== Getters and Setters =========

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}    

}
