package com.pandi.works.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pandi.works.model.Challenge;
import com.pandi.works.model.Solve;
import com.pandi.works.service.ChallengeService;

@RestController
@Validated
public class CaptchaController {

	@Autowired
	ChallengeService challengeService;

	@GetMapping("/v1/captcha/challenge")
	public Challenge getChallenge() {
		return challengeService.generateChallenge();
	}

	@PostMapping("/v1/captcha/challengeverify")
	public ResponseEntity<String> verifyChallenge(@Valid @RequestBody Solve solve) {
		return (challengeService.verifyChallenge(solve)) ? ResponseEntity.status(HttpStatus.OK).body("Thats Great")
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please try again");
	}

	// Sample request to verify
	// {"challenge":{"challengeId":2,"challengeType":"What would be the result when
	// add :1,1,7."},"answer":"24"}

}
