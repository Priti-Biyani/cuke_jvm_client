package test.stepdef;

import cucumber.api.java.en.When;
import test.stepImpl.fullfilment_impl;
import test.taas.TaasClient;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: priti
 * Date: 22/01/13
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class fullfilmentStepDefn {
    fullfilment_impl impl;
    @When("^order is fulfilled$")
    public void I_change_the_status_from_play()
    {
      impl=fullfilment_impl.getInstance();
      impl.deliverOrder();
    }

}
