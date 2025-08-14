package com.tss.model;

public class Question {

	 private int id;
	    private String questionText;
	    private String optionA;
	    private String optionB;
	    private String optionC;
	    private String optionD;
	    private String correctOption;
	    
	    
		public int getId() {
			return id;
		}
		public String getQuestionText() {
			return questionText;
		}
		public String getOptionA() {
			return optionA;
		}
		public String getOptionB() {
			return optionB;
		}
		public String getOptionC() {
			return optionC;
		}
		public String getOptionD() {
			return optionD;
		}
		public String getCorrectOption() {
			return correctOption;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setQuestionText(String questionText) {
			this.questionText = questionText;
		}
		public void setOptionA(String optionA) {
			this.optionA = optionA;
		}
		public void setOptionB(String optionB) {
			this.optionB = optionB;
		}
		public void setOptionC(String optionC) {
			this.optionC = optionC;
		}
		public void setOptionD(String optionD) {
			this.optionD = optionD;
		}
		public void setCorrectOption(String correctOption) {
			this.correctOption = correctOption;
		}
	    
}
