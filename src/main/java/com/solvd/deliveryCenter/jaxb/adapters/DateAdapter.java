package com.solvd.deliveryCenter.jaxb.adapters;

import java.sql.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date>{

	@Override
	public Date unmarshal(String v) throws Exception {
		return Date.valueOf(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return v.toString();
	}
}