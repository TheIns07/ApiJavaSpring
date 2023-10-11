package apiweb.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewServices {
    @Autowired
    private IReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public Reviews createReview(String reviewBody, String imdbID){
        Reviews review = reviewRepository.insert(new Reviews(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbID").is(imdbID))
                .apply(new Update().push("reviewIds").value(reviewBody))
                .first();

        return review;
    }
}
