package me.fr.appli_de_ouf;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Antoine Croisille on 22/05/2017.
 */

public class Row_Content_Adapter extends ArrayAdapter<Row_Content> {

    public Row_Content_Adapter(Context context, List<Row_Content> contents){
        super(context,0,contents);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_content,parent, false);
        }

        Row_Content_ViewHolder viewHolder = (Row_Content_ViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new Row_Content_ViewHolder();
            //récupérer nos sous vues
            viewHolder.label = (TextView)  convertView.findViewById(R.id.content_title);
            viewHolder.description = (TextView) convertView.findViewById(R.id.content_text);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img_content);
            convertView.setTag(viewHolder);
        }

        Row_Content rc = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.label.setText(rc.getLabel());
        viewHolder.description.setText(rc.getDescription());
        viewHolder.img.setImageDrawable(new ColorDrawable(Color.parseColor(rc.getImg())));

        return convertView;
    }

    private class Row_Content_ViewHolder{
        public TextView label;
        public TextView description;
        public ImageView img;
    }
}
