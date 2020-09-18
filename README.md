# solve-captcha

1) we have two services

  Generate Questions with Random numbers by hiiting following URL
  
  Method: Get()
  
  http://localhost:8090/v1/captcha/challenge
  
  Sample output: 
  
   {
    "challengeId": 1,
    "challengeType": "What would be the result when add :1,1,7."
}
  
  2) Verify the Challenge by submitting correct answer
  
  http://localhost:8090/v1/captcha/challengeverify
  
  2.1 )Method: Post()
  
  Body:
  
  {"challenge":{"challengeId":1,"challengeType":"What would be the result when add :1,1,7."},"answer":"9"}
  
  Output:
  Very good at aruthmetic
  
  2.2) Negative Scenario
  
  {"challenge":{"challengeId":1,"challengeType":"What would be the result when add :1,1,7."},"answer":"10"}
  
  Output:
    Need to improve arithmetic
  
  
  
  
