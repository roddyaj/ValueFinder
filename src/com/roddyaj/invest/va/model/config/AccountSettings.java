package com.roddyaj.invest.va.model.config;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountSettings
{
	private String name;
	private double annualContrib;
	private Allocation[] allocations;
	private PositionSettings[] positions;
	private com.roddyaj.invest.va.model.Allocation allocation = null;

	@JsonProperty("name")
	public String getName()
	{
		return name;
	}

	@JsonProperty("name")
	public void setName(String name)
	{
		this.name = name;
	}

	@JsonProperty("annualContrib")
	public double getAnnualContrib()
	{
		return annualContrib;
	}

	@JsonProperty("annualContrib")
	public void setAnnualContrib(double annualContrib)
	{
		this.annualContrib = annualContrib;
	}

	@JsonProperty("allocations")
	public Allocation[] getAllocations()
	{
		return allocations;
	}

	@JsonProperty("allocations")
	public void setAllocations(Allocation[] allocations)
	{
		this.allocations = allocations;
	}

	@JsonProperty("positions")
	public PositionSettings[] getPositions()
	{
		return positions;
	}

	@JsonProperty("positions")
	public void setPositions(PositionSettings[] positions)
	{
		this.positions = positions;
	}

	public com.roddyaj.invest.va.model.Allocation getAllocation()
	{
		if (allocation == null)
			allocation = new com.roddyaj.invest.va.model.Allocation(allocations);
		return allocation;
	}

	public PositionSettings getPosition(String symbol)
	{
		return Arrays.stream(positions).filter(a -> a.getSymbol().equals(symbol)).findAny().orElse(null);
	}

	public boolean getSell(String symbol)
	{
		boolean sell = false;
		PositionSettings position = getPosition(symbol);
		if (position.getSell() != null)
		{
			sell = position.getSell().booleanValue();
		}
		else
		{
			position = getPosition("_default");
			if (position.getSell() != null)
				sell = position.getSell().booleanValue();
		}
		return sell;
	}

	public String getPeriod(String symbol)
	{
		String period = null;
		PositionSettings position = getPosition(symbol);
		if (position.getPeriod() != null)
		{
			period = position.getPeriod();
		}
		else
		{
			position = getPosition("_default");
			period = position.getPeriod();
		}
		return period;
	}
}
