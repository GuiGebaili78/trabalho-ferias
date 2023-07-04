package br.com.fiap.fintech.bean;

import java.util.Calendar;
import java.util.Date;

public class Categoria {

	private int cd_categ;
	private String tp_categ;
	private String ds_categ;
	private String ds_subcateg;
	private Date data = new Date(Calendar.getInstance().getTimeInMillis());

	public Categoria() {
		super();
	}

	public Categoria(int cd_categ, String tp_categ, String ds_categ, String ds_subcateg, Date data) {
		super();
		this.cd_categ = cd_categ;
		this.tp_categ = tp_categ;
		this.ds_categ = ds_categ;
		this.ds_subcateg = ds_subcateg;
		this.data = data;
	}

	public int getCd_categ() {
		return cd_categ;
	}

	public void setCd_categ(int cd_categ) {
		this.cd_categ = cd_categ;
	}

	public String getTp_categ() {
		return tp_categ;
	}

	public void setTp_categ(String tp_categ) {
		this.tp_categ = tp_categ;
	}

	public String getDs_categ() {
		return ds_categ;
	}

	public void setDs_categ(String ds_categ) {
		this.ds_categ = ds_categ;
	}

	public String getDs_subcateg() {
		return ds_subcateg;
	}

	public void setDs_subcateg(String ds_subcateg) {
		this.ds_subcateg = ds_subcateg;
	}

	public Date getData() {
		return data;
	}


}
