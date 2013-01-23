package test.stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import test.stepImpl.order_impl;

/**
 * Created with IntelliJ IDEA.
 * User: priti
 * Date: 17/01/13
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class orderStepDefn {

    order_impl OrderImpl;
    int order_id;

    @Given("^I visit the order merchant site and I place the order$")
    public void I_visit_the_order_merchant_site_and_I_place_the_order()
    {
      OrderImpl=order_impl.getInstance();
      order_id=OrderImpl.placeOrder();
    }


    @Then("^I see the delivered status at Merchant site$")
    public void order_status_is_changed_at_merchant_site()
    {
      OrderImpl=order_impl.getInstance();
      OrderImpl.verify_order(order_id);
    }
}
