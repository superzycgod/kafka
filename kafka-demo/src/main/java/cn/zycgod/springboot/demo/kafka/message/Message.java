package cn.zycgod.springboot.demo.kafka.message;

import java.io.Serializable;
import java.util.Map;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String context;
	private Map<String, Object> props;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Map<String, Object> getProps() {
		return props;
	}

	public void setProps(Map<String, Object> props) {
		this.props = props;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", context=" + context + ", props=" + props + "]";
	}

}
