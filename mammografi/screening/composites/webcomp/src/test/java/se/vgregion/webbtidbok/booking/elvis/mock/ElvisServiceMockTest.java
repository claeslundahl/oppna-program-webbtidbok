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
package se.vgregion.webbtidbok.booking.elvis.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import se.vgregion.webbtidbok.ws.ArrayOfBookingPlace;
import se.vgregion.webbtidbok.ws.ArrayOfBookingTime;
import se.vgregion.webbtidbok.ws.BookingRequest;
import se.vgregion.webbtidbok.ws.BookingResponse;
import se.vgregion.webbtidbok.ws.ICentralBookingWSGetBookingICFaultFaultFaultMessage;
import se.vgregion.webbtidbok.ws.ICentralBookingWSGetBookingPlaceICFaultFaultFaultMessage;
import se.vgregion.webbtidbok.ws.ICentralBookingWSGetBookingTimeICFaultFaultFaultMessage;
import se.vgregion.webbtidbok.ws.ObjectFactory;

public class ElvisServiceMockTest {

	private ElvisServiceMock elvisServiceMock;
	private ObjectFactory objectFactory = new ObjectFactory();
	private BookingRequest bookingRequest;
	private String pNR1 = "19700123-9297";

	@Before
	public void setUp() throws Exception {
		elvisServiceMock = new ElvisServiceMock();
		elvisServiceMock.createMockData();
		bookingRequest = new BookingRequest();
		bookingRequest.setPnr(objectFactory.createString(pNR1));
		bookingRequest.setCentralTidbokID(Integer.valueOf(1));

	}

	@Test
	public void testCancelBooking() {
		// fail("Not yet implemented");
	}

	@Test
	public void testConfirmBooking() {
		// fail("Not yet implemented");
	}

	@Test
	public void testGetBooking() throws ICentralBookingWSGetBookingICFaultFaultFaultMessage {
		BookingResponse booking = elvisServiceMock.getBooking(bookingRequest);
		assertNotNull(booking);
	}

	@Test
	public void testGetBookingPlace() throws ICentralBookingWSGetBookingPlaceICFaultFaultFaultMessage {
		ArrayOfBookingPlace bookingPlace = elvisServiceMock.getBookingPlace(bookingRequest);
		assertNotNull(bookingPlace);
		assertEquals("Mottagning 1", bookingPlace.getBookingPlace().get(0).getMottagning().getValue());
	}

	@Test
	public void testGetBookingTime() throws ICentralBookingWSGetBookingTimeICFaultFaultFaultMessage {
		ArrayOfBookingTime bookingTime = elvisServiceMock.getBookingTime(bookingRequest);
		assertEquals("16:30", bookingTime.getBookingTime().get(2).getKlocka().getValue());
	}

	@Test
	public void testGetCalandar() {
		// fail("Not yet implemented");
	}

}
