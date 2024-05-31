package com.anunciaMe.api.dtos;

public class ReviewResponse {
    boolean done;
    ReviewDto review;

    public ReviewResponse(boolean done, ReviewDto review) {
        this.done = done;
        this.review = review;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public ReviewDto getReview() {
        return review;
    }

    public void setReview(ReviewDto review) {
        this.review = review;
    }
}
