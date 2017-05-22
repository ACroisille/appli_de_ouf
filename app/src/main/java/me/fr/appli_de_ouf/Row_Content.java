package me.fr.appli_de_ouf;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Antoine Croisille on 22/05/2017.
 */

public class Row_Content {
    private String img;
    private String label;
    private String description;

    public Row_Content(String label, String description, String img){
        this.label = label;
        this.description = description;
        this.img = img;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }
}
