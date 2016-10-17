package com.example.loginrelative;

/**
 * Created by usuario on 6/10/16.
 */
public interface ILoginMvp {

    int DATA_EMPTY = 4;
    int PASSWORD_DIGIT = 1;
    int PASSWORD_CASE = 2;
    int PASSWORD_LENGTH = 3;

    interface View {
        void setMessageError(String messageError, int idView);
    }

    interface Presenter {
        void validateCredentials(String user, String password);
    }
}
