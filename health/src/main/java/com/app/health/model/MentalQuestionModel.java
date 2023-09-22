package com.app.health.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MentalQuestionModel {

    @SerializedName("question")
    public final String question;

    @SerializedName("answer")
    public String answer;
    @SerializedName("options")
    public List<String> options;

    public MentalQuestionModel(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.options = new ArrayList<String>(){{add("0");add("1");add("2");add("3");add("4");add("5");add("6");add("7");add("8");add("9");add("10");}};
    }
}
