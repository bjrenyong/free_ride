package baidulocationsdk.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

public class LocationMainActivity extends Activity implements View.OnClickListener {

	private static final String TAG = LocationMainActivity.class.getSimpleName();

	Button btSingle;
	Button btContinue;
	private LocationClient mLocClient;

	/**
	 * Called when the activity is first created.
	 * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this
	 *            Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise
	 *            it is null.</b>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLocClient = ((LocationApplication) getApplication()).mLocationClient;
		btSingle = (Button) this.findViewById(R.id.bt_single);
		btSingle.setOnClickListener(this);
		btContinue = (Button) this.findViewById(R.id.bt_continue);
		btContinue.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == btSingle) {
			setLocationOption(true);
			mLocClient.start();
            //对于方法requestLocation的理解：只有当LocationClient的状态是started时，requestLocation方法才有用
            //相当于触发了一次定位查询请求
//			if (mLocClient.isStarted()) {
//				mLocClient.requestLocation();
//			} else {
//				Toast.makeText(this, "发起单次定期请求失败", 0).show();
//				return;
//			}
			// 跳转到显示结果界面
			Intent intent = new Intent(this, LocationResultActivity.class);
			startActivity(intent);
		} else {
			setLocationOption(false);
			mLocClient.start();
			// 跳转到显示结果界面
			Intent intent = new Intent(this, LocationResultActivity.class);
			startActivity(intent);
		}
	}

	private void setLocationOption(boolean isSingle) {
		LocationClientOption option = new LocationClientOption();
		// 4.0与4.1在配置参数上有差异
		// //////////////////////////////////////////////////////////////////////////
		// 4.0配置开始
		// 优先级：精确度优先
		option.setPriority(LocationClientOption.GpsFirst);
		option.setCoorType("bd09ll"); // 返回的定位结果是百度经纬度，默认值gcj02
        option.setServiceName("com.baidu.location.service_v2.9");
		option.setAddrType("all"); // 返回的定位结果包含地址信息
		if (isSingle) {
			// scanSpan设置为无效值即可（<1000）
			option.setScanSpan(0);
		} else {
            //连续定位，间隔30秒
			option.setScanSpan(30000);
		}
        // 4.0配置结束
        // //////////////////////////////////////////////////////////////////////////
		mLocClient.setLocOption(option);
	}
}
