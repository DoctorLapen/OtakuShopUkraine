package com.lapin.otakushopukraine

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 */
class ProfileMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_main, container, false)
    }
    fun goToCatalog(view: View?)
    {
      //  val intent = activity!!.intent.
      //  startActivity(intent)
    }
    fun Exit(view: View?)
    {
        goToCatalog(view)
    }

}