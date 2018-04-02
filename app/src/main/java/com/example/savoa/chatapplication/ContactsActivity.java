package com.example.savoa.chatapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class ContactsActivity extends AppCompatActivity implements View.OnClickListener {

    Button logout;
    ImageView chat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        chat = findViewById(R.id.show_chat);

        CharacterAdapter adapter = new CharacterAdapter(this);

        adapter.addCharacter(new Custom((Character)getString(R.string.savo_dragovic).charAt(0),
                getString(R.string.savo_dragovic),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));
        adapter.addCharacter(new Custom((Character)getString(R.string.marko_markovic).charAt(0),
                getString(R.string.marko_markovic),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));
        adapter.addCharacter(new Custom((Character)getString(R.string.srdjan_usorac).charAt(0),
                getString(R.string.srdjan_usorac),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));
        adapter.addCharacter(new Custom((Character)getString(R.string.igor_ilic).charAt(0),
                getString(R.string.igor_ilic),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));
        adapter.addCharacter(new Custom((Character)getString(R.string.nikola_percevic).charAt(0),
                getString(R.string.nikola_percevic),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));
        adapter.addCharacter(new Custom((Character)getString(R.string.vladimir_spasojevic).charAt(0),
                getString(R.string.vladimir_spasojevic),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));
        adapter.addCharacter(new Custom((Character)getString(R.string.arien_roben).charAt(0),
                getString(R.string.arien_roben),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));
        adapter.addCharacter(new Custom((Character)getString(R.string.diego_forlan).charAt(0),
                getString(R.string.diego_forlan),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));
        adapter.addCharacter(new Custom((Character)getString(R.string.petar_petrovic).charAt(0),
                getString(R.string.petar_petrovic),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));
        adapter.addCharacter(new Custom((Character)getString(R.string.van_persi).charAt(0),
                getString(R.string.van_persi),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));
        adapter.addCharacter(new Custom((Character)getString(R.string.dejan_savicevic).charAt(0),
                getString(R.string.dejan_savicevic),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));
        adapter.addCharacter(new Custom((Character)getString(R.string.ola_solskjer).charAt(0),
                getString(R.string.ola_solskjer),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));
        adapter.addCharacter(new Custom((Character)getString(R.string.oleg_blohin).charAt(0),
                getString(R.string.oleg_blohin),
                getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp)));




        ListView list = (ListView) findViewById(R.id.contacts_list);
        list.setAdapter(adapter);

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent;

        if (view.getId() == R.id.logout) {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
