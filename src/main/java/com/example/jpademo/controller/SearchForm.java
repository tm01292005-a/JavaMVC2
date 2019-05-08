package com.example.jpademo.controller;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SearchForm implements Serializable {

	private static final long serialVersionUID = -157143280035400042L;

	@NotNull
	private String ftext;

	@Pattern(regexp = "A|B|C|D|E")
	private String fselect;

	@NotNull
	private String fradio;

	public String getFtext() {
		return ftext;
	}
	public void setFtext(String ftext) {
		this.ftext = ftext;
	}

	public String getFselect() {
		return fselect;
	}
	public void setFselect(String fselect) {
		this.fselect = fselect;
	}

	public String getFradio() {
		return fradio;
	}
	public void setFradio(String fradio) {
		this.fradio = fradio;
	}
}
