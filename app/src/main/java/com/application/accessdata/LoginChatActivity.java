package com.application.accessdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.application.accessdata.preferences.UserPrefrences;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginChatActivity extends AppCompatActivity implements View.OnClickListener {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String API_LOGIN = "http://192.168.1.53:8080/api/users";

    private Button mButtonLogin;
    private EditText mInputUserName, mInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_chat);
        gotoChatScreen(UserPrefrences.getInstance(this.getApplicationContext()).getToken());

        initView();
        initEvent();
    }

    private void initView() {
        mButtonLogin = (Button) findViewById(R.id.btn_login);
        mInputUserName = (EditText) findViewById(R.id.input_user_name);
        mInputPassword = (EditText) findViewById(R.id.input_password);
    }

    private void initEvent() {
        mButtonLogin.setOnClickListener(this);
    }

    private void gotoChatScreen(String token) {
        if (token != null && token != "") {
            Intent intent = new Intent(LoginChatActivity.this, ChatActivity.class);
            startActivity(intent);
        }
    }

    private void requestLogin() throws IOException {
        String userName = mInputUserName.getText().toString();
        String password = mInputPassword.getText().toString();

        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("user_name", userName)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url(API_LOGIN)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String responseData = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(responseData);
                    if (jsonObject.has("token") && jsonObject.getString("token") != "") {
                        String tokenGet = jsonObject.getString("token");
                        UserPrefrences.getInstance(LoginChatActivity.this.getApplicationContext()).setToken(tokenGet);

                        LoginChatActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String token = UserPrefrences.getInstance(LoginChatActivity.this.getApplicationContext()).getToken();
                                gotoChatScreen(token);
                            }
                        });
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        gotoChatScreen(UserPrefrences.getInstance(this.getApplicationContext()).getToken());
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                try {
                    requestLogin();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }
    }

}