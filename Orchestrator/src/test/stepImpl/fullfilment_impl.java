package test.stepImpl;

import test.stepdef.stepBase;
import test.taas.TaasClient;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: priti
 * Date: 22/01/13
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class fullfilment_impl {
    TaasClient client;
    HashMap output;
    private static fullfilment_impl instance = null;


    protected fullfilment_impl()
    {
          client=new TaasClient();
    }

    public static fullfilment_impl getInstance() {
        System.out.println(instance);
        if(instance == null) {
            instance = new fullfilment_impl();
        }
        return instance;
    }

    public String   deliverOrder()
    {
        String order_id= stepBase.getvalue("\"order_id\"").toString();
        output=client.make_request(TaasServer.PLAYSERVER,TaasServer.PLAYDeliver+order_id);
        String key="\"RESPONSE\"";
        String resp=null;
        boolean has=output.containsKey(key);
        if(has)
            resp = (String)output.get(key);
        return resp;
    }


}
