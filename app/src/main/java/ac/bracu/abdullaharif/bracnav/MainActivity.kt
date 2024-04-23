package ac.bracu.abdullaharif.bracnav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.spinnerSource)
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter.createFromResource(
            this,
            R.array.spinnerSource,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner.adapter = adapter
        }
        val spinner2: Spinner = findViewById(R.id.spinnerDestination)
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter.createFromResource(
            this,
            R.array.spinnerDestination,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner2.adapter = adapter
        }
        val locateToast = "This will pinpoint to your current location"
        // val navigateToast = "This will perform the navigation from source to destination on the map"
        val duration = Toast.LENGTH_LONG

        val btn = findViewById<Button>(R.id.btnNav)
        btn.setOnClickListener {
            // Toast.makeText(this, navigateToast, duration).show()
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        val btn2 = findViewById<Button>(R.id.rbYourLocation)
        btn2.setOnClickListener {
            Toast.makeText(this, locateToast, duration).show()
        }

    }
}