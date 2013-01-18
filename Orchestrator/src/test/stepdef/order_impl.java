package test.stepdef;


import java.util.HashMap;
import test.taas.*;

/**
 * Created with IntelliJ IDEA.
 * User: priti
 * Date: 17/01/13
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class order_impl {

    public order_impl()
    {

        System.out.println("Impl");

    }



//    public int place_order(taas_client client)
//    {
//        HashMap output=client.parse_output();
//        String key="\"order_id\"";
//        Integer v=0;
//        if(output.containsKey(key))
//        {
//            v = (Integer)output.get(key);
//            System.out.println("order_id  :"+v);
//        }
//        return v;
//    }
//
//    public int verify_order(taas_client client)
//    {
//        int v=1;
//        return v;
//    }

}
