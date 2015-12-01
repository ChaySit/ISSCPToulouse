package com.cap.projet5iss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Nana on 01/12/2015.
 */
public class Login extends Activity implements View.OnClickListener{

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;
    UserLocalStore userLocalStore;

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bLogin:
                User user=new User(null, null);
                UserLocalStore.StoreUserData(user);
                UserLocalStore.setUserLoggedIn(true);
                break;

            case R.id.tvRegisterLink:
                startActivity(new Intent(this, Register.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername= (EditText) findViewById(R.id.etUsername);
        etPassword= (EditText) findViewById(R.id.etPassword);
        bLogin= (Button) findViewById(R.id.bLogin);
        tvRegisterLink= (TextView) findViewById(R.id. tvRegisterLink);

        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
        userLocalStore= new UserLocalStore(this);

    }

}
