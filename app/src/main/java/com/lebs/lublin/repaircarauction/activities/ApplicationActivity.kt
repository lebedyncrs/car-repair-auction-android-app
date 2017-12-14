package com.lebs.lublin.repaircarauction.activities

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.lebs.lublin.repaircarauction.R
import com.lebs.lublin.repaircarauction.models.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class ApplicationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        changeFragment(OfferListFragment(), AddOffer.actionBarTitle)

        fab.setOnClickListener {
            changeFragment(AddOffer(), AddOffer.actionBarTitle)
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        initializeMenu()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        when (item.itemId) {
//            R.id.action_settings -> return true
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.driverAuction -> {
                changeFragment(OfferListFragment(), OfferListFragment.actionBarTitle)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun changeFragment(fragment: Fragment, actionBarTitle: String) {
        var transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content, fragment).commit();
        supportActionBar?.title = actionBarTitle

        if (fragment is OfferListFragment) {
            fab.show()
        } else {
            fab.hide()
        }
    }

    private fun initializeMenu() {
        val user: User = intent.getParcelableExtra("user")
        if (user.isDriver()) {
            nav_view.menu.setGroupVisible(R.id.driverMenu, true)
        } else {
            nav_view.menu.setGroupVisible(R.id.ctoMenu, true)
        }

        nav_view.invalidate()
    }
}
