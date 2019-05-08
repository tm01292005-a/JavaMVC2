package com.example.jpademo.entity.oracle1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TABLE1 database table.
 *
 */
@Entity
@NamedQuery(name="Table1.findAll", query="SELECT t FROM Table1 t")
public class Table1 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String column1;

	private BigDecimal column2;

	@Temporal(TemporalType.DATE)
	private Date column3;

	@Id
	@Column(name="ID")
	private Long id;

	public Table1() {
	}

	public String getColumn1() {
		return this.column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public BigDecimal getColumn2() {
		return this.column2;
	}

	public void setColumn2(BigDecimal column2) {
		this.column2 = column2;
	}

	public Date getColumn3() {
		return this.column3;
	}

	public void setColumn3(Date column3) {
		this.column3 = column3;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}