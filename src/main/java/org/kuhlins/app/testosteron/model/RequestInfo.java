package org.kuhlins.app.testosteron.model;

import java.util.ArrayList;
import java.util.List;

public class RequestInfo {
	
	private List<KeyVal> basics = new ArrayList<>();
	private List<KeyVal> headers = new ArrayList<>();
	
	public List<KeyVal> getBasics() {
		return basics;
	}
	
	public void setBasics(List<KeyVal> basics) {
		this.basics = basics;
	}
	
	public List<KeyVal> getHeaders() {
		return headers;
	}
	
	public void setHeaders(List<KeyVal> headers) {
		this.headers = headers;
	}
	
	public void addBasic(KeyVal kv) {
		this.basics.add(kv);
	}
	
	public void addHeader(KeyVal kv) {
		this.headers.add(kv);
	}
	
}
