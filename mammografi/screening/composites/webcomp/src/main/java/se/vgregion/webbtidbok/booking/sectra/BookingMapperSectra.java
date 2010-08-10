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
package se.vgregion.webbtidbok.booking.sectra;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import se.vgregion.webbtidbok.domain.Booking;
import se.vgregion.webbtidbok.domain.sectra.BookingSectra;
import se.vgregion.webbtidbok.ws.sectra.BookingInfo;
import se.vgregion.webbtidbok.ws.sectra.Section;
import se.vgregion.webbtidbok.ws.sectra.TimeBlock;

public class BookingMapperSectra {

	public Booking bookingMapping(BookingInfo bookingInfo) {
		BookingSectra booking = new BookingSectra();
		booking.setPatientName(bookingInfo.getPatientName().getValue());
		booking.setPatientId(bookingInfo.getPatientId().getValue());
		booking.setExamTypeCode(bookingInfo.getExamTypeCode().getValue());
		booking.setExamType(bookingInfo.getExamType().getValue());
		booking.setExaminationId(bookingInfo.getExamNo().getValue());
		TimeBlock value = bookingInfo.getBookedTime().getValue();
		XMLGregorianCalendar startTime = value.getStartTime();
		booking.setStartTime(startTime.toGregorianCalendar().getTime());
		JAXBElement<Section> section = bookingInfo.getBookedTime().getValue().getSection();
		String sectionName = section.getValue().getName().getValue();
		String address = bookingInfo.getBookedTime().getValue().getSection().getValue().getAddress().getValue();
		booking.setSurgeryAddress(sectionName + ", " + address);
		return booking;
	}

}
