```mermaid
graph TD;
    app--> dao;
    app --> database;
    app --> gui;
    app --> model;
    dao --> QuestionProvider
    database --> DatabaseConnection
    gui --> quiz
    gui --> HomeScreen
    gui --> HighScoreScreen
    model --> HighScore
    model --> Question
```