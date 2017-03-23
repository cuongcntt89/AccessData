package com.application.accessdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.application.accessdata.utils.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButtonSend;
    private EditText mInputMessage;
    private ListView mListChat;
    private ArrayList<String> listChat = null;
    private ArrayAdapter listChatAdapter = null;

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
        mListChat = (ListView) findViewById(R.id.list_chat);

        // Init event
        mButtonSend.setOnClickListener(this);

        listChat = new ArrayList<>();
        listChatAdapter = new ArrayAdapter(ChatActivity.this, android.R.layout.simple_list_item_1, listChat);
        mListChat.setAdapter(listChatAdapter);

        mSocket.connect();
        mSocket.on("result", listener);
    }

    private Emitter.Listener listener = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    try {
                        String content = data.getString("content");
                        listChat.add(content);
                        listChatAdapter.notifyDataSetChanged();
                        mInputMessage.setText("");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };

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