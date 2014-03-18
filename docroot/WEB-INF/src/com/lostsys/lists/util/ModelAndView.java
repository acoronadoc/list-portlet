package com.lostsys.lists.util;

import java.util.Map;

public class ModelAndView {
	Map map=null;
	String page="view";

	public ModelAndView( String page, Map map ) {  
		this.page=page;
		this.map=map;
		}	

	public Map getMap() { return map; }
	public String getPage() { return page; }

	}
