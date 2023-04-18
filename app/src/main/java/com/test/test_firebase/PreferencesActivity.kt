package com.test.test_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch

class PreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener{
            val swdarkMode = findViewById<Switch>(R.id.swTheme)
            val timezone = findViewById<EditText>(R.id.txtTimeZone)
            val nationality = findViewById<EditText>(R.id.txtNationality)
            val language = findViewById<EditText>(R.id.txtLanguage)

            val darkmode = swdarkMode.isChecked
            var pref = CVPreferences(darkmode, timezone.text.toString(),nationality.text.toString(), language.text.toString())
        }

    }
}