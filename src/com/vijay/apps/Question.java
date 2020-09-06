package com.vijay.apps;

public class Question {
	private String question;
	private  String option1,option2,option3,option4;
	private  int correctAnswer;
	private  int selectedAnswer;
	private  int result;
	public void setSelectedAnswer(int s) {
		selectedAnswer=s;
		calculateResult();
	}
	public String getQuestion()
	{
		return question;
	}
	public String get1()
	{
		return option1;
	}
	public String get2()
	{
		return option2;
	}public String get3()
	{
		return option3;
	}public String get4()
	{
		return option4;
	}
	
	public int getResult() {
		return result;
	}
	  void calculateResult(){
	
	this.result = this.selectedAnswer == this.correctAnswer ? 1 : 0;
	
	  }
	
	public Question(String  question, int correctAnswer,
			String  option1,
			String  option2,
			String  option3,
			String  option4
			) {
		// TODO Auto-generated constructor stub
		  this.correctAnswer=correctAnswer;
		  this.option1=option1;
		  this.option2=option2;
		  this.option3=option3;
		  this.option4=option4;
		  this.question=question;
		this.result=-1;
	}
	

}
