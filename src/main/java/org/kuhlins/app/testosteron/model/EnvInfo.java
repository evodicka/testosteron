package org.kuhlins.app.testosteron.model;

import java.util.ArrayList;
import java.util.List;

public class EnvInfo {
	
	private List<KeyVal> props = new ArrayList<>();
	private List<KeyVal> envs = new ArrayList<>();
	
	public List<KeyVal> getProps() {
		return props;
	}
	
	public void setProps(List<KeyVal> props) {
		this.props = props;
	}
	
	public List<KeyVal> getEnvs() {
		return envs;
	}
	
	public void setEnvs(List<KeyVal> envs) {
		this.envs = envs;
	}
	
	public void addProp(KeyVal kv) {
		this.props.add(kv);
	}
	
	public void addEnv(KeyVal kv) {
		this.envs.add(kv);
	}
	
}
