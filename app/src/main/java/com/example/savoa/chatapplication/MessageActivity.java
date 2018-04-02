package com.example.savoa.chatapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    Button logout, send;
    EditText message;
    ListView list;
    final MessageAdapter adapter = new MessageAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        logout = findViewById(R.id.logout_from_chat);
        logout.setOnClickListener(this);

        send = findViewById(R.id.send);
        send.setEnabled(false);
        send.setOnClickListener(this);

        message = findViewById(R.id.message);
        message.addTextChangedListener(this);

        list = findViewById(R.id.message_list_ID);
        TextView contact_name = findViewById(R.id.contact_name_ID);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("contact_name");
        contact_name.setText(name);

        adapter.AddCharacter(new CustomMessage(getResources().getString(R.string.message1).toString(), true));
        adapter.AddCharacter(new CustomMessage(getResources().getString(R.string.message2).toString(), false));
        adapter.AddCharacter(new CustomMessage(getResources().getString(R.string.message3).toString(), true));
        adapter.AddCharacter(new CustomMessage(getResources().getString(R.string.message4).toString(), false));
        adapter.AddCharacter(new CustomMessage(getResources().getString(R.string.message5).toString(), true));
        adapter.AddCharacter(new CustomMessage(getResources().getString(R.string.message6).toString(), false));
        adapter.AddCharacter(new CustomMessage(getResources().getString(R.string.message7).toString(), true));

        //ListView list = (ListView) findViewById(R.id.message_list_ID);
        list.setAdapter(adapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                CustomMessage item = (CustomMessage) adapter.getItem(position);
                adapter.RemoveCharacter(item);
                adapter.notifyDataSetChanged();
                return true;
            }
        });


    }

    @Override
    public void onClick(View view) {
        Intent intent;

        if (view.getId() == R.id.logout_from_chat) {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.send){

            Context context = getApplicationContext();
            CharSequence toast_text = "Message is sent!";
            int duration = Toast.LENGTH_SHORT;
            String text = message.getText().toString();
            adapter.AddCharacter(new CustomMessage(text,false));
            Toast toast = Toast.makeText(context,toast_text,duration);
            toast.show();
            message.setText("");

        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if (message.getText().toString().length() != 0){

            send.setEnabled(true);

        }
        else{

            send.setEnabled(false);

        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
