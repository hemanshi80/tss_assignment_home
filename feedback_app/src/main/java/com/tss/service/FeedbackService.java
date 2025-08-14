package com.tss.service;

import com.tss.dao.FeedbackDao;
import com.tss.exception.DaoException;
import com.tss.exception.ServiceException;
import com.tss.exception.ValidationException;
import com.tss.model.Feedback;

public class FeedbackService {

    private final FeedbackDao feedbackDao = new FeedbackDao();

    private void validateRatings(Feedback f) throws ValidationException {
        if (f.getName() == null || f.getName().trim().isEmpty()) {
            throw new ValidationException("Name is required.");
        }
        if (f.getSessionDate() == null) {
            throw new ValidationException("Session date is required.");
        }
        int[] ratings = {
            f.getSessionContent(),
            f.getQueryResolution(),
            f.getInteractivity(),
            f.getImpactfulLearning(),
            f.getContentDeliverySkills()
        };
        for (int r : ratings) {
            if (r < 1 || r > 10) {
                throw new ValidationException("Ratings must be numbers between 1 and 10.");
            }
        }
    }

    public void submitFeedback(Feedback feedback) throws ValidationException, ServiceException {
    	 validateRatings(feedback);
    	    try {
    	        feedbackDao.saveFeedback(feedback);
    	    } catch (DaoException e) {
    	        throw new ServiceException("Unable to save feedback", e);
    	    } catch (ClassNotFoundException e) {
    	        throw new ServiceException("Database driver not found", e);
    	    }
}
}
