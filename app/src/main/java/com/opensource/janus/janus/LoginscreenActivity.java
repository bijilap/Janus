package com.opensource.janus.janus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LoginscreenActivity extends FragmentActivity {

    CallbackManager callbackManager;

    private static String FB_TAG = "FACEBOOK_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_loginscreen);
        callbackManager = CallbackManager.Factory.create();
        LoginButton fbloginButton = (LoginButton) findViewById(R.id.fb_login_button);
        fbloginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Log.d(FB_TAG, "SUCCESSFUL FACEBOOK LOGIN!");
            }

            @Override
            public void onCancel() {
                // App code
                Log.d(FB_TAG, "FACEBOOK LOGIN CANCELLED");
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Log.d(FB_TAG, "FACEBOOK LOGIN ERRORED OUT");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
