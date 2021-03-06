package com.apiTest.UnitTests;

import com.apiTest.Quiz.model.Answer;
import com.apiTest.Quiz.model.Question;
import com.apiTest.lookup.model.Lookup;
import com.apiTest.util.SortingUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class SortingUtilTest {

    @Autowired
    SortingUtil sortingUtil;

    private ArrayList<Question> questions = new ArrayList<>();
    private Question question = new Question((long) 1, 12, "Question number 12");
    private Question question2 = new Question((long) 1, 6, "Question number 6");
    private Question question3 = new Question((long) 1, 8, "Question number 8");
    private Question question4 = new Question((long) 1, 22, "Question number 22");
    private Question question5 = new Question((long) 1, 3, "Question number 3");
    private Question question6 = new Question((long) 1, 55, "Question number 55");
    private Question question7 = new Question((long) 1, 4, "Question number 4");
    private Question question8 = new Question((long) 1, 11, "Question number 11");
    private Question question9 = new Question((long) 1, 1, "Question number 1");
    private Question question10 = new Question((long) 1, 17, "Question number 17");

    private ArrayList<Answer> answers = new ArrayList<>();
    private Answer answer = new Answer((long) 1, "L", "Answer number 12", false);
    private Answer answer2 = new Answer((long) 1, "F", "Answer number 6", false);
    private Answer answer3 = new Answer((long) 1, "H", "Answer number 8", false);
    private Answer answer4 = new Answer((long) 1, "V", "Answer number 22", false);
    private Answer answer5 = new Answer((long) 1, "C", "Answer number 3", false);
    private Answer answer6 = new Answer((long) 1, "Z", "Answer number 55", true);
    private Answer answer7 = new Answer((long) 1, "D", "Answer number 4", false);
    private Answer answer8 = new Answer((long) 1, "K", "Answer number 11", false);
    private Answer answer9 = new Answer((long) 1, "A", "Answer number 1", false);
    private Answer answer10 = new Answer((long) 1, "Q", "Answer number 17", false);

    private ArrayList<Lookup> categories = new ArrayList<>();
    private Lookup cat1 = new Lookup("Geography", "Quiz Category");
    private Lookup cat2 = new Lookup("Music", "Quiz Category");
    private Lookup cat3 = new Lookup("Art", "Quiz Category");
    private Lookup cat4 = new Lookup("Technology", "Quiz Category");
    private Lookup cat5 = new Lookup("Films", "Quiz Category");


    @BeforeEach
    void createTestData(){
        questions.add(question);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);
        questions.add(question8);
        questions.add(question9);
        questions.add(question10);

        answers.add(answer);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        answers.add(answer5);
        answers.add(answer6);
        answers.add(answer7);
        answers.add(answer8);
        answers.add(answer9);
        answers.add(answer10);

        categories.add(cat1);
        categories.add(cat2);
        categories.add(cat3);
        categories.add(cat4);
        categories.add(cat5);
    }

    @Test
    void questionSelectSortTest(){
        sortingUtil.QuestionSelectSort(questions, questions.size());
        Assertions.assertEquals(questions.get(0), question9);
        Assertions.assertEquals(questions.get(1), question5);
        Assertions.assertEquals(questions.get(2), question7);
        Assertions.assertEquals(questions.get(3), question2);
        Assertions.assertEquals(questions.get(4), question3);
        Assertions.assertEquals(questions.get(5), question8);
        Assertions.assertEquals(questions.get(6), question);
        Assertions.assertEquals(questions.get(7), question10);
        Assertions.assertEquals(questions.get(8), question4);
        Assertions.assertEquals(questions.get(9), question6);
    }

    @Test
    void answerSelectSortTest(){
        sortingUtil.AnswerSelectSort(answers, answers.size());
        Assertions.assertEquals(answers.get(0), answer9);
        Assertions.assertEquals(answers.get(1), answer5);
        Assertions.assertEquals(answers.get(2), answer7);
        Assertions.assertEquals(answers.get(3), answer2);
        Assertions.assertEquals(answers.get(4), answer3);
        Assertions.assertEquals(answers.get(5), answer8);
        Assertions.assertEquals(answers.get(6), answer);
        Assertions.assertEquals(answers.get(7), answer10);
        Assertions.assertEquals(answers.get(8), answer4);
        Assertions.assertEquals(answers.get(9), answer6);
    }

    @Test
    void lookupSelectSortTest(){
        sortingUtil.LookupSelectSort(categories, categories.size());
        Assertions.assertEquals(categories.get(0), cat3);
        Assertions.assertEquals(categories.get(1), cat5);
        Assertions.assertEquals(categories.get(2), cat1);
        Assertions.assertEquals(categories.get(3), cat2);
        Assertions.assertEquals(categories.get(4), cat4);
    }

}
