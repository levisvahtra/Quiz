package com.example.opilane.quiz;

public class Questions {
    //array of questions
    public String MyQuestions [] =  {
            "What is the universe made of?"
            "When did life begin?"
            "Are we alone in the universe?"
            "What makes us human?"
            "What is consciousness?"
    };
    //array of multiple choices for each question
    public String MyChoices [] [] = {
            {"Dark matter","Oxygen","Nitrogen","Stars"},
            {"4 billion years ago","1 million years ago","250 million years ago","200 000 years ago"},
            {"Yes","No","Maybe","I don't know"},
            {"Our ability to communicate","Our brains","Our cooperation and trade skills","I don't know"},
            {"A part of the brain","The state of being conscious.","Mental responsiveness and awareness","I don't know"}
    };
    // array of correct answers - in the same order as array of questions
    private String MyCorrectAnswers [] = {
            "Dark matter","4 bilion years ago","I don't know","Our cooperation and trade skills","The state of being conscious."
    };
    //method returns number of questions
    public int getLength() {
        return MyQuestions.length;
    }
    // method returns questions from array textQuestions[] based on array index
    public String getQuestions(int a){
        String question = MyQuestions[a];
        return question;
    }
    // method returns a single multiple choice item for question based on array index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4 as an argument
    public String getChoice(int index, int num) {
        String choice0 = MyChoices[index][num - 1];
        return choice0;
    }
    // method returns correct answer for the question based on array index
    public String getCorrectAnswer(int a){
        String answer = MyCorrectAnswers[a];
        return answer;
    }
}
