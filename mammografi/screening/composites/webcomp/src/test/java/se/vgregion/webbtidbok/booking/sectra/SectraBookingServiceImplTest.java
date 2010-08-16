package se.vgregion.webbtidbok.booking.sectra;

import static org.junit.Assert.assertEquals;
import static se.vgregion.webbtidbok.lang.DateHandler.calendarFromDate;
import static se.vgregion.webbtidbok.lang.DateHandler.dateFor;
import static se.vgregion.webbtidbok.lang.DateHandler.xmlCalendarFor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import se.vgregion.webbtidbok.ws.sectra.ArrayOfdateTime;
import se.vgregion.webbtidbok.ws.sectra.IRisRescheduleListFreeDaysErrorInfoFaultFaultMessage;

public class SectraBookingServiceImplTest {

    private SectraBookingServiceImpl service;
    
    private static final String examNr = "TEST";
    private static final String patientNr = "19121212-1212";
    private static final String sectionId = "TESTSECTION";
    
    @Before
    public void setUp() throws Exception {
        service = new SectraBookingServiceImpl();
        service.setThePort(new TestMock());
        service.setBookingMapperSectra(new BookingMapperSectra());
        
        service.setExaminationNr(examNr);
        service.setPatientNr(patientNr);
    }

    @Test
    @Ignore
    public void testGetBooking() {
    }

    @Test
    @Ignore
    public void testGetSurgeries() {
    }

    @Test
    public void testGetFreeDays() {
        List<Date> freeDays = service.getFreeDays(dateFor(2010, 8, 1), dateFor(2010, 8, 31), sectionId);
        
        Calendar cal = calendarFromDate(freeDays.get(0));
        assertEquals(2010,cal.get(Calendar.YEAR));
        assertEquals(7,cal.get(Calendar.MONTH));
        assertEquals(2,cal.get(Calendar.DAY_OF_MONTH));
        
        cal = calendarFromDate(freeDays.get(1));
        assertEquals(2010,cal.get(Calendar.YEAR));
        assertEquals(7,cal.get(Calendar.MONTH));
        assertEquals(4,cal.get(Calendar.DAY_OF_MONTH));

        cal = calendarFromDate(freeDays.get(2));
        assertEquals(2010,cal.get(Calendar.YEAR));
        assertEquals(7,cal.get(Calendar.MONTH));
        assertEquals(8,cal.get(Calendar.DAY_OF_MONTH));

        cal = calendarFromDate(freeDays.get(3));
        assertEquals(2010,cal.get(Calendar.YEAR));
        assertEquals(7,cal.get(Calendar.MONTH));
        assertEquals(16,cal.get(Calendar.DAY_OF_MONTH));
    }
    
    class TestMock extends SectraEmptyWSMock {

        @Override
        public ArrayOfdateTime listFreeDays(XMLGregorianCalendar startDate,
                XMLGregorianCalendar endDate, String examinationNr,
                String sectionId)
                throws IRisRescheduleListFreeDaysErrorInfoFaultFaultMessage {
            List<XMLGregorianCalendar> resList = new ArrayList<XMLGregorianCalendar>();
            resList.add(xmlCalendarFor(2010, 8, 2));
            resList.add(xmlCalendarFor(2010, 8, 4));
            resList.add(xmlCalendarFor(2010, 8, 8));
            resList.add(xmlCalendarFor(2010, 8, 16));

            return new ArrayOfdateTimeMock(resList);
        }
        
        
    }

}
