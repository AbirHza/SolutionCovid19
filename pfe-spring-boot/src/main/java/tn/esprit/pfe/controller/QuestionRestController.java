package tn.esprit.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pfe.entities.Question;
import tn.esprit.pfe.service.IQuestionService;

@RestController
public class QuestionRestController {
	@Autowired
	IQuestionService questionService;
	
	@GetMapping("/retrieve-all-questions")
	@ResponseBody
	public List<Question> getQuestions() {
		List<Question> list = questionService.retrieveAllQuestion();
		return list;
	}

	@PostMapping("/add-question")
	public Question addQuestion(@RequestBody Question q) {
		Question question = questionService.addQuestion(q);
		return question;
	}

	@PutMapping("/modify-question/{id}")
	@ResponseBody
	public Question modifyQuestion(@PathVariable(name="id") Long id, @RequestBody Question q) {
		return questionService.updateQuestion(q, id);
	}

	@DeleteMapping(value="/listQuestion/{id}")
	public void delete(@PathVariable(name="id") Long id){
		questionService.deleteQuestion(id);
	}
}
