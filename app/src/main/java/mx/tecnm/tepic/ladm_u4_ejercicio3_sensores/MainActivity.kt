package mx.tecnm.tepic.ladm_u4_ejercicio3_sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {

    lateinit var sensorManager : SensorManager //lateinit = no se asigna memoria, ni null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent) {
        //event.values[0] //x=0, y=1, z=2
        textView.setText("COORDENADAS: \nX: ${event.values[0]}"+
        "\nY: ${event.values[1]} \nZ: ${event.values[2]}")
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}