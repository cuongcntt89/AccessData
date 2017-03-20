package com.application.accessdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.application.accessdata.utils.Constants;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButtonSend;
    private EditText mInputMessage;

    private Socket mSocket;

    {
        try {
            mSocket = IO.socket(Constants.CHAT_SERVER_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getmSocket() {
        return this.mSocket;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Init view
        mButtonSend = (Button) findViewById(R.id.btn_send);
        mInputMessage = (EditText) findViewById(R.id.content_chat);

        // Init event
        mButtonSend.setOnClickListener(this);

        mSocket.connect();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                sendMessage();
                break;
        }
    }

    private void sendMessage() {
        String message = mInputMessage.getText().toString().trim();
        getmSocket().emit("client-send-message", message);
    }
}