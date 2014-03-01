package baidulocationsdk.demo;

/**
 * 用户位置信息.
 */
public class UserLocation {

	/** 定位时间 */
	private String locationTime;
	/** 定位类型 */
	private int locType;
	/** 纬度坐标 */
	private double latitude;
	/** 经度坐标 */
	private double longitude;
	/** 定位精度 */
	private float radius;

    /**
     * 数据初始化
     */
    public void clear(){
        locationTime=null;
        locType=0;
        latitude=0;
        longitude=0;
        radius=0;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer(256);
        sb.append("定位时间 : ");
        sb.append(locationTime);
        sb.append("\n定位类型 : ");
        sb.append(locType);
        sb.append("\n纬度坐标 : ");
        sb.append(latitude);
        sb.append("\n经度坐标 : ");
        sb.append(longitude);
        sb.append("\n定位精度 : ");
        sb.append(radius);
        return sb.toString();
    }

	public String getLocationTime() {
		return locationTime;
	}

	public void setLocationTime(String locationTime) {
		this.locationTime = locationTime;
	}

	public int getLocType() {
		return locType;
	}

	public void setLocType(int locType) {
		this.locType = locType;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
}
