package com.riya.app.gui;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.riya.app.dao.QuestionsProvider;
import com.riya.app.model.Question;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Container;

public class HomeScreen implements ActionListener {

  private static HomeScreen homeScreen = null;
  private JFrame frame;
  private JPanel questionPanel;
  private JLabel nameLabel;
  private JPanel row1Panel;
  private JPanel row2Panel;
  private JPanel row3Panel;
  private JButton choice1Button;
  private JButton choice2Button;
  private JButton choice3Button;
  private JButton choice4Button;
  private JButton nextButton;
  private Container contentPanel;

  ArrayList<Question> questions;
  private int currentQuestionIndex;

  public HomeScreen(ArrayList<Question> questions) {
    this.questions = questions;
    currentQuestionIndex = 0;

    frame = new JFrame("GridBagLayout");
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    initialiseGUI(questions);
    frame.pack();
    frame.setVisible(true);

  }


  public void initialiseGUI(ArrayList<Question> questions) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);

    // Add components using GridBagConstraints
    questionPanel = new JPanel(new GridBagLayout());
    nameLabel = new JLabel(questions.get(currentQuestionIndex).getQues());
    gbc.gridx = 0;
    gbc.gridy = 0;
    questionPanel.add(nameLabel, gbc);

    // Row 1
    row1Panel = new JPanel(new GridBagLayout());
    choice1Button = new JButton(questions.get(currentQuestionIndex).getAns());
    choice2Button = new JButton(questions.get(currentQuestionIndex).getOtherOptions().get(0));
    gbc.gridx = 0;
    gbc.gridy = 1;
    row1Panel.add(choice1Button, gbc);
    gbc.gridx = 1;
    row1Panel.add(choice2Button, gbc);

    // Row 2
    row2Panel = new JPanel(new GridBagLayout());
    choice3Button = new JButton(questions.get(currentQuestionIndex).getOtherOptions().get(1));
    choice4Button = new JButton(questions.get(currentQuestionIndex).getOtherOptions().get(2));
    gbc.gridx = 0;
    gbc.gridy = 1;
    row2Panel.add(choice3Button, gbc);
    gbc.gridx = 1;
    row2Panel.add(choice4Button, gbc);

    // next button

    nextButton = new JButton("Next");
    nextButton.addActionListener(this);
    row3Panel = new JPanel(new GridBagLayout());
    gbc.gridx = 0;
    gbc.gridy = 1;
    row3Panel.add(nextButton, gbc);

    contentPanel = frame.getContentPane();
    contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
    contentPanel.add(questionPanel);
    contentPanel.add(row1Panel);
    contentPanel.add(row2Panel);
    contentPanel.add(row3Panel);

  }

  @Override
  public void actionPerformed(ActionEvent event) {
    currentQuestionIndex++;
    if (currentQuestionIndex < questions.size()) {
      nameLabel.setText(questions.get(currentQuestionIndex).getQues());
      choice1Button.setText(questions.get(currentQuestionIndex).getOtherOptions().get(0));
      choice2Button.setText(questions.get(currentQuestionIndex).getOtherOptions().get(1));
      choice3Button.setText(questions.get(currentQuestionIndex).getOtherOptions().get(2));
      choice1Button.setText(questions.get(currentQuestionIndex).getOtherOptions().get(3));
    } else {
      JOptionPane.showMessageDialog(frame, "No more questions.");
      nextButton.setEnabled(false);
    }
  }

}
