package com.lebs.lublin.repaircarauction

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.lebs.lublin.repaircarauction.models.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class ApplicationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val manager = fragmentManager;
            var transaction = manager.beginTransaction();
            val fragment = AddOffer();
            transaction.replace(R.id.main_content, fragment).commit();
            supportActionBar?.title = "Dodaj ogłoszenie"
            fab.hide()
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        setDefaultFragment()

        val navView = findViewById<View>(R.id.nav_view) as NavigationView

        val user: User = intent.getParcelableExtra("user")

        val menu = navView.menu
        if(user.isDriver()) {
            menu.setGroupVisible(R.id.driverMenu, true)
        }else {
            menu.setGroupVisible(R.id.ctoMenu, true)
        }

        navView.invalidate()
    }

    private fun setDefaultFragment() {
        val manager = fragmentManager;
        var transaction = manager.beginTransaction();
        val fragment = OfferListFragment();
        transaction.replace(R.id.main_content, fragment).commit();
        supportActionBar?.title = "Moje Ogłoszenia"
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val manager = fragmentManager;
        var transaction = manager.beginTransaction();
        when (item.itemId) {
            R.id.driverAuction -> {
                val fragment = OfferListFragment();
                transaction.replace(R.id.main_content, fragment).commit();
                supportActionBar?.title = "Dodaj ogłoszenie"
                fab.show()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
