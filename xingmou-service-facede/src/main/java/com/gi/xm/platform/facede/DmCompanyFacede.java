package com.gi.xm.platform.facede;


import java.util.List;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.DmCompanyInfo;
import com.gi.xm.platform.view.DmCompanyQueryInfo;

public interface DmCompanyFacede {

    MessageInfo<Integer> deleteDmCompany(Long id);
		
    MessageInfo<Long> createDmCompany(DmCompanyInfo dmCompanyInfo);
		
	MessageInfo<Integer> updateDmCompany(DmCompanyInfo dmCompanyInfo);
		
	MessageInfo<DmCompanyInfo> getDmCompany(Long id);
		
    MessageInfo<List<DmCompanyInfo>> getAllDmCompany();
			
    MessageInfo<QueryResultInfo<DmCompanyInfo>> queryDmCompany(DmCompanyQueryInfo dmCompanyQueryInfo);
	
	

}