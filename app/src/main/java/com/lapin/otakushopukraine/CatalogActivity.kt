package com.lapin.otakushopukraine




import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

val keyCategory:String = "К"
class CatalogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)
        val countriesList: ListView = findViewById(R.id.categories) as ListView

        val categories = resources.getStringArray(R.array.categoriesName)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, categories
        )
        // устанавливаем для списка адаптер
        // устанавливаем для списка адаптер
        countriesList.setAdapter(adapter)
        // добвляем для списка слушатель
        // добвляем для списка слушатель
        countriesList.setOnItemClickListener(object : AdapterView.OnItemClickListener {
           override fun onItemClick(parent: AdapterView<*>?, v: View?, position: Int, id: Long) {
               var item = categories[position]
               val intent = Intent(getApplicationContext(),ProductCategoryActivity::class.java)
               intent.putExtra(keyCategory, item);
               startActivity(intent)

            }
        })
    }

}
