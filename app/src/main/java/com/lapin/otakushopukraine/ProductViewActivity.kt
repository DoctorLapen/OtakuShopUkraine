package com.lapin.otakushopukraine

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductViewActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var priceView: TextView
    private lateinit var descriptionView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_view)
        val product: Product = intent.getParcelableExtra(EXTRA_USER_MODEL)
        supportActionBar?.title = product.name

        imageView = findViewById<ImageView>(R.id.image_view)
        textView = findViewById<TextView>(R.id.text_view)
        priceView = findViewById<TextView>(R.id.price_detal)
        descriptionView = findViewById<TextView>(R.id.description)




        textView.setText(product?.name)
        priceView.setText("${product?.price} грн.")
        descriptionView.setText(product?.description)
        Picasso.get().load(product?.imageUrl).into(imageView);

    }

    companion object {
        var TAG = ProductViewActivity::class.java.simpleName
        const val EXTRA_USER_MODEL: String = "user"

        fun newIntent(context: Context, product: Product): Intent {
            var intent = Intent(context, ProductViewActivity::class.java)
            intent.putExtra(EXTRA_USER_MODEL, product)
            return intent
        }
    }
}
