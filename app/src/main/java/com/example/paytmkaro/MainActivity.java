package com.example.paytmkaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomnav= findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(navlistner);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,new HomeFragment()).commit();
        Toolbar toolbar =findViewById(R.id.toolbar);
        drawerLayout =findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toogle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
toolbar.setLogo(R.drawable.searchbar);

    }
    public BottomNavigationView.OnNavigationItemSelectedListener navlistner= new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectFragment =null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectFragment =new HomeFragment();
                    break;
                case R.id.bav_mall:
                    selectFragment =new MoalFragment();
                    break;

                case R.id.ban_bank:
                    selectFragment =new BankFragment();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,selectFragment);

            return true;
        }
    };

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}