package me.fr.appli_de_ouf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Menu_Principal extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__principal);

        final Button choix_exo_btn = (Button) findViewById(R.id.choix_exo_btn);
        choix_exo_btn.setOnClickListener(this);

        final Button travailler_coup_btn = (Button) findViewById(R.id.travailler_coup_btn);
        travailler_coup_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.choix_exo_btn:
                intent = new Intent(this, Choix_Exercice.class);
                intent.putExtra("minrep","mnt");
                startActivity(intent);
                break;
            case R.id.travailler_coup_btn:
                intent = new Intent(this,Choix_Exercice.class);
                intent.putExtra("minrep","rpt");
                startActivity(intent);
                break;
        }
    }
}
