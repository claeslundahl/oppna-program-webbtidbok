/**
 * Copyright 2009 Vastra Gotalandsregionen
 *
 *   This library is free software; you can redistribute it and/or modify
 *   it under the terms of version 2.1 of the GNU Lesser General Public
 *   License as published by the Free Software Foundation.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this library; if not, write to the
 *   Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 *   Boston, MA 02111-1307  USA
 */
package se.vgregion.webbtidbok;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.stereotype.Service;

import se.vgregion.webbtidbok.lang.DateHandler;
import se.vgregion.webbtidbok.lang.StringHandler;
import se.vgregion.webbtidbok.ws.BookingRequest;
import se.vgregion.webbtidbok.ws.BookingResponse;
import se.vgregion.webbtidbok.ws.CentralBookingWS;
import se.vgregion.webbtidbok.ws.GetBooking;
import se.vgregion.webbtidbok.ws.ICentralBookingWS;
import se.vgregion.webbtidbok.ws.ICentralBookingWSGetBookingICFaultFaultFaultMessage;
import se.vgregion.webbtidbok.ws.ObjectFactory;


public class BookingResponseLocal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/*
	Pnr	String	YYYMMdd-nnnn
	Namn	String	Patientens namn
	Vardgivare	String	V�rdgivare, klar text
	Mottgning	string	
	Adress	String	
	BokadTid	DateTime	Yyyy-MM-dd HH:mm
	CentralTidbokid		
	MobilTel	String	
	Epost	string	
	AntalOmbok	int	Antal gjorda ombokningar
	MaxAntalOmbok	int	Max antal till�tna ombokningar
	Place	BookingPlace	

	
	
	*/
	private String pnr;
	private String name;
	private String localDoctor;
	private String address;
	private Date timeBooking;
	private String timeBookingString;
	private String vTeam;
	private String mainSector;
	private String mobilePhone;
	private String email;
	private int numberBookings;
	private int maxNbrBookings = 2;
	
	private String displayName;
	
	public BookingResponseLocal() {
		// TODO  Auto-generated constructor stub
	}
	
	@SuppressWarnings("deprecation")
	public BookingResponseLocal(BookingResponse response){
		
		setPnr(response.getPnr().getValue());
		setName(response.getNamn().getValue());
		setDisplayName(response.getNamn().getValue());
		setLocalDoctor(response.getVardgivare().getValue());
		setAddress(response.getAddress().getValue()); //missing getmethod.
		
		
		setTeam(response.getExternalID().getValue());
		
		setMainSector(response.getMottagning().getValue());
		setMobilePhone(response.getMobilTel().getValue());
		setEmail(response.getEpost().getValue());// missing email
		this.setNumberOfBookings(response.getAntalOmbok());
		this.setMaxNbrBookings(response.getMaxAntalOmbok());
		//response.getCentralTidbokID()
		
		//Set time booking
		timeBooking = new Date();
		//set hours, minutes
		timeBooking.setHours(response.getBokadTid().getHour());
		timeBooking.setMinutes(response.getBokadTid().getMinute());
		timeBooking.setSeconds(response.getBokadTid().getSecond());
		timeBooking.setMonth(response.getBokadTid().getMonth());
		timeBooking.setYear(response.getBokadTid().getYear() - 1900);
		timeBooking.setDate(response.getBokadTid().getDay());
		
		
		setTimeBookingString(DateHandler.setLocaleString(timeBooking));
		setTimeBookingString(StringHandler.toFirstLetterToUpperCase(getTimeBookingString()));
		
	}
	
	public void setDisplayName(String name) {
		String n[] = name.toLowerCase().split(", ");
		
		n[0] = StringHandler.toFirstLetterToUpperCase(n[0]);
		n[1] = StringHandler.toFirstLetterToUpperCase(n[1]);
		displayName = n[1] + " " + n[0];

		System.out.println("displayname: " + displayName);
	}

	public void setPnr(String pnr){
		this.pnr = pnr;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setLocalDoctor(String doctor){
		this.localDoctor = doctor;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setTimeBooking(Date tBooking){
		this.timeBooking = tBooking;
	}
	
	public void setTimeBookingString(String sBooking){
		this.timeBookingString = sBooking;
	}
	
	public void setTeam(String t){
		this.vTeam = t;
	}
	
	public void setMainSector(String sector){
		
		this.mainSector = sector;
	}
	
	public void setMobilePhone(String mPhone){
		this.mobilePhone = mPhone;
	}
	
	public void setEmail(String email){
		this.email = email;
	}	
	
	public void setNumberOfBookings(int nbrBookings){
		this.numberBookings = nbrBookings;
	}
	
	public void setMaxNbrBookings(int maxBookings){
		this.maxNbrBookings = maxBookings;
	}
	
	
	
	
	public String getPnr(){
		return pnr;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public String getLocalDoctor(){
		return this.localDoctor;
	}
	
	public String getAddress(){
		return address;
	}
	
	public Date getTimeBooking(){
		return this.timeBooking;
	}
	
	public String getTimeBookingString(){
		return this.timeBookingString;
	}
	public String getTeam(){
		return this.vTeam;
	}
	
	public String getMainSector(){
		
		return mainSector;
	}
	
	public String getMobilePhone(){
		return mobilePhone;
	}
	
	public String getEmail(){
		return this.email;
	}	
	
	public int getNumberOfBookings(){
		return this.numberBookings;
	}
	
	public int getMaxNbrBookings(){
		return this.maxNbrBookings;
	}
	
	
	
	
	
	
	
	public String toString(){
		
		return  "pnr " + pnr +
		" name " + name +
		" doctor " + localDoctor +
		" address " + address +
		" booking " + timeBooking +
		" team " + vTeam +
		" main sector " + mainSector +
		" mobilephone " + mobilePhone +
		" email " + email +
		" numberBookings " + numberBookings +
		" maxNbrBookings " + maxNbrBookings;
	}
	
}
