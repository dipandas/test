package westviewfamilymedicine.com.mvpsample.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import westviewfamilymedicine.com.mvpsample.R;
import westviewfamilymedicine.com.mvpsample.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {


    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

        presenter = new LoginPresenterModel(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }


    @Override
    public void setError(String error) {
        Toast.makeText(this, error , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void navigateToHome() {

        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);
    }
}
