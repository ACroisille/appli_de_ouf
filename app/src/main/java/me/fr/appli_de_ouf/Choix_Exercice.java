package me.fr.appli_de_ouf;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Choix_Exercice extends AppCompatActivity {

    private ListView list_exercices;
    private String MinorRep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_exercice);

        list_exercices = (ListView) findViewById(R.id.exo_list);

        this.MinorRep = this.getIntent().getStringExtra("minrep");

        List<Row_Content> contents = this.genererExercices();

        Row_Content_Adapter rca = new Row_Content_Adapter(this,contents);
        this.list_exercices.setAdapter(rca);

        this.list_exercices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(Choix_Exercice.this,Number_Picker.class);
                intent.putExtra("titre",((TextView)view.findViewById(R.id.content_title)).getText());
                intent.putExtra("description",((TextView)view.findViewById(R.id.content_text)).getText());

                ImageView imageView = (ImageView) view.findViewById(R.id.img_content);
                imageView.buildDrawingCache();
                Bitmap image = imageView.getDrawingCache();
                intent.putExtra("image",image);

                intent.putExtra("minrep",Choix_Exercice.this.MinorRep);

                startActivity(intent);
            }
        });

    }

    private  List<Row_Content> genererExercices(){
        List<Row_Content> contents = new ArrayList<Row_Content>();
        switch (this.MinorRep){
            case "rpt" :
                contents.add(new Row_Content("Coup1","Description1","#4286f4"));
                contents.add(new Row_Content("Coup2","Description2","#f441d6"));
                contents.add(new Row_Content("Coup3","Description3","#3dba18"));
                break;
            case "mnt" :
                contents.add(new Row_Content("Exercice1","Description1","#4286f4"));
                contents.add(new Row_Content("Exercice2","Description2","#f441d6"));
                contents.add(new Row_Content("Exercice3","Description3","#3dba18"));
                break;
        }
        return  contents;
    }
}
