package com.pandi.works.model;

import javax.validation.constraints.NotNull;

public class Solve {
	
	@NotNull
	private Challenge challenge;
	
	@NotNull
	private int answer;
	
	public Challenge getChallenge() {
		return challenge;
	}
	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}

}
