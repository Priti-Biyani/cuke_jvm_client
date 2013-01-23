package test.stepImpl;


import java.util.HashMap;
import test.taas.*;
import static junit.framework.Assert.*;
import test.stepdef.stepBase;

/**
 * Created with IntelliJ IDEA.
 * User: priti
 * Date: 17/01/13
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class order_impl
{
    TaasClient client;
    HashMap output;
    private static order_impl instance = null;

    protected order_impl()
    {
        client=new TaasClient();
    }


    public static order_impl getInstance() {
        System.out.println(instance);
        if(instance == null) {
            instance = new order_impl();
        }
        return instance;
    }

    public int placeOrder()
    {
        output=client.make_request(TaasServer.RORSERVER,TaasServer.RORorder);
        String key="\"order_id\"";
        int order_id=-1;
        boolean has=output.containsKey(key);
        if(has)
            order_id = (Integer)output.get(key);
         assertFalse(order_id==-1);
        return order_id;
    }

    public void verify_order(int order_id)
    {
        output=client.make_request(TaasServer.RORSERVER,TaasServer.RORVerify+order_id);
        String key="\"RESPONSE\"";
        String resp=null;
        boolean has=output.containsKey(key);
        if(has)
            resp = (String)output.get(key);
        assertFalse(resp==null);
    }

}
