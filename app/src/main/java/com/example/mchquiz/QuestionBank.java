package com.example.mchquiz;

// This class contains a list of questions
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    // declare list of Question objects
    List<Question> list = new ArrayList<>();
    MyDataBaseHelper myDataBaseHelper;

    // method returns number of questions in list
    public int getLength(){
        return list.size();
    }

    // method returns question from list based on list index
    public String getQuestion(int a) {
       return list.get(a).getQuestion();
    }

    // method return a single multiple choice item for question based on list index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4
    // as an argument
    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num-1);
    }

    //  method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }



    public void initQuestions(Context context) {
        myDataBaseHelper = new MyDataBaseHelper(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question("1. Q 1 ?",
                    new String[]{"A 1", "A 2", "A 3", "A 4"}, "A 4"));
            myDataBaseHelper.addInitialQuestion(new Question("2. Q 2",
                    new String[]{"A 1", "A 2", "A 3", "A 4"}, "A 2"));
            myDataBaseHelper.addInitialQuestion(new Question("3. Q 3",
                    new String[]{"A 1", "A 2", "A 3", "A 4"}, "A 2"));
            myDataBaseHelper.addInitialQuestion(new Question("4. Q 4",
                    new String[]{"A 1", "A 2", "A 3", "A 4"}, "A 1"));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }
    }

}