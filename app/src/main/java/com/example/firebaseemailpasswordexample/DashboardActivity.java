package com.example.firebaseemailpasswordexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String currentUser = mAuth.getCurrentUser().getEmail();
        welcomeText = (TextView)findViewById(R.id.welcome);
        welcomeText.setText(currentUser);
    }

    public void onLogoutClicked(View view) {

        mAuth.getInstance().signOut();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
