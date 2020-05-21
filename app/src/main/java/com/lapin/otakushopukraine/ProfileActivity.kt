package com.lapin.otakushopukraine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    private lateinit var userNameView: TextView
    private lateinit var userAvatar: ImageView
    private lateinit var dateBirthView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        title =  "Особистий кабінет"
        userAvatar = findViewById<ImageView>(R.id.userPhoto)
        userNameView = findViewById<TextView>(R.id.userFullName)
        dateBirthView = findViewById<TextView>(R.id.userDateOfBirth)
        //TestSets
        userAvatar.setImageResource(R.drawable.authorphoto)
        userNameView.setText("Лапін Костянтин Едуардович")
        val date = "28.02.2000"
        dateBirthView.text = date


    }
    fun goToCatalog(view: View?)
    {
        val intent = Intent(this,CatalogActivity::class.java)
        startActivity(intent)
    }
    fun Exit(view: View?)
    {
        goToCatalog(view)
    }

}
