package com.example.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the ADMIN_TABLE database table.
 * 
 */

@Entity
@Table(name="ADMIN_TABLE")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","retailerTables"})
public class AdminTable implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="A_ID")
	private int aId;

	@Column(name="A_EMAIL")
	private String aEmail;

	@Column(name="A_NAME")
	private String aName;

	@Column(name="A_PASSWORD")
	private String aPassword;

	//bi-directional many-to-one association to RetailerTable
	@OneToMany(mappedBy="adminTable",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<RetailerTable> retailerTables;

	public AdminTable() {
	}

	public int getAId() {
		return this.aId;
	}

	public void setAId(int aId) {
		this.aId = aId;
	}

	public String getAEmail() {
		return this.aEmail;
	}

	public void setAEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getAName() {
		return this.aName;
	}

	public void setAName(String aName) {
		this.aName = aName;
	}

	public String getAPassword() {
		return this.aPassword;
	}

	public void setAPassword(String aPassword) {
		this.aPassword = aPassword;
	}

	public List<RetailerTable> getRetailerTables() {
		return this.retailerTables;
	}

	public void setRetailerTables(List<RetailerTable> retailerTables) {
		this.retailerTables = retailerTables;
	}

	public RetailerTable addRetailerTable(RetailerTable retailerTable) {
		getRetailerTables().add(retailerTable);
		retailerTable.setAdminTable(this);

		return retailerTable;
	}

	public RetailerTable removeRetailerTable(RetailerTable retailerTable) {
		getRetailerTables().remove(retailerTable);
		retailerTable.setAdminTable(null);

		return retailerTable;
	}

}