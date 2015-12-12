package com.example.leon.polylines.fragment;

import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.example.leon.polylines.R;
import com.example.leon.polylines.content.Locations;
import com.example.leon.polylines.loader.LocationLoader;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

/**
 * Created by Leon on 11.12.2015.
 */
public class GpsMap extends MapFragment implements LoaderManager.LoaderCallbacks<Cursor> {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(R.id.location_loader, Bundle.EMPTY, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if (R.id.location_loader == id) {
            return new LocationLoader(getActivity().getApplicationContext());
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (R.id.location_loader == loader.getId()) {
            final ArrayList<LatLng> locations = new ArrayList<>();
            if (cursor.moveToFirst()) {
                do {
                    LatLng latLng = new LatLng(
                            cursor.getDouble(cursor.getColumnIndex(Locations.Columns.LATITUDE)),
                            cursor.getDouble(cursor.getColumnIndex(Locations.Columns.LONGITUDE))
                    );
                    locations.add(latLng);
                } while (cursor.moveToNext());
                getMap().addPolyline(new PolylineOptions().addAll(locations));
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

}
