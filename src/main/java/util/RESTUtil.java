package util;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.util.Iterator;
import java.util.Map;



/**
 * This class uses Gson library for converting JSON to POJO and POJO to JSON.
 * @author Lalji Gajera
 * @version 1.0
 * Generate your POJO classes first with support of Gson from http://www.jsonschema2pojo.org/ using your json string
 *
 */
public class RESTUtil {
    private JsonObject jsonObject;

    private String jsonRequest;
    private String jsonResponse;
    
    private static final int READ_TIME_OUT=300000;
    private static final int CONN_TIME_OUT=300000;


    public RESTUtil() {
        super();
    }


    /** Method for your REST service call , this method is using PUT request.
     * @param <T>
     * @param endPointURL : url as string for your REST call
     * @param requestClass : pass your object of request class which will go in rest request as PUT method
     * @param responseClass : pass your class type u want in response:  for Ex: AddressResponse.Class
     * @return your desired object of class which u specified in responseClass param
     * @throws Exception
     */
    public <T> T sendPutRestRequest(java.lang.String endPointURL,
                                 Object requestClass,
                                 Class<T> responseClass) throws Exception {

        Gson gson = new Gson();

        //store request
        jsonRequest = gson.toJson(requestClass);

        URL url = new URL(endPointURL);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(CONN_TIME_OUT);
        conn.setReadTimeout(READ_TIME_OUT);
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        OutputStreamWriter out =
            new OutputStreamWriter(conn.getOutputStream());
        out.write(gson.toJson(requestClass));
        out.close();

        JsonReader reader =
            new JsonReader(new InputStreamReader(conn.getInputStream()));
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(reader);
        jsonObject = rootElement.getAsJsonObject();
        if (responseClass == null)
            return null;
        return gson.fromJson(jsonObject, responseClass);

    }


  


    /** All In One Method for your REST service call , this method is using GET request.
     * @param <T>
     * @param endPointURL : url as string for your REST call with having url params
     * @param params : parameter map to append with URL fill with data u need to pass
     * @param responseClass : pass your class type u want in response:  for Ex: AddressResponse.Class
     * @return your desired object of class which u specified in responseClass param
     * @throws Exception
     */
    public <T> T sendGetRestRequest(java.lang.String endPointURL,
                                    Map<String, String> params,
                                    Class<T> responseClass) throws Exception {

        Gson gson = new Gson();

        endPointURL += setGETParams(params);
        //store request
        jsonRequest = endPointURL;
        URL url = new URL(endPointURL);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(CONN_TIME_OUT);
        conn.setReadTimeout(READ_TIME_OUT);
        conn.setRequestMethod("GET");
        JsonReader reader =
            new JsonReader(new InputStreamReader(conn.getInputStream()));
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(reader);
        if (rootElement.isJsonNull()) {
            return null;
        }
        jsonObject = rootElement.getAsJsonObject();
        if (responseClass == null) {
            return null;
        }
        return gson.fromJson(jsonObject, responseClass);

    }

    /** All In One Method for your REST service call , this method is using GET request.
     * @param <T>
     * @param endPointURL : url as string for your REST call with having url params
     * @param params : parameter map to append with URL fill with data u need to pass key value pair you want to append to you URL
     * @param responseClass : pass your class type u want in response:  for Ex: AddressResponse.Class
     * @return your desired object of class which u specified in responseClass param
     * @throws Exception
     */
    public <T> T sendGetRestJArrayRequest(java.lang.String endPointURL,
                                    Map<String, String> params,
                                    Type responseClass) throws Exception {

        Gson gson = new Gson();

        endPointURL += setGETParams(params);
        //store request
        jsonRequest = endPointURL;
        URL url = new URL(endPointURL);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(CONN_TIME_OUT);
        conn.setReadTimeout(READ_TIME_OUT);
        conn.setRequestMethod("GET");
        JsonReader reader =
            new JsonReader(new InputStreamReader(conn.getInputStream()));
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(reader);
        if (rootElement.isJsonNull()) {
            return null;
        }
      JsonArray  jarray = rootElement.getAsJsonArray();
        if (responseClass == null) {
            return null;
        }
        return gson.fromJson(jarray, responseClass);

    }

    /** All In One Method for your REST service call , this method is using POST request.
     * @param <T>
     * @param endPointURL : url as string for your REST call
     * @param requestClass : pass your object of request class which will go in rest request as PUT method
     * @param responseClass : pass your class type u want in response:  for Ex: AddressResponse.Class
     * @return your desired object of class which u specified in responseClass param
     * @throws Exception
     */
    public <T> T sendPostRestRequest(java.lang.String endPointURL,
                                     Object requestClass,
                                     Class<T> responseClass) throws Exception {

        Gson gson = new Gson();
        //store request
        jsonRequest = gson.toJson(requestClass);
        URL url = new URL(endPointURL);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(CONN_TIME_OUT);
        conn.setReadTimeout(READ_TIME_OUT);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        OutputStream out = (conn.getOutputStream());
        out.write(gson.toJson(requestClass).getBytes());
        out.close();

        JsonReader reader =
            new JsonReader(new InputStreamReader(conn.getInputStream()));
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(reader);
        jsonObject = rootElement.getAsJsonObject();
        if (responseClass == null)
            return null;
        return gson.fromJson(jsonObject, responseClass);

    }


    public JsonObject getJsonObject() {
        return jsonObject;
    }

    private String setGETParams(Map<String, String> params) {
        StringBuilder bodyBuilder = new StringBuilder();

        if (params == null || params.isEmpty())
            return "";
        Iterator<Map.Entry<String, String>> iterator =
            params.entrySet().iterator();
        // constructs the POST body using the parameters
        if (iterator.hasNext())
            bodyBuilder.append('?');
        while (iterator.hasNext()) {
            Map.Entry<String, String> param = iterator.next();
            try {
                bodyBuilder.append(param.getKey()).append('=').append(URLEncoder.encode(param.getValue(),
                                                                                        "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (iterator.hasNext()) {
                bodyBuilder.append('&');
            }
        }

        String finalURL = bodyBuilder.toString();

        return finalURL;

    }


    public String getJsonRequest() {
        return jsonRequest;
    }


    public String getJsonResponse() {
        if (jsonObject != null)
            return jsonObject.toString();
        return "";
    }

//only for payment
    public void setJsonRequest(String jsonRequest) {
        this.jsonRequest = jsonRequest;
    }
}
