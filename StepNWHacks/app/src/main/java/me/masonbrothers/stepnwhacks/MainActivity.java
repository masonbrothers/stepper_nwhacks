package me.masonbrothers.stepnwhacks;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor step_detector;
    TextView detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detector = (TextView)findViewById(R.id.Detector);



        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if ((step_detector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)) == null) {
            detector.setText("Not Supported");
        } else {
            sensorManager.registerListener(this, step_detector, SensorManager.SENSOR_DELAY_GAME);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        detector.setText(String.valueOf(event.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
