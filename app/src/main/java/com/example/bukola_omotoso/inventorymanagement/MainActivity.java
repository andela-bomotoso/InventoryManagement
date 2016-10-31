package com.example.bukola_omotoso.inventorymanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText userNameEdit;
    private EditText passwordEdit;
    private Button signIn;
    private Button signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEdit = (EditText) findViewById(R.id.userName);
        passwordEdit = (EditText) findViewById(R.id.password);
        signIn = (Button) findViewById(R.id.signin);
        signUp = (Button) findViewById(R.id.sign_up);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }

    public void signIn() {
        String username = userNameEdit.getText().toString();
        String password = userNameEdit.getText().toString();

        validateAndLogin();
    }

    public void signUp() {
        String username = userNameEdit.getText().toString();
        String password = userNameEdit.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("LOGIN", MODE_PRIVATE);
        sharedPreferences.edit().putString("USER_NAME", username).apply();
        sharedPreferences.edit().putString("PASSWORD", password).apply();
        if (!username.isEmpty() && !password.isEmpty()) {
            startActivity(new Intent(MainActivity.this, StockActivity.class));
        } else {
            if(username.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, getString(R.string.empty_username_password), Toast.LENGTH_LONG).show();
            }
            if(userAlreadyExist()){
                Toast.makeText(MainActivity.this, getString(R.string.user_already_exist), Toast.LENGTH_LONG).show();
            }
        }
    }

    public void validateAndLogin() {
        String username = userNameEdit.getText().toString();
        String password = userNameEdit.getText().toString();

        if (!(username.isEmpty() && password.isEmpty())) {
            SharedPreferences preferences = getSharedPreferences("LOGIN", MODE_PRIVATE);
            if (username.equals(preferences.getString("USER_NAME", ""))
                    && password.equals(preferences.getString("PASSWORD", ""))) {
                startActivity(new Intent(MainActivity.this, StockActivity.class));
            } else {
                Toast.makeText(this, "User not available in database", Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean userAlreadyExist() {
        String username = userNameEdit.getText().toString();
        String password = userNameEdit.getText().toString();
        SharedPreferences preferences = getSharedPreferences("LOGIN", MODE_PRIVATE);
        if (username.equals(preferences.getString("USER_NAME", ""))
                && password.equals(preferences.getString("PASSWORD", ""))) {
            return true;
        }

        return false;
    }

}
