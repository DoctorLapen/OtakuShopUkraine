package com.lapin.otakushopukraine




import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

val keyCategory:String = "К"
class CatalogActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var nameHeader: TextView
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

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        nameHeader =  navView.getHeaderView(0).findViewById(R.id.userNameHeader)
        nameHeader.text = getString (R.string.testEmail);

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var activity:Class<*> = CatalogActivity::class.java
        when (item.itemId) {

            R.id.goToLogin -> {
                goToActivity(LoginActivity::class.java)

            }
            R.id.goToProfile-> {
                goToActivity(ProfileActivity::class.java)
            }
            R.id.nav_application -> {
                goToActivity(ApplicationInfoActivity::class.java)
            }
            R.id.nav_author-> {
                goToActivity(AuthorInfoActivity::class.java)
            }
            R.id.nav_logout -> {
                nameHeader.text=""
            }
        }


        return true
    }
    private fun goToActivity(activity:Class<*>) {
        val intent = Intent(this, activity)
        startActivity(intent)
    }

}
