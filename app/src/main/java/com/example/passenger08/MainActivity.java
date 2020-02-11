package com.example.passenger08;

import android.os.Bundle;

import com.example.passenger08.ui.gallery.GalleryFragment;
import com.example.passenger08.ui.share.ShareFragment;
import com.example.passenger08.ui.slideshow.SlideshowFragment;
import com.example.passenger08.ui.tools.ToolsFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        final FloatingActionButton fab = findViewById(R.id.fab);
//        System.out.println(fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);

            navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
                @Override
                public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

                    int menuId = destination.getId();
                    switch (menuId) {
                        case R.id.nav_home:
                            map map = new map();
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.mainLayout, map).commit();
                            break;

                        case R.id.nav_gallery:
                            GalleryFragment galleryFragment = new GalleryFragment();
                            FragmentManager fragmentManager1 = getSupportFragmentManager();
                            fragmentManager1.beginTransaction().replace(R.id.mainLayout, galleryFragment).commit();
                            break;

                        case R.id.nav_slideshow:
                            SlideshowFragment slideshowFragment = new SlideshowFragment();
                            FragmentManager fragmentManager2 = getSupportFragmentManager();
                            fragmentManager2.beginTransaction().replace(R.id.mainLayout, slideshowFragment).commit();
                            break;

                        case R.id.nav_tools:
                            ToolsFragment toolsFragment = new ToolsFragment();
                            FragmentManager fragmentManager3 = getSupportFragmentManager();
                            fragmentManager3.beginTransaction().replace(R.id.mainLayout, toolsFragment).commit();
                            break;

                        case R.id.nav_share:
                            ShareFragment shareFragment = new ShareFragment();
                            FragmentManager fragmentManager4 = getSupportFragmentManager();
                            fragmentManager4.beginTransaction().replace(R.id.mainLayout, shareFragment).commit();
                            break;



                        default:
                           // fab.show();
                            break;

                    }

                }
            });

//            System.out.println();
//            map map = new map();
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.mainLayout, map).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
