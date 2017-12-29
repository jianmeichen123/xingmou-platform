package com.gi.ctdn.dao.me;

import com.gi.ctdn.pojo.me.UserCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zcy on 17-12-5.
 */

public interface UserCollectionDAO {

    public int insertOne(UserCollection userCollection);

    public int deleteOne(UserCollection userCollection);

    public List<UserCollection> selectCountByUserCode(@Param("userCode") String userCode);

    public List<String> selectCodesByUT (@Param("userCode") String userCode,@Param("type") Integer type);

    public UserCollection selectByCodeAndTypeAndUsercode(UserCollection userCollection);

}
