package freeride.communicate.protocol.json;

import com.zyt.communicate.common.json.IReqBody;

/**
 * Created by Administrator on 14-2-22.
 */
public class LoginReqBody implements IReqBody {

    private String loginName;
    private String password;
    private String mobile;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
