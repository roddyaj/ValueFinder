package com.roddyaj.invest.va.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Allocation
{
	private String cat;
	private double percent;

	@JsonProperty("cat")
	public String getCat()
	{
		return cat;
	}

	@JsonProperty("cat")
	public void setCat(String cat)
	{
		this.cat = cat;
	}

	@JsonProperty("percent")
	public double getPercent()
	{
		return percent;
	}

	@JsonProperty("percent")
	public void setPercent(double percent)
	{
		this.percent = percent;
	}
}
