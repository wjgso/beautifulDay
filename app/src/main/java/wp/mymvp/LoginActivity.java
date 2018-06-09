package wp.mymvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private EditText mUserName;
    private EditText mPassword;
    private Button mLogin;
    private ProgressBar mWaitLogin;

    private LoginPresent mPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mPresent = new LoginPresentImpl(this, new LoginModelImpl());

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUserName.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                //简单进行非空验证
                if (username != null && !username.equals("") && password != null && !password.equals("")) {
                    //这里想要执行登录操作，需要通过Present控制Model请求
                    mPresent.doLogin(username, password);
                } else {
                    Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void initView() {
        mUserName = (EditText) findViewById(R.id.et_username);
        mPassword = (EditText) findViewById(R.id.et_password);
        mLogin = (Button) findViewById(R.id.btn_login);
        mWaitLogin = (ProgressBar) findViewById(R.id.pb_wait_login);
    }

    @Override
    public void showProgress() {
        mWaitLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mWaitLogin.setVisibility(View.GONE);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        //登录成功，跳转到主页面
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        //登录失败，停留在登录页面
    }
}
