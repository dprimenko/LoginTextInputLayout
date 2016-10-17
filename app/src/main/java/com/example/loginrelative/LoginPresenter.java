package com.example.loginrelative;

import android.content.Context;
import android.text.TextUtils;

/**
 * Created by usuario on 6/10/16.
 */

public class LoginPresenter implements ILoginMvp.Presenter {

    private ILoginMvp.View view;

    public LoginPresenter(ILoginMvp.View view) {
        this.view = view;
    }

    @Override
    public void validateCredentials(String user, String password) {

        if (TextUtils.isEmpty(user)|| TextUtils.isEmpty(password)) {
            view.setMessageError(((Context)view).getResources().getString(R.string.data_empty), R.id.tilUser);
        }
        else if (!((password.matches(".*[a-z]*.")) && (password.matches(".*[A-Z]*.")))) {
            view.setMessageError(((Context)view).getResources().getString(R.string.password_case), R.id.tilPassword);
        }
        else if (!(password.matches(".*[0-9]*."))) {
            view.setMessageError(((Context)view).getResources().getString(R.string.password_digit), R.id.tilPassword);
        }
        else if (password.length() < 8) {
            view.setMessageError(((Context)view).getResources().getString(R.string.password_length), R.id.tilPassword);
        }
        else {
            // Guardar el usuario e la Clase Application
            ((LoginApplication)((Context)view).getApplicationContext()).setUser(new User(user, password));
        }
    }
}
