package com.example.aplikacjalogowania1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etLogin, etPassword; //pola na login i hasło
    Button btPotwierdz; //przycisk logowania

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //wywoływanie funkcji bazowej
        setContentView(R.layout.activity_main);
        //przypisywanie pól
        etLogin = findViewById(R.id.et_login);
        btPotwierdz = findViewById(R.id.bt_potwierdz);
        // ustawienie funkcji przycisku
        btPotwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sprawdzamy czy login i hasło mają  admin
                if (etLogin.getText().toString().equals("admin") &&
                        etPassword.getText().toString().equals("admin")) {
                    //tworzenie komunikatu udanego logowania
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            MainActivity.this
                    );
                    builder.setIcon(R.drawable.ic_check);
                    builder.setTitle("Logowanie sie powiodlo");
                    builder.setMessage("Adminie udało ci sie zalogowac do serwisu");

                    builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                        //zamykanie komunikatu po potwierdzeniu
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                //powiadomienie ze login i hasło sa niepoprawne
                else {
                    Toast.makeText(getApplicationContext(),
                            "Zly login lub haslo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}