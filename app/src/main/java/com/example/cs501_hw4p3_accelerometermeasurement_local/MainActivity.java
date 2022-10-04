package com.example.cs501_hw4p3_accelerometermeasurement_local;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView text_Bar;

    private SensorManager sensorManager;
    private Sensor sensor1, sensor2;

    private SeekBar seekbar_One;

    private WebView webView_One;
    private float changedValue;
    private float lastX;
    private float lastY;
    private float lastZ;
    private float geoX;
    private float geoY;
    private float geoZ;

    private float seek1;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_Bar = (TextView) findViewById(R.id.text_Bar);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        /*sensor_Acceler = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor_Gravity= sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);*/
        seekbar_One = (SeekBar) findViewById(R.id.seekbar_One);

        webView_One = (WebView) findViewById(R.id.webView_One);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        seek1 = seekbar_One.getProgress();

        if(sensorEvent.sensor.getType()  == Sensor.TYPE_ACCELEROMETER) {
            lastX = sensorEvent.values[0];
            lastY = sensorEvent.values[1];
            lastZ = sensorEvent.values[2];
        }else if(sensorEvent.sensor.getType()  == Sensor.TYPE_GRAVITY) {
            geoX = sensorEvent.values[0];
            geoY = sensorEvent.values[1];
            geoZ = sensorEvent.values[2];
        }
        text_Bar.setText(lastX+ "/n" + lastY + "/n" + lastZ);
        if(Math.abs(Math.abs(lastX)-Math.abs(geoX)) > Math.abs(Math.abs(lastY)-Math.abs(geoY)) &
                Math.abs(Math.abs(lastX)-Math.abs(geoX)) > Math.abs(Math.abs(lastZ)-Math.abs(geoZ))){
            if (Math.abs(Math.abs(lastX)-Math.abs(geoX)) > (seek1+2)){
                webView_One.loadUrl("https://www.ecosia.org/");

            }else if(Math.abs(Math.abs(lastX)-Math.abs(geoX)) > 11){
                webView_One.loadUrl("https://jumpingjaxfitness.files.wordpress.com/2010/07/dizziness.jpg");
            }

        }else if(Math.abs(Math.abs(lastY)-Math.abs(geoY)) > Math.abs(Math.abs(lastZ)-Math.abs(geoZ)) &
                Math.abs(Math.abs(lastY)-Math.abs(geoY)) > Math.abs(Math.abs(lastX)-Math.abs(geoX))){
            if (Math.abs(Math.abs(lastY)-Math.abs(geoY))> (seek1+12)){
                webView_One.loadUrl("https://www.dogpile.com/");
            }else if(Math.abs(Math.abs(lastX)-Math.abs(geoX)) > 20){
                webView_One.loadUrl("https://jumpingjaxfitness.files.wordpress.com/2010/07/dizziness.jpg");
            }
        }else if(Math.abs(Math.abs(lastZ)-Math.abs(geoZ)) > Math.abs(Math.abs(lastX)-Math.abs(geoX)) &
                Math.abs(Math.abs(lastZ)-Math.abs(geoZ)) > Math.abs(Math.abs(lastY)-Math.abs(geoY))){

            if (Math.abs(Math.abs(lastZ)-Math.abs(geoZ)) > (seek1+2)){
                webView_One.loadUrl("https://webb.nasa.gov/");
            }else if(Math.abs(Math.abs(lastX)-Math.abs(geoX)) > 11){
                webView_One.loadUrl("https://jumpingjaxfitness.files.wordpress.com/2010/07/dizziness.jpg");
            }
        }
        /*text_Bar.setText(Float.toString(lastX) + ";" +
                Float.toString(lastY) + ";" +
                Float.toString(lastZ) + ";" +Float.toString(geoX) + ";" +
                Float.toString(geoY) + ";" +
                Float.toString(geoZ) + ";" +
                "\n");*/
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ALL),sensorManager.SENSOR_DELAY_NORMAL);
        /*sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY),sensorManager.SENSOR_DELAY_NORMAL);*/
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}