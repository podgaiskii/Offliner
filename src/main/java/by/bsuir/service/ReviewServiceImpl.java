package by.bsuir.service;

import by.bsuir.dao.ReviewDao;
import by.bsuir.model.Review;
import by.bsuir.service.interfaces.ReviewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewDao reviewDao;

    public void setReviewDao(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    @Transactional
    public void addReview(int userID, Review review) {
        review.setUserID(userID);
        review.setDate(Date.valueOf(new java.util.Date().toString()));
        reviewDao.add(review);
    }

    @Override
    @Transactional
    public List<Review> getAllReviews() {
        return reviewDao.getAll();
    }
}
