package com.pandi.works.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.pandi.works.model.Challenge;
import com.pandi.works.model.Solve;

@Service
public class ChallengeService {

	public static final AtomicLong CHALLENGE_ID_GENERATOR = new AtomicLong();
	public static final Random RANDOM_VALUE_1_10 = new Random(10);
	public static final Map<Long, Integer> CHALLENGE_VERIFY_MAP = new HashMap<>();

	public Challenge generateChallenge() {
		Challenge challenge = new Challenge();
		challenge.setChallengeId(CHALLENGE_ID_GENERATOR.incrementAndGet());
		challenge.setChallengeType(generateQuestionWithDynamicNumbers(challenge.getChallengeId(), 3));
		return challenge;

	}
	/**
	 *  below method used to validate submitted question
	 * @param solve
	 * @return
	 */

	public String verifyChallenge(Solve solve) {

		Challenge challenge = solve.getChallenge();
		if (CHALLENGE_VERIFY_MAP.containsKey(challenge.getChallengeId())) {

			if(solve.getAnswer() == CHALLENGE_VERIFY_MAP.get(challenge.getChallengeId())) {
				return "Very good at aruthmetic";
			} else {
				return "Need to improve arithmetic";
			}

		}

		return "Invalid Challenge";

	}
	
	/**
	 * Method used to generate dynamic questions
	 * @param challengeId
	 * @param noOfTimes
	 * @return
	 */

	private static String generateQuestionWithDynamicNumbers(long challengeId, int noOfTimes) {

		StringJoiner sJoin = new StringJoiner(",", "What would be the result when add :", ".");

		int sum = 0;

		for (int i = 1; i <= noOfTimes; i++) {
			
			int n1 = RANDOM_VALUE_1_10.nextInt(10) + 1;
			sJoin.add("" + n1);
			sum += n1;

		}

		CHALLENGE_VERIFY_MAP.put(challengeId, sum);

		return sJoin.toString();

	}
	
	

}
