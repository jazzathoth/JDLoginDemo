package com.jb.jdlogindemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.okta.oidc.AuthorizationStatus;
import com.okta.oidc.OIDCConfig;
import com.okta.oidc.Okta;
import com.okta.oidc.ResultCallback;
import com.okta.oidc.clients.web.WebAuthClient;
import com.okta.oidc.util.AuthorizationException;

public class LoginActivity extends AppCompatActivity {

    private WebAuthClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OIDCConfig config = new OIDCConfig.Builder()
                .withJsonFile(this, R.raw.okta_oidc_config)
                .create();

        client = new Okta.WebAuthBuilder()
                .withConfig(mOidcConfig)
                .withContext(this)
                .create();

        ResultCallback<AuthorizationStatus, AuthorizationException> callback =
                new ResultCallback<AuthorizationStatus, AuthorizationException>() {
            @Override
            public void onSuccess(@NonNull AuthorizationStatus result) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(@Nullable String msg, @Nullable AuthorizationException exception) {

            }
        };
        client.registerCallback(callback, this);
    }
}
