package by.bsuir.dao;

import by.bsuir.model.Review;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDao extends AbstractDao<Review> {

    @Override
    protected Class getEntityClass() {
        return Review.class;
    }

}
