package com.snhu.weight_tracker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText txtFieldUsername = findViewById(R.id.editTextUsername);
        EditText txtFieldPassword = findViewById(R.id.editTextPassword);

        Button btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(l -> {
            // get username and password from fields
            String username = txtFieldUsername.getText().toString();
            String password = txtFieldPassword.getText().toString();

            AuthenticatedUser user = new AuthenticatedUser("Mike");
            AuthenticatedUserManager.getInstance().setUser(user);
        });
    }

}
