package online.zhaopei.myproject.domain.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class DatatablePara implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8590097649128658175L;

	private String draw;
	
	private Integer start;
	
	private Integer length;
	
	private Map<String, String> search;
	
//	private List<Map<String, Object>> columns;
	
	private List<Map<String, String>> order;

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Map<String, String> getSearch() {
		return search;
	}

	public void setSearch(Map<String, String> search) {
		this.search = search;
	}

//	public List<Map<String, Object>> getColumns() {
//		return columns;
//	}
//
//	public void setColumns(List<Map<String, Object>> columns) {
//		this.columns = columns;
//	}

	public List<Map<String, String>> getOrder() {
		return order;
	}

	public void setOrder(List<Map<String, String>> order) {
		this.order = order;
	}

}
