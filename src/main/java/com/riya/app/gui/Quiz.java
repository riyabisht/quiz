package com.riya.app.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.riya.app.dao.QuestionsProvider;
import com.riya.app.model.Question;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.awt.Container;

public class Quiz {

    private JButton button;
    private static Quiz quiz = null;

    private static Quiz getQuiz() {
        if (quiz == null) {
            quiz = new Quiz();
        }
        return quiz;
    }

    private void generateQuestions(QuestionsProvider questionsProvider) {
        for (Question question : questionsProvider.getQuestions()) {
            createAndShowGUI(question);
        }
    }

    public static void main(String[] args) {
        Quiz quiz = Quiz.getQuiz();
        QuestionsProvider questionsProvider = QuestionsProvider.getQuestionsProvider();
        quiz.generateQuestions(questionsProvider);
    }

    private void createAndShowGUI(Question question) {
        String ques = question.getQues();
        String ans = question.getAns();
        List<String> otherOptions = question.getOtherOptions();

      JFrame frame = new JFrame("GridBagLayout");
      frame.setSize(400, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(5, 5, 5, 5);

      // Add components using GridBagConstraints
      JPanel questionPanel = new JPanel(new GridBagLayout());
      JLabel nameLabel = new JLabel(ques);
      gbc.gridx=0;
      gbc.gridy=0;
      questionPanel.add(nameLabel, gbc);
      
      // Row 1
      JPanel row1Panel = new JPanel(new GridBagLayout());
      JButton choice1Button = new JButton(ans);
      JButton choice2Button = new JButton(otherOptions.get(0));
      gbc.gridx = 0;
      gbc.gridy = 1;
      row1Panel.add(choice1Button, gbc);
      gbc.gridx = 1;
      row1Panel.add(choice2Button, gbc);
      
      //Row 2
      JPanel row2Panel = new JPanel(new GridBagLayout());
      JButton choice3Button = new JButton(otherOptions.get(1));
      JButton choice4Button = new JButton(otherOptions.get(2));
      gbc.gridx=0;
      gbc.gridy=1;
      row2Panel.add(choice3Button, gbc);
      gbc.gridx=1;
      row2Panel.add(choice4Button,gbc);

      //add panel to a single container
      Container contentPanel = frame.getContentPane();
      contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.Y_AXIS));
      contentPanel.add(questionPanel);
      contentPanel.add(row1Panel);
      contentPanel.add(row2Panel);
      frame.pack();
      frame.setVisible(true);
  }

}
