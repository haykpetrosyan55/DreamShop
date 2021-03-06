package com.DreamShop.hp.DreamShop.activityes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.DreamShop.hp.DreamShop.R;
import com.DreamShop.hp.DreamShop.fragment.ProdListFragment;
import com.DreamShop.hp.DreamShop.models.Category;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        ProdListFragment prodFragment = (ProdListFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentId);
        switch (id) {
            case R.id.homeId:
                prodFragment.updateAdapter();
                break;
            case R.id.carCategoryId:
                prodFragment.updateListData(Category.CAR);
                break;
            case R.id.gunCategoryId:
                prodFragment.updateListData(Category.GUN);
                break;
            case R.id.guitarCategoryId:
                prodFragment.updateListData(Category.GUITAR);
                break;
            case R.id.pleasureCategoryId:
                prodFragment.updateListData(Category.PLEASURE);
                break;
            case R.id.menuFavoriteId:
                prodFragment.setListByFavorite();
                break;
            case R.id.menuBasketId:
                prodFragment.setListByBasket();
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return onOptionsItemSelected(item);
    }

}
