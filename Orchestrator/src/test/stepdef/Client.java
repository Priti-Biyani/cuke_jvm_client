package test.stepdef;

import org.jsoup.Jsoup;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Client
{

    URL url;
    HttpURLConnection connection;
    String json_output,output;
    HashMap retMap;

    public  Client()
    {
      System.out.println("CONSTRUCT");
    }


    public HashMap make_request(String request,String params)
    {
        System.out.println(request);
        System.out.println(params);
        try
        {
            this.url=new URL(request);
            System.out.println(url);
            connection =(HttpURLConnection)url.openConnection();

            if(connection!=null)
            {
                System.out.println("CONNECTION NOT NULL");
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
                System.out.println("REQUEST DONE    ");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            ex.getMessage();
        }
        retMap=parse_output();
        return retMap;
    }

    private HashMap parse_output()
    {
        try
        {
            System.out.println("PARSE OUTPUT");

            System.out.println("URL :"+this.connection);


            if(this.connection!=null)
            {
                System.out.print("CONN NOT NULL");
            }

            StringBuffer resp =new StringBuffer();
            InputStream is = new DataInputStream(connection.getInputStream());
            BufferedReader br =new BufferedReader(new InputStreamReader(is));
            System.out.println("BEFORE RESP");
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
//            String key="\"order_id\"";
//            boolean has=retMap.containsKey(key);
//            System.out.println(has);
//            Integer v = (Integer)retMap.get(key);
//            System.out.println("order_id  :"+v);

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


    public static void main(String arg[])
    {
        String request="http://10.12.7.14:4567/contract";
        String param="contract_name=place_order&name=priti&address=add&quantity=2";
        Client client1=new Client();
        HashMap output =client1.make_request(request,param);
        System.out.println(output);
    }
}