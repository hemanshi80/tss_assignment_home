package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.db.DBConnection;
import com.tss.model.Question;

public class QuestionDao {
	
	public List<Question> getAllQuestions() {
	    List<Question> questions = new ArrayList<>();
	    String sql = "SELECT * FROM questions";

	    try (Connection conn = DBConnection.connect();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Question q = new Question();
	            q.setId(rs.getInt("id"));
	            q.setQuestionText(rs.getString("question_text"));
	            q.setOptionA(rs.getString("option_a"));
	            q.setOptionB(rs.getString("option_b"));
	            q.setOptionC(rs.getString("option_c"));
	            q.setOptionD(rs.getString("option_d"));
	            q.setCorrectOption(rs.getString("correct_option"));
	            questions.add(q);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return questions;
	}

}
