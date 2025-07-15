package com.itxmobilestore.notification.mapper;

import com.itxmobilestore.notification.model.entity.Notification;
import com.itxmobilestore.notification.model.request.NotificationRequest;
import com.itxmobilestore.notification.model.response.NotificationResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-11T11:18:52+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
public class NotificationMapperImpl implements NotificationMapper {

    private final DatatypeFactory datatypeFactory;

    public NotificationMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public NotificationResponse notificationToNotificationResponse(Notification notification) {
        if ( notification == null ) {
            return null;
        }

        Long id = null;
        String message = null;
        String createdAt = null;

        id = notification.getId();
        message = notification.getMessage();
        createdAt = xmlGregorianCalendarToString( dateToXmlGregorianCalendar( notification.getCreatedAt() ), null );

        Long customerId = null;
        String notificationStatus = null;
        String lastUpdatedAt = null;

        NotificationResponse notificationResponse = new NotificationResponse( id, customerId, message, notificationStatus, createdAt, lastUpdatedAt );

        return notificationResponse;
    }

    @Override
    public Notification notificationRequestToNotification(NotificationRequest notificationRequest) {
        if ( notificationRequest == null ) {
            return null;
        }

        Notification notification = new Notification();

        if ( notificationRequest.message() != null ) {
            notification.setMessage( notificationRequest.message() );
        }

        return notification;
    }

    private String xmlGregorianCalendarToString( XMLGregorianCalendar xcal, String dateFormat ) {
        if ( xcal == null ) {
            return null;
        }

        if (dateFormat == null ) {
            return xcal.toString();
        }
        else {
            Date d = xcal.toGregorianCalendar().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat( dateFormat );
            return sdf.format( d );
        }
    }

    private XMLGregorianCalendar dateToXmlGregorianCalendar( Date date ) {
        if ( date == null ) {
            return null;
        }

        GregorianCalendar c = new GregorianCalendar();
        c.setTime( date );
        return datatypeFactory.newXMLGregorianCalendar( c );
    }
}
