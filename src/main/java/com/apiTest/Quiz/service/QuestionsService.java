package com.apiTest.Quiz.service;

import com.apiTest.Quiz.model.Answer;
import com.apiTest.Quiz.model.Question;
import com.apiTest.Quiz.repository.AnswersRepository;
import com.apiTest.Quiz.repository.QuestionRepository;
import com.apiTest.util.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswersRepository answersRepository;

    @Autowired
    AmazonClient amazonClient;

    private void deleteAssociatedAnswers(Long questionId) {
        List<Answer> answers = answersRepository.findByQuestionId(questionId);
        answers.stream().forEach((answer) -> {
            if(answersRepository.existsById(answer.getId())){
                answersRepository.delete(answer);
            } else {
                return;
            }
        });
    }

    public void deleteQuestionsAndAnswers(List<Question> questions) {
        questions.stream().forEach((question) -> {
            if(question.getImgUrl() != null){
                amazonClient.deleteFileFromS3(question.getImgUrl());
            }
            deleteAssociatedAnswers(question.getId());
            questionRepository.delete(question);
        });
    }

}
