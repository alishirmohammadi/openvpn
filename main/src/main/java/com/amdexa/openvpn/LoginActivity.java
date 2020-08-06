/*
 * Copyright (c) 2012-2020 Arne Schwabe
 * Distributed under the GNU GPL v2 with additional terms. For full terms see the file doc/LICENSE.txt
 */

package com.amdexa.openvpn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amdexa.openvpn.activities.MainActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText password, username;
    private TextView wrong_pass;
    private Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        wrong_pass = findViewById(R.id.login_wrong_pass);
        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_value = username.getText().toString();
                String password_value = password.getText().toString();

                if (password_value.equals("alishir")) {
                    wrong_pass.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    MainActivity.isLoggedIn = true;
                    startActivity(intent);
                    finish();
                } else {
                    wrong_pass.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}