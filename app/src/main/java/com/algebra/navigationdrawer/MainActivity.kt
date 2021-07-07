package com.algebra.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity( ) {

    private lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        setSupportActionBar( findViewById( R.id.toolbar ) )
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled( true )
            setHomeAsUpIndicator( R.mipmap.ic_launcher_round )
        }

        mDrawerLayout = findViewById( R.id.drawer_layout )


            findViewById< NavigationView >( R.id.nav_view ).setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            mDrawerLayout.closeDrawers( )
            when ( menuItem.itemId ) {
                R.id.nav_profile -> {
                    Toast.makeText( this, "Donut", Toast.LENGTH_LONG ).show( )
                    supportFragmentManager
                        .beginTransaction( )
                        .replace( R.id.fragmentContainer, BlueFragment( ) )
                        .commit( )
                }
                R.id.nav_wallet -> {
                    Toast.makeText( this, "Explore", Toast.LENGTH_LONG ).show( )
                    supportFragmentManager
                        .beginTransaction( )
                        .replace( R.id.fragmentContainer, HeartFragment( ) )
                        .commit( )
                }
                R.id.nav_offer -> {
                    Toast.makeText(this, "Favourite", Toast.LENGTH_LONG).show()
                    supportFragmentManager
                        .beginTransaction( )
                        .replace( R.id.fragmentContainer, GreenFragment( ) )
                        .commit( )
                }
                R.id.nav_setting -> {
                    Toast.makeText( this, "Fingerprint", Toast.LENGTH_LONG ).show( )
                    supportFragmentManager.fragments.forEach {
                        supportFragmentManager
                            .beginTransaction( )
                            .remove( it )
                            .commit( )
                    }
                }
            }
            true
        }
    }

    //appbar - toolbar button click
    override fun onOptionsItemSelected( item: MenuItem ): Boolean {
        return when ( item.itemId ) {
            android.R.id.home -> {
                Toast.makeText( this, "Home clicked", Toast.LENGTH_LONG ).show( )
                mDrawerLayout.openDrawer( GravityCompat.START )
                true
            }
            else -> super.onOptionsItemSelected( item )
        }
    }
}
