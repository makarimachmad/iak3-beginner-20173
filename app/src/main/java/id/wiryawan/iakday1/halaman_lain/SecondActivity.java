package id.wiryawan.iakday1.halaman_lain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.wiryawan.iakday1.R;

/**
 * Created by wiryawan on 11/12/17.
 */

public class SecondActivity extends AppCompatActivity {

    EditText emailUser, passUser;
    Button btnRegister, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_dua);

        emailUser = findViewById(R.id.nameUser);
        passUser = findViewById(R.id.passUser);

        btnRegister = findViewById(R.id.daftar);
        btnClear = findViewById(R.id.clear);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailUser.getText().toString();
                String pass = passUser.getText().toString();

                Toast.makeText(getApplicationContext(), "Selamat Anda Sudah terdaftar!" + "\n" +
                                "Email : " + email + "\n" + "Password : " + pass,
                                Toast.LENGTH_LONG).show();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailUser.setText("");
                passUser.setText("");
            }
        });

    }
}
