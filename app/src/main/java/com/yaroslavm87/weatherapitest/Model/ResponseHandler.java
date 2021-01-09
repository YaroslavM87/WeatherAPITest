package com.yaroslavm87.weatherapitest.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResponseHandler {

    private  BufferedReader bufferedReader;
    private  String resultLine;

    public ResponseHandler() {
        this.bufferedReader = null;
    }

    public void handleResponse(InputStream inputStream) throws IOException {

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();

            String intermediateLine;

            while ((intermediateLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(intermediateLine).append("\n");
            }

            setResultLine(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public void setResultLine(String resultLine) {
        this.resultLine = resultLine;
    }

    public String getResultLine() {
        return resultLine;
    }

    //            inputStreamReader = new InputStreamReader(inputStream);
//            bufferedReader = new BufferedReader(inputStreamReader);
//            stringBuilder = new StringBuilder();
//
//            while ((intermediateLine = bufferedReader.readLine()) != null) {
//                stringBuilder.append(intermediateLine).append("\n");
//            }
//
//            resultLine = stringBuilder.toString();
}
