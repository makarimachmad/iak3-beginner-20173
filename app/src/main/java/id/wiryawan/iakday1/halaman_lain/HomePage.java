package id.wiryawan.iakday1.halaman_lain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import id.wiryawan.iakday1.R;

/**
 * Created by wiryawan on 11/12/17.
 */

public class HomePage extends AppCompatActivity {

    TextView txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        txtEmail = findViewById(R.id.tampilEmail);
        txtPassword = findViewById(R.id.tampilPassword);

        Intent i = getIntent();
        Bundle b = i.getBundleExtra("user");
        String email = b.getString("email");
        String pass = b.getString("pass");

        txtEmail.setText(email);
        txtPassword.setText(pass);

    }
}
