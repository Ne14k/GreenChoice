package com.example.greenchoice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class GardenActivity extends AppCompatActivity {
    Button mybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        mybutton = findViewById(R.id.myButton); // Initialize the button

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchURI("https://www.amazon.ca/");
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);

                if (id == R.id.nav_home) {
                    launchHome();
                }
                else if (id == R.id.nav_electronics) {
                    launchElectronics();
                }

                else if (id == R.id.nav_apparel) {
                    launchApparel();
                }

                else if (id == R.id.nav_foodandbev) {
                    launchFood();
                }

                else if (id == R.id.nav_gardenandtools) {
                    launchGarden();
                }

                else if (id == R.id.nav_healthandbeauty) {
                    launchHealth();
                }

                else if (id == R.id.nav_homeandpet) {
                    launchPet();
                }

                else if (id == R.id.nav_school) {
                    launchSchool();
                }
                return true;
            }
        });
    }

    //Methods launching diff activities
    public void launchHome() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void launchElectronics() {
        Intent i = new Intent(this, ElectronicsActivity.class);
        startActivity(i);
    }

    public void launchFood() {
        Intent i = new Intent(this, FoodActivity.class);
        startActivity(i);
    }

    public void launchGarden() {
        Intent i = new Intent(this, GardenActivity.class);
        startActivity(i);
    }

    public void launchHealth() {
        Intent i = new Intent(this, HealthActivity.class);
        startActivity(i);
    }

    public void launchPet() {
        Intent i = new Intent(this, PetActivity.class);
        startActivity(i);
    }

    public void launchSchool() {
        Intent i = new Intent(this, SchoolActivity.class);
        startActivity(i);
    }

    public void launchApparel() {
        Intent i = new Intent(this, ApparelActivity.class);
        startActivity(i);
    }//end


    //URL launching method
    public void launchURI(String s) {
        try {
            Uri uri = Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        } catch (Exception e) {
            Toast.makeText(this, "Error: No Website Available", Toast.LENGTH_SHORT).show();
        }
    }
}
