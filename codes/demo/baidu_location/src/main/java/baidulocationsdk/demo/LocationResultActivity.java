package baidulocationsdk.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 14-2-27.
 */
public class LocationResultActivity extends Activity implements View.OnClickListener{

    private TextView mLocationResult;
    private Button mEndTestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.location_result_activity);
        mLocationResult = (TextView) findViewById(R.id.location_result);
        ((LocationApplication)getApplication()).mLocationResult = mLocationResult;

        mEndTestBtn = (Button) findViewById(R.id.end_test_demo);
        mEndTestBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ((LocationApplication)getApplication()).mLocationClient.stop();
        this.finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ((LocationApplication)getApplication()).mLocationClient.stop();
            this.finish();
        }
        return true;
    }

}
