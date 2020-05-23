package com.lapin.otakushopukraine




import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.*

val keyCategory:String = "К"
class CatalogActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var mDatabase: DatabaseReference? = null
    private var mMessageReference: DatabaseReference? = null
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var nameHeader: TextView
    lateinit var countriesListView: ListView
    lateinit var  adapter: ArrayAdapter<String>
    private var categories:ArrayList<String> = ArrayList<String>()
    private var categoriesMap:MutableMap<String,String> = mutableMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog);
         countriesListView = findViewById(R.id.categories) as ListView

        adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, categories
        )
        // устанавливаем для списка адаптер
        // устанавливаем для списка адаптер
        countriesListView.setAdapter(adapter)
        // добвляем для списка слушатель
        // добвляем для списка слушатель
        countriesListView.setOnItemClickListener(object : AdapterView.OnItemClickListener {
           override fun onItemClick(parent: AdapterView<*>?, v: View?, position: Int, id: Long) {
               var item = categoriesMap[categories[position]]
               val intent = Intent(getApplicationContext(),ProductCategoryActivity::class.java)
               intent.putExtra(keyCategory, item);
               startActivity(intent)

            }
        })
        setUpFirebaseRealTime()

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
    private fun setUpFirebaseRealTime(){
        mDatabase = FirebaseDatabase.getInstance().reference
        mMessageReference = FirebaseDatabase.getInstance().getReference("Categories")
        mMessageReference!!.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                  var value = dataSnapshot.getKey()
                  var child = dataSnapshot.child("categoryName").getValue().toString()
                  categories.add(child!!)
                categoriesMap.put(child!! ,value!!)
                adapter.notifyDataSetChanged()
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {

            }



            override fun onChildRemoved(p0: DataSnapshot) {

            }


            // This method is called once with the initial value and again



        })


    }

}
