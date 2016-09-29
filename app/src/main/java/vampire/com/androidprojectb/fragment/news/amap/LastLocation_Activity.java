/**
 *
 */
package vampire.com.androidprojectb.fragment.news.amap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;

import vampire.com.androidprojectb.R;

/**
 * 最后位置功能演示
 *
 * @author hongming.wang
 * @创建时间：2016年1月7日 下午4:36:22
 * @项目名称： AMapLocationDemo2.x
 * @文件名称：LastLocation_Activity.java
 * @类型名称：LastLocation_Activity
 * @since 2.3.0
 */
public class LastLocation_Activity extends Activity implements OnClickListener {
    private Button btnLastLoc;
    private AMap aMap;
    private AMapLocationClient locationClient = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastlocation);
        setTitle(R.string.title_lastLocation);
        btnLastLoc = (Button) findViewById(R.id.bt_lastLoc);
        btnLastLoc.setOnClickListener(this);
        locationClient = new AMapLocationClient(this.getApplicationContext());


        MapView mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        aMap = mapView.getMap();


        //aMap.setTrafficEnabled(true);// 显示实时交通状况
        //地图模式可选类型：MAP_TYPE_NORMAL,MAP_TYPE_SATELLITE,MAP_TYPE_NIGHT
        aMap.setMapType(AMap.MAP_TYPE_NORMAL);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != locationClient) {
            locationClient.onDestroy();
            locationClient = null;
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_lastLoc) {
            AMapLocation location = locationClient.getLastKnownLocation();
            String result = Utils.getLocationStr(location);
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();

            CameraUpdate cameraUpdate =
                    CameraUpdateFactory.newCameraPosition(
                            new CameraPosition(
                                    new LatLng(
                                            location.getLatitude(),
                                            location.getLongitude()),
                                    18,
                                    30,
                                    0));
            aMap.moveCamera(cameraUpdate);

//            MarkerOptions markerOptions = new MarkerOptions();
//            //添加一个位置--经度，维度---marker对应一个markerOptions，用来设置marker的属性等
//            markerOptions.position(new LatLng((float) location.getLatitude(),
//                    (float) location.getLongitude()));
//            //添加图标
//            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
//            //添加marker
//            Marker marker = aMap.addMarker(markerOptions);
//            marker.setAnchor((float) location.getLatitude(),
//                    (float) location.getLongitude());
        }
    }
}
