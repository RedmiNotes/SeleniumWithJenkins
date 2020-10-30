$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./FeatureFile/Textbox.feature");
formatter.feature({
  "line": 1,
  "name": "Textbox_Page",
  "description": "",
  "id": "textbox-page",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4675727734,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Text_Box_Page",
  "description": "",
  "id": "textbox-page;text-box-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "login to teaf leaf website",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "navigate to edit page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "enter the firstname",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "enter the lastname",
  "keyword": "And "
});
formatter.match({
  "location": "TC_01_EditTextbox.login_to_teaf_leaf_website()"
});
formatter.result({
  "duration": 8433288580,
  "status": "passed"
});
formatter.match({
  "location": "TC_01_EditTextbox.navigate_to_edit_page()"
});
formatter.result({
  "duration": 6156405934,
  "status": "passed"
});
formatter.match({
  "location": "TC_01_EditTextbox.enter_the_firstname()"
});
formatter.result({
  "duration": 3496943566,
  "status": "passed"
});
formatter.match({
  "location": "TC_01_EditTextbox.enter_the_lastname()"
});
formatter.result({
  "duration": 5608846567,
  "status": "passed"
});
formatter.after({
  "duration": 1320057962,
  "status": "passed"
});
});