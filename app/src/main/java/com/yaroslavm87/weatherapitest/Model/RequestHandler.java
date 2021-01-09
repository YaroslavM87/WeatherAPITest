package com.yaroslavm87.weatherapitest.Model;

import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class RequestHandler {

    private HttpsURLConnection connection;
    private ResponseHandler responseHandler;

    public RequestHandler(ResponseHandler responseHandler) {
        this.connection = null;
        this.responseHandler = responseHandler;
    }

    public void sendRequest(String urlPathAsString) throws IOException {

       // try {
            URL url = new URL(urlPathAsString);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            responseHandler.handleResponse(connection.getInputStream());

//            inputStream = connection.getInputStream();
//            inputStreamReader = new InputStreamReader(inputStream);
//            bufferedReader = new BufferedReader(inputStreamReader);
//            stringBuilder = new StringBuilder();
//
//            while ((intermediateLine = bufferedReader.readLine()) != null) {
//                stringBuilder.append(intermediateLine).append("\n");
//            }
//
//            resultLine = stringBuilder.toString();
//            return resultLine;
//        }
//
//        finally {
//            if (bufferedReader != null) {
//                bufferedReader.close();
//            }
//            if (inputStream != null) {
//                inputStream.close();
//            }
            if (connection != null) {
                connection.disconnect();
            }
//        }
    }
}