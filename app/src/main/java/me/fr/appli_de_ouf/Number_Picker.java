package me.fr.appli_de_ouf;

import android.content.Intent;
import android.content.SyncStatusObserver;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class Number_Picker extends AppCompatActivity {

    private String MinorRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numer__picker);

        ImageView image = (ImageView) findViewById(R.id.content_img);
        image.setImageBitmap((Bitmap) this.getIntent().getParcelableExtra("image"));

        TextView content_title = (TextView) findViewById(R.id.content_title);
        content_title.setText(this.getIntent().getStringExtra("titre"));

        TextView content_description = (TextView) findViewById(R.id.content_description);
        content_description.setText(this.getIntent().getStringExtra("description"));

        TextView minrep_txt = (TextView) findViewById(R.id.minrep_txt);
        this.MinorRep = this.getIntent().getStringExtra("minrep");
        Log.v("Min or Rep", this.MinorRep);
        if( this.MinorRep.equals("mnt")){
            minrep_txt.setText("Minutes");
        }
        else if( this.MinorRep.equals("rpt")){
            minrep_txt.setText("Répetitions");
        }

        Button lancer = (Button) findViewById(R.id.lancer_btn);
        lancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Number_Picker.this,Timer.class);
                intent.putExtra("titre",((TextView) Number_Picker.this.findViewById(R.id.content_title)).getText());
                intent.putExtra("description",((TextView) Number_Picker.this.findViewById(R.id.content_description)).getText());

                ImageView imageView = (ImageView) Number_Picker.this.findViewById(R.id.content_img);
                imageView.buildDrawingCache();
                Bitmap image = imageView.getDrawingCache();
                intent.putExtra("image",image);

                //((NumberPicker) Number_Picker.this.findViewById(R.id.numberPicker)).getValue()
                intent.putExtra("minrep",Number_Picker.this.MinorRep);
                intent.putExtra("picked",2);

                startActivity(intent);
            }
        });

    }
}
