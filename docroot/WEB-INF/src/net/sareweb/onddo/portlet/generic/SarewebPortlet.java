package net.sareweb.onddo.portlet.generic;

import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class SarewebPortlet extends MVCPortlet {
	protected Log _log;
	protected ThemeDisplay themeDisplay;
	
	public SarewebPortlet() {
		_log = LogFactoryUtil.getLog(this.getClass());
		
	}
	
	public void savePreferences(ActionRequest request, ActionResponse response) throws Exception {
		_log.debug("Saving preferences");
		prefs = request.getPreferences();
		
		Enumeration<String> params = request.getParameterNames();
		
		while (params.hasMoreElements()){
			String prefName = (String)params.nextElement();
			if(prefName.startsWith("PREF_")){
				_log.debug("updating " + prefName);
				String prefValue= request.getParameter(prefName);
				if(prefValue!=null)prefs.setValue(prefName, prefValue);
			}
		}
		prefs.store();
	}
	
	
	public static final String PARAM_RES_TYPE="PARAM_RES_TYPE";
	public static final String PARAM_RES_ID="PARAM_RES_ID";
	public static final String RES_TYPE_HTML="RES_TYPE_HTML";
	public static final String RES_TYPE_JSON="RES_TYPE_JSON";
	public static final String RES_TYPE_FILE="RES_TYPE_FILE";
	
	protected PortletPreferences prefs;
}
