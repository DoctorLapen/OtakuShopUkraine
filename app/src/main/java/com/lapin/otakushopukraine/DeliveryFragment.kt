package com.lapin.otakushopukraine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class DeliveryFragment : Fragment(),View.OnClickListener {

    private lateinit var cityView: TextView
    private lateinit var BranchView: TextView
    private lateinit var cardView: TextView
    private lateinit var editCity: EditText
    private lateinit var editBranch: EditText
    private lateinit var editCard: EditText
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var v =  inflater.inflate(R.layout.fragment_delivery, container, false)

        var submitButton: Button = v.findViewById(R.id.deliveryButton)
        cityView = v.findViewById(R.id.City)
        BranchView = v.findViewById(R.id.postBranch)
        cardView = v.findViewById(R.id.cardNumber)
        editCity = v.findViewById(R.id.editCity)
        editBranch = v.findViewById(R.id.editBranch)
        editCard = v.findViewById(R.id.editCard)
        submitButton.setOnClickListener(this)
        return v
    }
    override fun onClick(v: View?)
    {
        cityView.text = "Місто: ${editCity.text}"
        BranchView.text = "Відділеня: ${editBranch.text}"
        cardView.text = "Номер картки: ${editCard.text}"
    }
}
