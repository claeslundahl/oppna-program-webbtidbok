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

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import se.vgregion.webbtidbok.ws.sectra.ArrayOfBookingInfo;
import se.vgregion.webbtidbok.ws.sectra.ArrayOfSection;
import se.vgregion.webbtidbok.ws.sectra.ArrayOfTimeBlock;
import se.vgregion.webbtidbok.ws.sectra.ArrayOfdateTime;
import se.vgregion.webbtidbok.ws.sectra.BookingInfo;
import se.vgregion.webbtidbok.ws.sectra.IRisReschedule;
import se.vgregion.webbtidbok.ws.sectra.IRisRescheduleGetBookingInfoErrorInfoFaultFaultMessage;
import se.vgregion.webbtidbok.ws.sectra.IRisRescheduleGetBookingsErrorInfoFaultFaultMessage;
import se.vgregion.webbtidbok.ws.sectra.IRisRescheduleListFreeDaysErrorInfoFaultFaultMessage;
import se.vgregion.webbtidbok.ws.sectra.IRisRescheduleListFreeTimesErrorInfoFaultFaultMessage;
import se.vgregion.webbtidbok.ws.sectra.IRisRescheduleListSectionsErrorInfoFaultFaultMessage;
import se.vgregion.webbtidbok.ws.sectra.IRisRescheduleRescheduleErrorInfoFaultFaultMessage;
import se.vgregion.webbtidbok.ws.sectra.Section;
import se.vgregion.webbtidbok.ws.sectra.TimeBlock;

/**
 * This is an empty mock class. Use this if you need a Sectra mock and don't want to implement
 * each and every method yourself.
 */
public class SectraEmptyWSMock implements IRisReschedule {

    @Override
    public BookingInfo getBookingInfo(String patientId, String examinationNr)
            throws IRisRescheduleGetBookingInfoErrorInfoFaultFaultMessage {
        return null;
    }

    @Override
    public ArrayOfBookingInfo getBookings(String patientId)
            throws IRisRescheduleGetBookingsErrorInfoFaultFaultMessage {
        return null;
    }

    /**
     * Use this class when mocking the getBookings call.
     */
    public class ArrayOfBookingInfoMock extends ArrayOfBookingInfo {
        public ArrayOfBookingInfoMock(List<BookingInfo> list) {
            bookingInfo = list;
        }
    }

    @Override
    public ArrayOfdateTime listFreeDays(XMLGregorianCalendar startDate,
            XMLGregorianCalendar endDate, String examinationNr,
            String sectionId)
            throws IRisRescheduleListFreeDaysErrorInfoFaultFaultMessage {
        return null;
    }

    /**
     * Use this class when mocking the listFreeDays call.
     */
    public class ArrayOfdateTimeMock extends ArrayOfdateTime {
        public ArrayOfdateTimeMock(List<XMLGregorianCalendar> list) {
            dateTime = list;
        }
    }
    
    @Override
    public ArrayOfTimeBlock listFreeTimes(XMLGregorianCalendar startDate,
            XMLGregorianCalendar endDate, String examinationNr,
            String sectionId)
            throws IRisRescheduleListFreeTimesErrorInfoFaultFaultMessage {
        return null;
    }

    /**
     * Use this class when mocking the listFreeTimes call.
     */
    public class ArrayOfTimeBlockMock extends ArrayOfTimeBlock {
        public ArrayOfTimeBlockMock(List<TimeBlock> list) {
            timeBlock = list;
        }
    }
    
    @Override
    public ArrayOfSection listSections(String examinationNr)
            throws IRisRescheduleListSectionsErrorInfoFaultFaultMessage {
        return null;
    }

    /**
     * Use this class when mocking the listSections call.
     */
    public class ArrayOfSectionMock extends ArrayOfSection {
        public ArrayOfSectionMock(List<Section> list) {
            section = list;
        }
    }

    @Override
    public BookingInfo reschedule(String examinationNr, String newTimeId,
            XMLGregorianCalendar startTime, Boolean printNewNotice,
            String rescheduleComment)
            throws IRisRescheduleRescheduleErrorInfoFaultFaultMessage {
        return null;
    }

}
