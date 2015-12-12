package com.example.leon.polylines.loader;

import android.content.Context;
import android.content.CursorLoader;

import com.example.leon.polylines.content.Locations;

/**
 * Created by Leon on 12.12.2015.
 */
public class LocationLoader extends CursorLoader {

    public LocationLoader(Context context) {
        super(context, Locations.URI, null, null, null, null);
    }

}
