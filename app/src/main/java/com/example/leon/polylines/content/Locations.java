package com.example.leon.polylines.content;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.leon.polylines.sqlite.SQLiteProvider;

/**
 * Created by Leon on 11.12.2015.
 */
public class Locations {

    public static final String TABLE = "locations";

    public static final Uri URI = Uri.parse("content://" + SQLiteProvider.AUTHORITY + "/" + TABLE);

    public static interface Columns extends BaseColumns {
        String LONGITUDE = "longitude";
        String LATITUDE = "latitude";
    }

}
