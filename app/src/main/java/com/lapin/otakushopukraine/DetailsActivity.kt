package com.lapin.otakushopukraine

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val product: Product = intent.getParcelableExtra(EXTRA_USER_MODEL)
        supportActionBar?.title = product.name

        imageView = findViewById<ImageView>(R.id.image_view)
        textView = findViewById<TextView>(R.id.text_view)


        imageView.setImageResource(product?.imageId)
        textView.setText("Showing information of "+ product?.name)

    }

    companion object {
        var TAG = DetailsActivity::class.java.simpleName
        const val EXTRA_USER_MODEL: String = "user"

        fun newIntent(context: Context, product: Product): Intent {
            var intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(EXTRA_USER_MODEL, product)
            return intent
        }
    }
}
