package wp.mymvp;

/**
 * Created by wp on 17-12-21.
 */

public interface LoginModel {
    interface OnLoginListener {
        void onLoginSuccess();

        void onLoginFail();
    }

    void login(String username, String password, OnLoginListener listener);
}
