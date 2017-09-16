package westviewfamilymedicine.com.mvpsample.login;

public interface LoginInteractor {

    interface OnLoginFinishedListener {
        /*void onUsernameError();

        void onPasswordError();

        void onServiceError(String service_error);*/

        void onError(String error);

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);

}
