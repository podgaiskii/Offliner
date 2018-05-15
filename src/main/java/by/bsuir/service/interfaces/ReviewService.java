package by.bsuir.service.interfaces;

import by.bsuir.model.Review;

import java.util.List;

public interface ReviewService {

    void addReview(int userID, Review review);
    List<Review> getAllReviews();

}
