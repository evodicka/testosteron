package org.kuhlins.app.testosteron.model;

import java.util.ArrayList;
import java.util.List;

public class AppInfo {
	
	private List<KeyVal> basics = new ArrayList<>();
	private List<KeyVal> mems = new ArrayList<>();
	
	public List<KeyVal> getBasics() {
		return basics;
	}
	
	public void setBasics(List<KeyVal> basics) {
		this.basics = basics;
	}
	
	public void addBasic(KeyVal kv) {
		this.basics.add(kv);
	}
	
	public List<KeyVal> getMems() {
		return mems;
	}
	
	public void setMems(List<KeyVal> mems) {
		this.mems = mems;
	}
	
	public void addMem(KeyVal kv) {
		this.mems.add(kv);
	}
	
}
