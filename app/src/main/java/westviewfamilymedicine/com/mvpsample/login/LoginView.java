
package westviewfamilymedicine.com.mvpsample.login;

public interface LoginView {

  /*  void setUsernameError();

    void setPasswordError();

    void setServiceError(String service_error);*/

    void setError(String error);

    void navigateToHome();
}
