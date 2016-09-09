package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.PostionInfo;
import com.gi.xm.platform.view.PostionQueryInfo;

public interface PostionFacede {
		MessageInfo<Integer> deletePostion(Long id);
		
    MessageInfo<Long> createPostion(PostionInfo postionInfo);
		
	MessageInfo<Integer> updatePostion(PostionInfo postionInfo);
		
	MessageInfo<PostionInfo> getPostion(Long id);
		
    MessageInfo<List<PostionInfo>> getAllPostion();
			
    MessageInfo<QueryResultInfo<PostionInfo>> queryPostion(PostionQueryInfo postionQueryInfo);
	
	

}