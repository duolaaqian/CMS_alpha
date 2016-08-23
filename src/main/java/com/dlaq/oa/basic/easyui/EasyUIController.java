package com.dlaq.oa.basic.easyui;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.webframe.web.page.ValueList;
import org.webframe.web.page.ValueListInfo;
import org.webframe.web.util.ValueListUtils;

import com.dlaq.oa.basic.core.BaseController;

@Controller
@RequestMapping("/oa-basic/easyui")
public class EasyUIController extends BaseController{

	
	@RequestMapping("/loadDatagrid")
	public String loadDatagrid(HttpServletRequest request, HttpServletResponse response) {
//		ValueListUtils.reloadValueListSpringContext();//刷新valuelist，测试用
		Map<String, Object> map = ValueListUtils.getQueryMap(request);
		String key = map.get("key")+""; 
		ValueList<?> valueList = getValueListResult(key, map);
		JSONObject jsonObj = new JSONObject();
//		jsonObj.put("total", valueList.getValueListInfo().getTotalNumberOfEntries());
		jsonObj.put("total", valueList.getValueListInfo().getTotalNumbers());
		jsonObj.put("rows", valueList.getList());
		outWriteJSON(response, jsonObj.toString());
		return null;
	}
	/**
	 * @function:
	 * 		easyui datagrid 分页
	 * @author luqian  
	 *	Sep 24, 2015 2:08:03 PM
	 */
	protected ValueList<?> getValueListResult(String adapter, Map<String, Object> map) {
/*		// 每页显示行数
		String rows = StringUtils.isNumeric(map.get("rows")+"")?map.get("rows")+"":"20";
		// 当前页数
		String page = StringUtils.isNumeric(map.get("page")+"")?map.get("page")+"":"1";
		
		ValueListInfo info = new ValueListInfo(map);
		info.setPagingNumberPer(Integer.parseInt(rows));
		info.setPagingPage(Integer.parseInt(page));
		return ValueListUtils.getValueList(adapter, info);*/
		
		// 每页显示行数
		String rows = StringUtils.isNumeric(map.get("rows")+"")?map.get("rows")+"":"20";
		// 当前页数
		String page = StringUtils.isNumeric(map.get("page")+"")?map.get("page")+"":"1";
		
		ValueListInfo info = new ValueListInfo();
		info.setPagingNumberPer(Integer.parseInt(rows));
		info.setPagingPage(Integer.parseInt(page));
		
		return ValueListUtils.getValueList(adapter,  info);
	}
	
}
