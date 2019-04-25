$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/skeleton/casestudy1.feature");
formatter.feature({
  "name": "TestMe App Feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login Scenario",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "The URL of Testme APP",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefs.the_URL_of_Testme_APP()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters \u003cusername\u003e as username",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefs.user_enters_as_username(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters \u003cpassword\u003e as password",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefs.user_enters_as_password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is in home page",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "status": "passed"
});
});