package com.github.xf717.core.user;

import com.github.xf717.core.Config;
import io.rong.RongCloud;
import io.rong.models.Result;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;
import org.springframework.stereotype.Service;

/**
 * @author momo
 * @date 2021-04-01 18:39
 */
@Service
public class UserService {
    public String register(String id, String name, String portrait) {
        UserModel user = new UserModel(id, name, portrait);
        TokenResult result = null;

        try {
            result = Config.rongCloud.user.register(user);
        } catch (Exception var7) {
            var7.printStackTrace();
        }
        return result.getToken();
    }

    public Result update(String id, String name, String portrait) {
        UserModel user = new UserModel(id, name, portrait);
        Result result = null;

        try {
            result = Config.rongCloud.user.update(user);
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return result;
    }
}
