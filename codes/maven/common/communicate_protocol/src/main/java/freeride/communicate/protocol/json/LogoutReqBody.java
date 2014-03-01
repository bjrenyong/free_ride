package freeride.communicate.protocol.json;

import com.zyt.communicate.common.json.IReqBody;

/**
 * Created by Administrator on 14-2-22.
 */
public class LogoutReqBody implements IReqBody {
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
