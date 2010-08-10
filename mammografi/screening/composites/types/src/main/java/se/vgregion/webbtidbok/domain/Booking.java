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
package se.vgregion.webbtidbok.domain;

import java.io.Serializable;
import java.util.Date;

public abstract class Booking implements Serializable{
	
	private static final long serialVersionUID = 7686724985905225950L;
	private String patientName;
	private String surgeryAddress;
	private String patientId;
	private Date startTime;
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	/**
	 * The firstname and lastname of the patient.
	 * @return {@link String} of fisrtname and lastname.
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * 
	 * @param patientName Fisrtname ond lastname.
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * 
	 * @return {@link String} address to the surgery.
	 */
	public String getSurgeryAddress() {
		return surgeryAddress;
	}

	/**
	 * 
	 * @param surgeryAddress {@link String} address to the surgery.
	 */
	public void setSurgeryAddress(String surgeryAddress) {
		this.surgeryAddress = surgeryAddress;
	}
	
	

}
