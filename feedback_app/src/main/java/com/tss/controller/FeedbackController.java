package com.tss.controller;

import com.tss.model.Feedback;
import com.tss.service.FeedbackService;
import com.tss.exception.ValidationException;
import com.tss.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/submitFeedback")
public class FeedbackController extends HttpServlet {

    private final FeedbackService service = new FeedbackService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/feedbackForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String dateStr = req.getParameter("sessionDate");
        String scStr = req.getParameter("sessionContent");
        String qrStr = req.getParameter("queryResolution");
        String itStr = req.getParameter("interactivity");
        String ilStr = req.getParameter("impactfulLearning");
        String cdsStr = req.getParameter("contentDeliverySkills");
        String comments = req.getParameter("comments");

        try {
            Feedback f = new Feedback();
            f.setName(name);
            f.setSessionDate(LocalDate.parse(dateStr));
            f.setSessionContent(parseInt(scStr));
            f.setQueryResolution(parseInt(qrStr));
            f.setInteractivity(parseInt(itStr));
            f.setImpactfulLearning(parseInt(ilStr));
            f.setContentDeliverySkills(parseInt(cdsStr));
            f.setComments(comments);

            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            session.setAttribute("sessionDate", dateStr);

            service.submitFeedback(f);

            req.getRequestDispatcher("/feedbackSuccess.jsp").forward(req, resp);

        } catch (ValidationException ve) {
            req.setAttribute("errorMessage", ve.getMessage());
            req.getRequestDispatcher("/feedbackForm.jsp").forward(req, resp);
        } catch (ServiceException se) {
            req.setAttribute("errorMessage", "Error saving feedback. Please try later.");
            req.getRequestDispatcher("/feedbackError.jsp").forward(req, resp);
        } catch (Exception ex) {
            req.setAttribute("errorMessage", "Unexpected error: " + ex.getMessage());
            req.getRequestDispatcher("/feedbackError.jsp").forward(req, resp);
        }
    }

    private int parseInt(String s) {
        if (s == null || s.trim().isEmpty()) return 0;
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
