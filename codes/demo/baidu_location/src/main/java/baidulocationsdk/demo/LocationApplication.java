package baidulocationsdk.demo;

import android.app.Application;
import android.util.Log;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;

import java.util.Date;

/**
 * Created by Administrator on 14-2-27.
 */
public class LocationApplication extends Application {
    private static final String TAG=LocationApplication.class.getSimpleName();
    //定位服务的客户端，因为是配置信息，放在Application中比较合适
    public LocationClient mLocationClient;
    private MyLocationListener mMyLocationListener;
    //用户位置信息
    public UserLocation userLocation;
    //显示结果信息的控件
    public TextView mLocationResult;

    @Override
    public void onCreate() {
        super.onCreate();
        userLocation=new UserLocation();
        mLocationClient = new LocationClient(this);
        //AK和应用签名包名绑定
        //mLocationClient.setAK("8YIqS8pkattbIdsH2xgoEqLG");
        mMyLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(mMyLocationListener);
    }

    /**
     * 显示请求字符串
     * @param str
     */
    public void logMsg(String str) {
        try {
            if (mLocationResult != null){
                mLocationResult.setText(str);
                Log.d(TAG, str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            userLocation.clear();
            userLocation.setLocationTime(bdLocation.getTime());
            userLocation.setLocType(bdLocation.getLocType());
            userLocation.setLatitude(bdLocation.getLatitude());
            userLocation.setLongitude(bdLocation.getLongitude());
            userLocation.setRadius(bdLocation.getRadius());
            String logMsg="日志时间 : "+new Date()+"\n"+userLocation.toString();
            logMsg(logMsg);
        }

        @Override
        public void onReceivePoi(BDLocation bdLocation) {

        }
    }
}
