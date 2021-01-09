package com.yaroslavm87.weatherapitest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yaroslavm87.weatherapitest.Model.CurrentWeather;
import com.yaroslavm87.weatherapitest.Model.JsonParserToWeatherObjToCurrentWeather;
import com.yaroslavm87.weatherapitest.Model.RequestHandler;
import com.yaroslavm87.weatherapitest.Model.ResponseHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private Button sendRequestButton;
    private TextView placeNameEditTextView;
    private TextView jsonResultTextView;
    private TextView currentWeatherValue;
    private CurrentWeather currentWeather;
    private final String TAG = "MyLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ResponseHandler responseHandler = new ResponseHandler();
        final RequestHandler requestHandler = new RequestHandler(responseHandler);
        final StringBuilder stringBuilder = new StringBuilder(100);

        currentWeather = new CurrentWeather();
        sendRequestButton = findViewById(R.id.sendRequest);
        placeNameEditTextView = findViewById(R.id.editTextPlaceName);
        jsonResultTextView = findViewById(R.id.jsonResult);
        currentWeatherValue = findViewById(R.id.value);
        sendRequestButton.setOnClickListener( v -> {

            hideKeyboard();

            if(placeNameEditTextView.getText() != null) {

                jsonResultTextView.setText("Загрузка...");

                new Thread(() -> {

                    StringBuilder urlBuilder = new StringBuilder();
                    urlBuilder.append("https://api.openweathermap.org/data/2.5/weather?q=");
                    urlBuilder.append(placeNameEditTextView.getText().toString().trim());
                    urlBuilder.append("&units=metric&appid=dfdce01e52caf436e59067b1480eb6b0");

                    try {
                        requestHandler.sendRequest(urlBuilder.toString());
                        jsonResultTextView.post(() -> {
                            jsonResultTextView.setText(responseHandler.getResultLine());
                            parse(responseHandler.getResultLine());
                            show();
                        });

                    } catch (final IOException e) {
                        e.printStackTrace();
                        jsonResultTextView.post(() -> {
                            stringBuilder.append("Ошибка: ");
                            stringBuilder.append(e.getMessage());
                            jsonResultTextView.setText(stringBuilder.toString());
                            showToastNotification("Ошибка");
                        });
                    }
                }).start();

            } else {
                showToastNotification("Enter city name");
            }

        });
    }


    public void parse(String jsonToParse) {
        JsonParserToWeatherObjToCurrentWeather parser = new JsonParserToWeatherObjToCurrentWeather();
        try {
            parser.setInputJSON(jsonToParse);
            currentWeather = parser.parse(jsonToParse);

        } catch (Exception ex) {
            Log.i(TAG, ex.toString());
        }
    }

    public void show() {
        String result = currentWeather.toString();
        currentWeatherValue.setText(result);
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = this.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(this);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void showToastNotification(String notificationText) {
        Toast.makeText(getApplicationContext(), notificationText, Toast.LENGTH_SHORT).show();
    }

}