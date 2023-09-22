package com.app.health.model;

import java.util.List;

public class SocialQuestionModel {

    public final String title;
    public final String question;
    public final List<String> options;

    public final List<String> answers;

    public final boolean isMultiSelect;


    public SocialQuestionModel(String title, String question, List<String> options, List<String> answers, boolean isMultiSelect) {
        this.title = title;
        this.question = question;
        this.options = options;
        this.answers = answers;
        this.isMultiSelect = isMultiSelect;
    }


}
