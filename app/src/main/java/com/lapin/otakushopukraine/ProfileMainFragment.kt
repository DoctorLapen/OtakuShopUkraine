package com.lapin.otakushopukraine

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class ProfileMainFragment : Fragment(), View.OnClickListener {
    private lateinit var dateBirthView: TextView
    private lateinit var userEmailView: TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

        // Inflate the layout for this fragment
        var v =  inflater.inflate(R.layout.fragment_profile_main, container, false)
        dateBirthView = v.findViewById<TextView>(R.id.userDateOfBirth)
        userEmailView = v.findViewById(R.id.EmailView)
        var exitButton: Button = v.findViewById(R.id.userExitButton)
        var shopButton: Button = v.findViewById(R.id.ShopButton)
        val date = "28.02.2000"
        dateBirthView.text = date
        userEmailView.text = getString (R.string.testEmail);
        exitButton.setOnClickListener(this)
        shopButton.setOnClickListener(this)
        return v

    }

    private fun goToCatalog(view: View?)
    {
        val intent = Intent(this.context,CatalogActivity::class.java)
        requireActivity().startActivity(intent)
    }



    override fun onClick(v: View?)
    {
        goToCatalog(v)
    }
}