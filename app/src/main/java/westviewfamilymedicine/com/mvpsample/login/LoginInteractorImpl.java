package westviewfamilymedicine.com.mvpsample.login;

import android.text.TextUtils;

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {

                boolean error = false;
                boolean service= true;
                if (TextUtils.isEmpty(username)){
                    //listener.onUsernameError();
                    listener.onError("Username cannot be empty");
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    //listener.onPasswordError();
                    listener.onError("Password cannot be empty");
                    error = true;
                    return;
                }
                if (!service){
                //listener.onServiceError("Get Message from Service");
                    listener.onError("Get Message from Service");
                error = true;
                return;
        }

                if (!error){
                    listener.onSuccess();
                }
            }

}
