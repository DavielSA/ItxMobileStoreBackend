package com.itxmobilestore.review.mapper;

import com.itxmobilestore.review.model.entity.Review;
import com.itxmobilestore.review.model.request.ReviewRequest;
import com.itxmobilestore.review.model.response.ReviewResponse;
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
public class ReviewMapperImpl implements ReviewMapper {

    private final DatatypeFactory datatypeFactory;

    public ReviewMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public ReviewResponse reviewToReviewResponse(Review review) {
        if ( review == null ) {
            return null;
        }

        Long id = null;
        Integer rating = null;
        String createdAt = null;

        id = review.getId();
        rating = review.getRating();
        createdAt = xmlGregorianCalendarToString( dateToXmlGregorianCalendar( review.getCreatedAt() ), null );

        Long customerId = null;
        String reviewText = null;
        String lastUpdatedAt = null;

        ReviewResponse reviewResponse = new ReviewResponse( id, customerId, reviewText, rating, createdAt, lastUpdatedAt );

        return reviewResponse;
    }

    @Override
    public Review reviewRequestToReview(ReviewRequest reviewRequest) {
        if ( reviewRequest == null ) {
            return null;
        }

        Review review = new Review();

        if ( reviewRequest.rating() != null ) {
            review.setRating( reviewRequest.rating() );
        }

        return review;
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
