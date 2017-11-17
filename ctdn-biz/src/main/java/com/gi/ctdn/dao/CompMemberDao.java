package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.CompMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wanghao on 17-11-15.
 */
public interface CompMemberDao {
    List<CompMember> selectCompMembers(@Param("compCode") String compCode);
}
