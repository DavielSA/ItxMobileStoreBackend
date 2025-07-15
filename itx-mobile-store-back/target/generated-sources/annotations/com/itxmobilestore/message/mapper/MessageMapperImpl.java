package com.itxmobilestore.message.mapper;

import com.itxmobilestore.message.model.entity.Message;
import com.itxmobilestore.message.model.request.MessageRequest;
import com.itxmobilestore.message.model.response.MessageResponse;
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
public class MessageMapperImpl implements MessageMapper {

    private final DatatypeFactory datatypeFactory;

    public MessageMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public MessageResponse messageToMessageResponse(Message message) {
        if ( message == null ) {
            return null;
        }

        Long id = null;
        String createdAt = null;

        id = message.getId();
        createdAt = xmlGregorianCalendarToString( dateToXmlGregorianCalendar( message.getCreatedAt() ), null );

        Long customerId = null;
        String messageContent = null;
        String messageStatus = null;
        String lastUpdatedAt = null;

        MessageResponse messageResponse = new MessageResponse( id, customerId, messageContent, messageStatus, createdAt, lastUpdatedAt );

        return messageResponse;
    }

    @Override
    public Message messageRequestToMessage(MessageRequest messageRequest) {
        if ( messageRequest == null ) {
            return null;
        }

        Message message = new Message();

        if ( messageRequest.subject() != null ) {
            message.setSubject( messageRequest.subject() );
        }
        if ( messageRequest.content() != null ) {
            message.setContent( messageRequest.content() );
        }

        return message;
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
