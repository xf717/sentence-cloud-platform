package com.db.chaomaxs.core.blacklist;

import com.db.chaomaxs.core.Config;
import io.rong.methods.user.blacklist.Blacklist;
import io.rong.models.user.UserModel;
import org.springframework.stereotype.Service;

/**
 * @author momo
 * @date 2021-04-01 18:50
 */
@Service
public class BlackService {

    private Blacklist blackList = Config.rongCloud.user.blackList;

    public void add(String blackUserId, String id) {
        UserModel blackUser = (new UserModel()).setId(blackUserId);
        UserModel[] blacklist = new UserModel[]{blackUser};
        UserModel user = new UserModel();
        user.setId(id);
        user.setBlacklist(blacklist);

        try {
            blackList.add(user);
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }

    public void remove(String blackUserId, String id) {
        UserModel blackUser = (new UserModel()).setId(blackUserId);
        UserModel[] blacklist = new UserModel[]{blackUser};
        UserModel user = new UserModel();
        user.setId(id);
        user.setBlacklist(blacklist);

        try {
            blackList.remove(user);
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }
}
