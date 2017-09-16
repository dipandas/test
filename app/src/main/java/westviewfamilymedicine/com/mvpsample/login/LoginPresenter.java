package westviewfamilymedicine.com.mvpsample.login;

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
