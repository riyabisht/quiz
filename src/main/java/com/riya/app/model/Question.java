package com.riya.app.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

public class Question {
    @Getter
    @Setter
    String ques;

    @Getter
    @Setter
    String ans;

    @Getter
    @Setter
    List<String> otherOptions;

    public Question() {

    }

    @Override
    public String toString() {
        return ques + "\n" + ans + "\n" + otherOptions.toString();
    }
}
