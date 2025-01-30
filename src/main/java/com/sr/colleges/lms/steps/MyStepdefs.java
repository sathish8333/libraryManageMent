package com.sr.colleges.lms.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class MyStepdefs {

    @Given("a policy number {int}")
    public void aPolicyNumber(int arg0) {
        System.out.println("in given step "+arg0);
    }

    @When("the consumer requests policy preferences with policy number {int}")
    public void theConsumerRequestsPolicyPreferencesWithPolicyNumber(int arg0) {
        System.out.println("in when step ::"+arg0);
    }

    @Then("the response contains the delivery preference")
    public void theResponseContainsTheDeliveryPreference() {
        System.out.println("in then step");
    }

    @And("list of packetIds is returned:")
    public void listOfPacketIdsIsReturned(List<String> paktIds) {
        System.out.println("in And step"+paktIds);
    }
}
