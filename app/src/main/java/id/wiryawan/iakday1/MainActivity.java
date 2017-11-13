package id.wiryawan.iakday1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.wiryawan.iakday1.halaman_lain.HomePage;
import id.wiryawan.iakday1.halaman_lain.SecondActivity;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button btnLogin, btnClear;
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.nameUser);
        pass = findViewById(R.id.passUser);

        btnLogin = findViewById(R.id.login);
        btnClear = findViewById(R.id.clear);

        txtRegister = findViewById(R.id.register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do Something
                String userNm = user.getText().toString();
                String passUs = pass.getText().toString();

                Toast.makeText(getApplicationContext(),
                        "Nama : " + userNm + "\n" + "Pass : " + passUs,
                        Toast.LENGTH_SHORT).show();

                Login(userNm,passUs);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setText("");
                pass.setText("");
            }
        });

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

    }

    /*
     * Fungsi Untuk login
     */

    public void Login(String userNm, String userPwd) {

        if (!validation()) {
            Toast.makeText(getApplicationContext(), "Gagal login!", Toast.LENGTH_LONG).show();
            return;
        }

        String emailUser = "iak2017@mail.com";
        String pwd = "12345";

        if (userNm.equals(emailUser) && userPwd.equals(pwd)) {

            Intent i = new Intent(MainActivity.this, HomePage.class);
            Bundle b = new Bundle();
            b.putString("email", userNm);
            b.putString("pass", userPwd);
            i.putExtra("user",b);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Email dan Password salah", Toast.LENGTH_LONG).show();
        }


    }


    /* Untuk validasi login
     * Created by : Manggala 12 Nov 2017 / manggala.wiryawan@gmail.com
     */

    public boolean validation() {
        boolean validate = true;

        String email = user.getText().toString();
        String password = pass.getText().toString();

        /* Validasi karakter pada email */
        if (email.isEmpty() || email.length() < 3) {
            user.setError("Harus lebih dari 3 karakter");
            validate = false;
        } else {
            user.setError(null);
        }

        // Validasi cek apakah email atau bukan
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            user.setError("Ini bukan email lho!");
            validate = false;
        } else {
            user.setError(null);
        }

        // Validasi cek panjang password
        if (password.isEmpty() || password.length() < 4) {
            pass.setError("Password tidak boleh kosong dan kurang dari 4.");
            validate = false;
        } else {
            pass.setError(null);
        }

        return validate;

    }

}
