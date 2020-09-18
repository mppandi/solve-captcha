package com.pandi.works.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pandi.works.model.Challenge;
import com.pandi.works.model.Solve;
import com.pandi.works.service.ChallengeService;

@RestController
public class CaptchaController {
	
	@Autowired
	ChallengeService challengeService;
	
	
	@GetMapping("/v1/captcha/challenge")
	public Challenge getChallenge() {
		
		
		return challengeService.generateChallenge();
		
	}
	
	@PostMapping("/v1/captcha/challengeverify")
	public String verifyChallenge(@Valid @RequestBody Solve solve)
	{
		return challengeService.verifyChallenge(solve);
	}
	
	// Sample request to verify
	// {"challenge":{"challengeId":2,"challengeType":"test"},"answer":24}

}
