package test.stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: priti
 * Date: 17/01/13
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class orderStepDefn {

    int order_id;
    order_impl o;
    @Given("^I visit the order merchant site and I place the order$")
    public void I_visit_the_order_merchant_site_and_I_place_the_order()
    {

        String request="http://10.12.7.14:4567/contract";
        String param="contract_name=place_order&name=priti&address=add&quantity=2";
        Client client1=new Client();
        HashMap output =client1.make_request(request,param);

        String key="\"order_id\"";
        boolean has=output.containsKey(key);
        order_id = (Integer)output.get(key);
//        System.out.println("order_id  :"+order_id);

    }

    @When("^I change the status from play$")
    public void I_change_the_status_from_play()  {
        String request="http://10.12.6.100:4567/contract";
        String param="contract_name=deliver_order&order_id="+order_id;

        Client client1=new Client();
        HashMap output =client1.make_request(request,param);

        String key="\"RESPONSE\"";
        boolean has=output.containsKey(key);
        String resp=(String)output.get(key);
        System.out.println("RESPONSE  :"+resp);


    }

    @Then("^order status is changed at merchant site$")
    public void order_status_is_changed_at_merchant_site()  {
        String request="http://10.12.6.100:4567/contract";
        String param="contract_name=verify_order&order_id="+order_id;

        Client client1=new Client();
        HashMap output =client1.make_request(request,param);

        String key="\"RESPONSE\"";
        boolean has=output.containsKey(key);
        if(has)
        {
            String resp=(String)output.get(key);
            System.out.println("RESPONSE  :"+resp);
        }
    }
}
