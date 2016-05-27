package com.qoobico.remindme.Fragment;

import android.widget.Button;
import android.widget.TextView;

import com.qoobico.remindme.R;

import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.infowindow.InfoWindow;

public class MyInfoWindow extends InfoWindow {
    public MyInfoWindow(int layoutResId, MapView mapView) {
        super(layoutResId, mapView);
    }
    public void onClose() {
    }

    public void onOpen(Object arg0) {
        Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
        TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
        TextView txtDescription;
        txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
        TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

        txtTitle.setText("Title of the marker");
        txtDescription.setText("Description of the marker");
        txtSubdescription.setText("And subdescription");
    }
}