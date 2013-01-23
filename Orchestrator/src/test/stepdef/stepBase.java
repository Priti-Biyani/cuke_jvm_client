package test.stepdef;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: priti
 * Date: 22/01/13
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
public  class stepBase {
    private static HashMap data;

    stepBase()
    {

    }

    public static void insertData(String key,Object value)
    {
        data.put(key,value);
    }

    public static Object getvalue(String key)
    {
        return data.get(key);
    }
}
