package com.riya.app.dao;

import java.util.ArrayList;

import org.bson.Document;
import com.riya.app.model.Question;

import lombok.Getter;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.riya.app.database.DatabaseConnection;

public class QuestionsProvider {

    @Getter
    private ArrayList<Question> questions;

    private static QuestionsProvider questionsProvider = null;

    private QuestionsProvider() {
        MongoClient mongoClient = DatabaseConnection.getDatabaseConnection().getClient();
        MongoDatabase db = mongoClient.getDatabase("quizDatabase");
        MongoCollection<Question> questionCollection = db.getCollection("quizCollection", Question.class);
        questions = new ArrayList<>();
        for (Question question : questionCollection.find()) {
            this.questions.add(question);
        }
    }

    public static QuestionsProvider getQuestionsProvider() {
        if (questionsProvider == null) {
            questionsProvider = new QuestionsProvider();
        }
        return questionsProvider;
    }

    public Question getQuestionNumber(Integer questionNo) {
        return questions.get(questionNo);
    }

    public static void main(String[] args) {
        QuestionsProvider questionsProvider = QuestionsProvider.getQuestionsProvider();
        System.out.println(questionsProvider.getQuestions());
    }

}
