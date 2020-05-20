package com.lapin.otakushopukraine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProductCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_category)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListFragment.newInstance(), ListFragment.TAG)
                .commit();
        }
    }
}
