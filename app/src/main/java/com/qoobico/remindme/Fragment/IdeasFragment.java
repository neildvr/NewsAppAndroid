package com.qoobico.remindme.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qoobico.remindme.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.infowindow.InfoWindow;
import org.osmdroid.views.overlay.mylocation.SimpleLocationOverlay;

/**
 * Created by neil on 4/12/2016.
 */
public class IdeasFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_idea;


    int stats=0;
    private MapView mapView;
    private IMapController mapController;
    private SimpleLocationOverlay mMyLocationOverlay;
    private ScaleBarOverlay mScaleBarOverlay;
    ItemizedIconOverlay<OverlayItem> currentLocationOverlay;


    private Context context;
    private String title;

    private View view;

    public static IdeasFragment getInstance(Context context){
        Bundle args = new Bundle();
        IdeasFragment fragment = new IdeasFragment();
        fragment.setArguments(args);

        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tap_item_ideas));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);


        

        MapView map = (MapView) view.findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        IMapController mapController = map.getController();
        mapController.setZoom(9);
        GeoPoint startPoint = new GeoPoint(42.52, 74.34);
        mapController.setCenter(startPoint);

        final Marker startMarker = new Marker(map);
        startMarker.setPosition(new GeoPoint(42.52, 74.34));
        //startMarker.setIcon(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
        startMarker.setAnchor(Marker.ANCHOR_CENTER, 1.0f);
        final InfoWindow infoWindow = new MyInfoWindow(R.layout.bonuspack_bubble, map);
        startMarker.setInfoWindow(infoWindow);
        map.getOverlays().add(startMarker);
        startMarker.setTitle("Title of the marker");
        map.invalidate();





        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}
