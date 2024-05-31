package com.anunciaMe.api.dtos.conversors;

import com.anunciaMe.api.dtos.ReviewDto;
import com.anunciaMe.entities.Review.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewConversor {
    public static ReviewDto toDto(Review review){
        return new ReviewDto(review.getId(), review.getCompra().getId(), review.getCalificacion(),
                review.getMensaje(), review.getComprador()==null?null:review.getComprador().getId());
    }
    public static List<ReviewDto> toDtos(List<Review> reviews){
        List<ReviewDto> dtos = new ArrayList<>();
        for(Review review: reviews){
            dtos.add(toDto(review));
        }
        return dtos;
    }

}
