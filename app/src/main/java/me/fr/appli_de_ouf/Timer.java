package me.fr.appli_de_ouf;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Timer extends AppCompatActivity {

    private String MinorRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        ImageView image = (ImageView) findViewById(R.id.content_img);
        image.setImageBitmap((Bitmap) this.getIntent().getParcelableExtra("image"));

        TextView content_title = (TextView) findViewById(R.id.content_title);
        content_title.setText(this.getIntent().getStringExtra("titre"));

        TextView content_description = (TextView) findViewById(R.id.content_description);
        content_description.setText(this.getIntent().getStringExtra("description"));

        this.MinorRep = this.getIntent().getStringExtra("minrep");

        TextView minrep_txt = (TextView) findViewById(R.id.time_txt);
        minrep_txt.setText(Integer.toString(this.getIntent().getIntExtra("picked",0)));

        Button stop_btn = (Button) this.findViewById(R.id.stop_btn);
        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
