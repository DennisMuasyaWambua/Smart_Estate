package com.example.smartestate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class DashboardFragment extends Fragment implements  NavigationView.OnNavigationItemSelectedListener {
    private CardView statementCard, paymentCard,suggestionsCard, servicesCard;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private Toolbar toolbar;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dashboard,container, false);

        //initializing user interface elements
        statementCard = (CardView)v.findViewById(R.id.statementCard);
        paymentCard = (CardView)v.findViewById(R.id.paymentCard);
        suggestionsCard = (CardView)v.findViewById(R.id.suggestionsCard);
        servicesCard = (CardView)v.findViewById(R.id.servicesCard);

        //setting up the hooks
        drawerLayout = (DrawerLayout) v.findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) v.findViewById(R.id.nav_view);
        toolbar = (Toolbar)v.findViewById(R.id.toolbar);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);



      ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        //navigation Drawer menu
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        paymentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),PaymentsActivity.class);
                startActivity(intent);
            }
        });


        return v;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return true;
    }
}
