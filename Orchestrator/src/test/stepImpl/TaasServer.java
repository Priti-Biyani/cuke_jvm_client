package test.stepImpl;

/**
 * Created with IntelliJ IDEA.
 * User: priti
 * Date: 22/01/13
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class TaasServer {
    public static final String RORSERVER="http://10.12.7.14:4567/contract";
    public static final String PLAYSERVER="http://10.12.6.142:4567/contract";

    public static final String RORorder="contract_name=place_order&name=priti&address=add&quantity=2";
    public static final String RORVerify="contract_name=verify_order&order_id=";
    public static final String PLAYDeliver="contract_name=deliver_order&order_id=";
}
