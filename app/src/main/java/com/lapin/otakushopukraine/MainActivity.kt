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

        if (itemId === R.id.author_Info) {
            goToActivity( AuthorInfoActivity::class.java)
        }
        else if (itemId === R.id.application_info) {
            goToActivity( ApplicationInfoActivity::class.java)
        }

        return true
    }
    fun goToCatalog(view: View?)
    {
        goToActivity(CatalogActivity::class.java)
    }
    fun goToLogin(view: View?)
    {
        goToActivity(LoginActivity::class.java)
    }

    private fun goToActivity(activity:Class<*>) {
        val intent = Intent(this, activity)
        startActivity(intent)
    }


}
