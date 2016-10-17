package com.example.loginrelative;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginRelative_Activity extends AppCompatActivity  implements ILoginMvp.View {

    private ILoginMvp.Presenter loginMvp;
    private EditText edtPassword;
    private EditText edtUser;
    private TextInputLayout tilUser;
    private TextInputLayout tilPassword;
    private Button btnLogin;
    private final String TAG = "loginrelative";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative);

        loginMvp = new LoginPresenter(this);
        tilUser = (TextInputLayout) findViewById(R.id.tilUser);
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginMvp.validateCredentials(edtUser.getText().toString(), edtPassword.getText().toString());
            }
        });


        // Comprobar la persistencia del objeto Application

        if (((LoginApplication)getApplicationContext()).getUser() != null) {
            Log.d(TAG, ((LoginApplication)getApplicationContext()).getUser().toString());
        }

        Log.d(TAG, "Activity creada");
    }

    @Override
    public void setMessageError(String messageError, int idView) {
        //Toast.makeText(this, messageError, Toast.LENGTH_SHORT).show();

        switch (idView) {
            case R.id.tilUser:
                tilUser.setError(messageError);
                break;
            case R.id.tilPassword:
                tilPassword.setError(messageError);
        }

    }

    private void resetValues() {
        edtUser.setText("");
        edtPassword.setText("");
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity destruida");
    }
}
