package com.example.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
private BottomNavigationView bttmNvgtnVw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new Homefrag());

        bttmNvgtnVw = findViewById(R.id.bottom_nav_bar);
        bttmNvgtnVw.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragmenta =null;
        switch (menuItem.getItemId()){
            case R.id.home:
                fragmenta = new Homefrag();
                break;
            case R.id.bus:
                fragmenta = new Busfrag();
                break;
            case R.id.erp:
                fragmenta = new Erpfrag();
                break;
            case R.id.social:
                fragmenta = new Socialfrag();
                break;
            case R.id.library:
                fragmenta = new Libraryfrag();
                break;
        }
        return loadFragment(fragmenta);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment !=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
