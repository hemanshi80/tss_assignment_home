package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tss.dao.QuestionDao;
import com.tss.dao.ResultDao;
import com.tss.model.Question;
import com.tss.model.User;

@WebServlet("/quiz")
public class QuizController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private QuestionDao questionDao = new QuestionDao();
    private ResultDao resultDao = new ResultDao();

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        Map<Integer, String> answers = (Map<Integer, String>) session.getAttribute("answers");
        Integer currentIndex = (Integer) session.getAttribute("currentIndex");
        
        System.out.println("Current Index: " + currentIndex);
        System.out.println("Questions from session: " + (questions == null ? "null" : questions.size()));

        if (questions == null) {
            questions = questionDao.getAllQuestions();
            Collections.shuffle(questions);
            System.out.println("Loaded from DB: " + questions.size());
            answers = new HashMap<>();
            currentIndex = 0;
        } else {
            // Store user's answer from previous question
            String selected = request.getParameter("option");
            Question prevQuestion = questions.get(currentIndex);
            answers.put(prevQuestion.getId(), selected);
            currentIndex++;
        }

        // Check if quiz is over
        if (currentIndex >= questions.size()) {
            int score = 0;
            for (Question q : questions) {
                String userAnswer = answers.get(q.getId());
                if (q.getCorrectOption().equalsIgnoreCase(userAnswer)) {
                    score++;
                }
            }

            // Save score
            User user = (User) session.getAttribute("user");
            resultDao.saveResult(user.getId(), score);

            // Clear session data
            session.removeAttribute("questions");
            session.removeAttribute("answers");
            session.removeAttribute("currentIndex");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<link rel='stylesheet' href='style.css'>");
            out.println("<div class='terminal-box'>");
            out.println("<h2>Quiz Completed!</h2>");
            out.println("<h3>Your Score: " + score + " out of " + questions.size() + "</h3>");
            out.println("<a href='logout'>Logout</a>");
            out.println("</div></div>");
            return;
        }

        // Show next question
        Question currentQuestion = questions.get(currentIndex);
        session.setAttribute("questions", questions);
        session.setAttribute("answers", answers);
        session.setAttribute("currentIndex", currentIndex);

        int totalQuestions = questions.size();
        int progressPercent = (int) (((double) (currentIndex + 1) / totalQuestions) * 100);
        int currentQuestionNum = currentIndex + 1;
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("<div class='container'>");
        out.println("<div class='terminal-box'>");
        out.println("<div class='progress-container' data-label='Question " + currentQuestionNum + " of " + totalQuestions + "'>");
        out.println("<div class='progress-bar' style='width:" + progressPercent + "%'></div>");
        out.println("</div><br>");
        out.println("<form method='post' action='quiz'>");
        out.println("<h3>Q" + currentQuestionNum + ": " + currentQuestion.getQuestionText() + "</h3>");
        out.println("<input type='radio' name='option' value='A' required> " + currentQuestion.getOptionA() + "<br><br>");
        out.println("<input type='radio' name='option' value='B'> " + currentQuestion.getOptionB() + "<br><br>");
        out.println("<input type='radio' name='option' value='C'> " + currentQuestion.getOptionC() + "<br><br>");
        out.println("<input type='radio' name='option' value='D'> " + currentQuestion.getOptionD() + "<br><br>");
        out.println("<input type='submit' value='Next'>");
        out.println("</form>");
        out.println("</div></div>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response); // handle GET same as POST
    }
}
