$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/AddRemoveElements.feature");
formatter.feature({
  "name": "AddRemoveElements",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@AddRemoveElements"
    }
  ]
});
formatter.scenario({
  "name": "Add remove elements http://the-internet.herokuapp.com/add_remove_elements/",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@AddRemoveElements"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Add Remove elements page",
  "keyword": "Given "
});
formatter.match({
  "location": "AddRemoveElements.add_Remove_elements_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Add element btn",
  "keyword": "When "
});
formatter.match({
  "location": "AddRemoveElements.i_click_on_Add_element_btn()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c10\u003e but was:\u003c11\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat bindings.AddRemoveElements.i_click_on_Add_element_btn(AddRemoveElements.java:51)\r\n\tat ✽.I click on Add element btn(file:src/test/java/features/AddRemoveElements.feature:6)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Element should be added and Delete btn should be seen",
  "keyword": "Then "
});
formatter.match({
  "location": "AddRemoveElements.element_should_be_added_and_Delete_btn_should_be_seen()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click Delete btn 10 times",
  "keyword": "When "
});
formatter.match({
  "location": "AddRemoveElements.i_click_Delete_btn()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Btns should be removed",
  "keyword": "Then "
});
formatter.match({
  "location": "AddRemoveElements.btn_should_be_removed()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/java/features/CheckBoxes.feature");
formatter.feature({
  "name": "CheckBoxes",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "CheckBoxes",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "The checkboxes page",
  "keyword": "Given "
});
formatter.match({
  "location": "Checkboxes.go_to_checkbox_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click checkbox1",
  "keyword": "When "
});
formatter.match({
  "location": "Checkboxes.and_click_checkbox1()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "it should be selected",
  "keyword": "Then "
});
formatter.match({
  "location": "Checkboxes.it_should_be_selected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click checkbox2",
  "keyword": "When "
});
formatter.match({
  "location": "Checkboxes.i_click_checkbox_2()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "It should be deselected",
  "keyword": "Then "
});
formatter.match({
  "location": "Checkboxes.it_should_be_deselected()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/java/features/FormAuthentication.feature");
formatter.feature({
  "name": "Form Authentication",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": ": Login form using valid and invalid credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "That I go to form authentication",
  "keyword": "Given "
});
formatter.step({
  "name": "I enter username \"\u003cusername\u003e\" and \"\u003cpassword\u003e\" and press Submit",
  "keyword": "When "
});
formatter.step({
  "name": "I should get correct \"\u003cstatus\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "status"
      ]
    },
    {
      "cells": [
        "wrongUsername",
        "wrongPassword",
        "false"
      ]
    },
    {
      "cells": [
        "tomsmith",
        "SuperSecretPassword!",
        "true"
      ]
    }
  ]
});
formatter.scenario({
  "name": ": Login form using valid and invalid credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "That I go to form authentication",
  "keyword": "Given "
});
formatter.match({
  "location": "FormAuthentication.go_to_auth_form()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter username \"wrongUsername\" and \"wrongPassword\" and press Submit",
  "keyword": "When "
});
formatter.match({
  "location": "FormAuthentication.enter_invalid_username_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get correct \"false\"",
  "keyword": "Then "
});
formatter.match({
  "location": "FormAuthentication.check_if_user_not_logged_in(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": ": Login form using valid and invalid credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "That I go to form authentication",
  "keyword": "Given "
});
formatter.match({
  "location": "FormAuthentication.go_to_auth_form()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter username \"tomsmith\" and \"SuperSecretPassword!\" and press Submit",
  "keyword": "When "
});
formatter.match({
  "location": "FormAuthentication.enter_invalid_username_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get correct \"true\"",
  "keyword": "Then "
});
formatter.match({
  "location": "FormAuthentication.check_if_user_not_logged_in(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});