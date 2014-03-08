package com.clearpool.kodiak.feedlibrary.mbeans;

import com.clearpool.commonserver.mbean.MBeanMethodDescription;

public interface ImbalanceCacheMgmtMBean extends IMdServiceCacheMgmt
{
	@MBeanMethodDescription("Republish all data for all symbols in cache")
	public String publishAllData();
}