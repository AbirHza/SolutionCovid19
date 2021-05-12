package tn.esprit.pfe.service;

import java.util.List;


import tn.esprit.pfe.entities.Question;

public interface IQuestionService {
	Question addQuestion(Question q);
	Question updateQuestion(Question q, Long id);
	void deleteQuestion(Long id);
	List<Question> retrieveAllQuestion();
}
