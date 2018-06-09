package wp.mymvp;

/**
 * Created by wp on 17-12-21.
 */

public class LoginPresentImpl implements LoginPresent,LoginModel.OnLoginListener{
    private LoginView mView;
    private LoginModel mModel;

    public LoginPresentImpl(LoginView view, LoginModel model) {
        mView = view;
        mModel = model;
    }
    @Override
    public void doLogin(String username,String password) {
        mView.showProgress();
        mModel.login(username, password, this);
    }

    @Override
    public void onLoginSuccess() {
        mView.hideProgress();
        mView.loginSuccess();
    }

    @Override
    public void onLoginFail() {
        mView.hideProgress();
        mView.loginFail();
    }
}
