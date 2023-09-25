package com.riya.app.gui;



import com.riya.app.dao.QuestionsProvider;
import com.riya.app.model.Question;

public class Quiz {

    private static Quiz quiz = null;


    private static Quiz getQuiz() {
        if (quiz == null) {
            quiz = new Quiz();
        }
        return quiz;
    }

    // private void generateQuestions(QuestionsProvider questionsProvider, HomeScreen homeScreen) {
    //     for (Question question : questionsProvider.getQuestions()) {
    //         homeScreen.initialiseGUI(question);
    //     }
  
    
    // }
    
    public static void main(String[] args) {
        Quiz quiz = Quiz.getQuiz();
        QuestionsProvider questionsProvider = QuestionsProvider.getQuestionsProvider();
        HomeScreen homeScreen = new HomeScreen(questionsProvider.getQuestions());        
    }

    
}
