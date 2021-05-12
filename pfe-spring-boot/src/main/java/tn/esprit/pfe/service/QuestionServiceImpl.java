package tn.esprit.pfe.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pfe.entities.Question;
import tn.esprit.pfe.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements IQuestionService {

	public static final Logger l= LogManager.getLogger(UserServiceImpl.class);
	@Autowired
	QuestionRepository questionRepository;
	@Override
	public Question addQuestion(Question q) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(q);
	}

	@Override
	public Question updateQuestion(Question q, Long id) {
		// TODO Auto-generated method stub
		q.setId(id);
		return this.questionRepository.save(q);	
	}

	@Override
	public void deleteQuestion(Long id) {
		// TODO Auto-generated method stub
		this.questionRepository.deleteById(id);
	}

	@Override
	public List<Question> retrieveAllQuestion() {
		// TODO Auto-generated method stub
		List<Question> questions = (List<Question>)questionRepository.findAll(); 
		for  (Question question : questions) {
			l.info("question +++ : "+question);		
		}
		return questions;
	}

}
