package tn.esprit.pfe.controller;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pfe.entities.EmailConfig;
import tn.esprit.pfe.entities.MailHistory;
import tn.esprit.pfe.entities.ResetPassword;
import tn.esprit.pfe.entities.Utilisateur;
import tn.esprit.pfe.payload.LoginRequest;
import tn.esprit.pfe.repository.MailHistoryRepository;
import tn.esprit.pfe.repository.UserRepository;
import tn.esprit.pfe.service.IUserService;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class ResetPasswordController {
	@Autowired
	EmailConfig emailCfg;
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordencoder;

	@Autowired
	MailHistoryRepository mailHistoryRepo;
	
	@Autowired
	IUserService us;

	
	
	@PostMapping("/forgot")
	public ResponseEntity<String> processForgotPasswordForm(@RequestBody LoginRequest loginrequest, HttpServletRequest request) {
		
		Utilisateur user = userRepository.findByUsername(loginrequest.getUsername());
		System.out.println("d5al lel findName"+user);
		user.setResetToken(UUID.randomUUID().toString());
		userRepository.save(user);
		String appUrl = request.getScheme() + "://" + request.getServerName();

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.emailCfg.getHost());
		mailSender.setPort(this.emailCfg.getPort());
		mailSender.setUsername(this.emailCfg.getUsername());
		mailSender.setPassword(this.emailCfg.getPassword());
		
		// Create an email instance
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("emna.korbi1@esprit.tn");
		mailMessage.setTo(user.getEmail());
		mailMessage.setSubject("Reset  Password dari");
		mailMessage.setText(
				"To reset your password, use this code \n" + user.getResetToken());
		System.out.println("mail created"+mailMessage);
		// Send mail
		mailSender.send(mailMessage);
		Date d = new Date(System.currentTimeMillis());
		MailHistory m = new MailHistory();
		m.setDistination(user.getEmail());
		m.setBody("To reset your password, use this code \n" + user.getResetToken());
		m.setSendDate(d);
		m.setType("resetPassword");
		mailHistoryRepo.save(m);
		System.out.println("mailsend"+m);
		return new ResponseEntity<String>(user.getResetToken(), HttpStatus.OK);
	}

	@PostMapping("/reset")
	public ResponseEntity<String>setNewPassword(@Valid @RequestBody ResetPassword resetpass) {

		Optional<Utilisateur> user = userRepository.findByResetToken(resetpass.getToken());

		Utilisateur resetUser = user.get();

		// Set new password
		resetUser.setPassword(passwordencoder.encode(resetpass.getPassword()));
		
		// Set the reset token to null so it cannot be used again
		resetUser.setResetToken(null);

		// Save user
		userRepository.save(resetUser);
		return new ResponseEntity<String>("password updated",HttpStatus.OK);
	}
}
