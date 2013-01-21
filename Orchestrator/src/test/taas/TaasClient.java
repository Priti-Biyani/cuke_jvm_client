package test.taas;

import org.jsoup.Jsoup;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: priti
 * Date: 17/01/13
 * Time: 6:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaasClient {

    URL url;
    HttpURLConnection connection;
    String json_output,output;
    HashMap retMap;

    public void TaasClient()
    {
          System.out.println("IN CONSTRUCT");
    }


    public void initialize_client(String req_url)
    {
        try
        {
            System.out.println("URL :"+this.url);
            this.url = new URL(req_url);
        }
        catch(Exception ex)
        {
            ex.getStackTrace();
        }
    }

    public HashMap make_request(String params)
    {
        try
        {
            connection =(HttpURLConnection)url.openConnection();

            if(connection!=null)
            {
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setInstanceFollowRedirects(false);
                connection.setRequestMethod("POST");
                connection.setUseCaches(false);
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("charset", "utf-8");
                connection.setRequestProperty("Content-Length", "" + Integer.toString(params.getBytes("UTF-8").length));

                DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());
                wr.writeBytes(params);
                wr.flush();
                wr.close();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            ex.getMessage();
        }
        return retMap=parse_output();
    }



    public static TaasClient create_client(String URL)
    {
        TaasClient client=new TaasClient();
        client.initialize_client(URL+"/contract");
        return client;
    }
    public HashMap parse_output()
    {
        try
        {
            StringBuffer resp =new StringBuffer();
            InputStream is = new DataInputStream(connection.getInputStream());
            BufferedReader br =new BufferedReader(new InputStreamReader(is));
            System.out.print("RESPONSE : \n \n");
            String line;
            while((line=br.readLine())!=null)
            {
                resp.append(line);
                resp.append("\r");
            }
            br.close();

            this.json_output= Jsoup.parse(resp.toString()).select("TaaS-Json").first().text();
            this.output = Jsoup.parse(resp.toString()).select("TaaS-Output").first().text();
            System.out.println("JSON OUTPUT : "+json_output+"\n");
            System.out.println("     OUTPUT : "+output);

            convertToMap(json_output);
            System.out.println("HASH MAP :"+this.retMap);
//            Object v;
            String key="\"order_id\"";
            boolean has=retMap.containsKey(key);
            System.out.println(has);
            Integer v = (Integer)retMap.get(key);
            System.out.println("order_id  :"+v);

            Set keys = retMap.keySet();
            System.out.println(keys);
            for (Iterator i = keys.iterator(); i.hasNext();)
            {
                String k = (String) i.next();
                Integer value = (Integer) retMap.get(k);
                System.out.println(k + " = " + value);
            }

        }
        catch(Exception ex)
        {
            ex.getStackTrace();
            ex.getMessage();
        }
        finally
        {
            if(connection!=null)
                connection.disconnect();
        }
        return retMap;

    }


    private void convertToMap(String jsonString)
    {
        this.retMap = new HashMap<String, String>();
        String splitFirstValue =  jsonString.substring(1,jsonString.indexOf(":"));
        String splitSeconSValue = jsonString.substring(jsonString.indexOf(":") + 1 ,jsonString.length()-1);
        System.out.println("FIRST  :"+splitFirstValue);
        System.out.println("LAST   :"+splitSeconSValue);
        retMap.put(splitFirstValue.toString(), Integer.parseInt(splitSeconSValue));

    }


}
