package edylso.testemapa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.net.URL;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng city = new LatLng(-15.836, -48.107);
        LatLng spettus = new LatLng(-15.841, -48.106);

        try {
            //URL url = new URL("C:\\Users\\edylso\\Pictures\\trinca1.jpg");
            //Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

            /*Picasso.with(this).load("http://megaicons.net/static/img/icons_sizes/8/178/256/catering-bar-icon.png").into(new Target() {
                @Override
                public void onBitmapLoaded (final Bitmap bitmap, Picasso.LoadedFrom from){
                   Bitmap b = bitmap;
                }

                @Override
                public void onBitmapFailed(Drawable errorDrawable) {

                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {

                }
            });*/
            File imgFile = new File("C:\\Imgem\\trinca1.jpg");//"C:\\\\Imagem\\trinca1.jpg");

            if (imgFile.exists()) {
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

                mMap.addMarker(new MarkerOptions().position(city).title("Marker in Ceilândia"));
                mMap.addMarker(new MarkerOptions().position(spettus)
                        .title("Spettus Drink")
                        .icon(BitmapDescriptorFactory.fromBitmap(myBitmap)));
                mMap.moveCamera(CameraUpdateFactory.zoomBy(3));//(CameraUpdateFactory.newLatLng(city));

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(city, 16.0f));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
