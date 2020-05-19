package com.lapin.otakushopukraine




import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Find the toolbar view inside the activity layout

        // Find the toolbar view inside the activity layout
        val toolbar: Toolbar = findViewById(R.id.toolbar) as Toolbar
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.getItemId();
        var newActivity:Class<*> = AuthorInfoActivity::class.java
        if (itemId === R.id.author_Info) {
            newActivity = AuthorInfoActivity::class.java
        }
        else if (itemId === R.id.application_info) {
            newActivity = ApplicationInfoActivity::class.java
        }
        val intent = Intent(this, newActivity)
        startActivity(intent)
        return true
    }
    fun goToCatalog(view: View?) {
        val intent = Intent(this, CatalogActivity::class.java)
        startActivity(intent)
    }

}
