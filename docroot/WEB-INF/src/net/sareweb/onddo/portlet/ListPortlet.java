package net.sareweb.onddo.portlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.omg.CORBA.Request;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;

import net.sareweb.onddo.model.Picking;
import net.sareweb.onddo.portlet.generic.SarewebPortlet;
import net.sareweb.onddo.service.PickingLocalServiceUtil;

/**
 * Portlet implementation class ListPortlet
 */
public class ListPortlet extends SarewebPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		getLastPickings(renderRequest);
		
		super.doView(renderRequest, renderResponse);
	}
	
	
	private void getLastPickings(RenderRequest renderRequest) {
		try {
			renderRequest.setAttribute(ATTR_PICKINGS, PickingLocalServiceUtil.getPickings(0, 10));
		} catch (SystemException e) {
			renderRequest.setAttribute(ATTR_PICKINGS, new ArrayList<Picking>());
			_log.error("Error getting pickings",e);
		}
	}


	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		_log.debug("Resource requested");
		
		String res_type = ParamUtil.getString(resourceRequest, PARAM_RES_TYPE,"");
		String res_id = ParamUtil.getString(resourceRequest, PARAM_RES_ID, "");
		
		if (res_type.equals(RES_TYPE_HTML)) {

			super.serveResource(resourceRequest, resourceResponse);
		}
		else if (res_type.equals(RES_TYPE_JSON)) {

		}
		else if (res_type.equals(RES_TYPE_FILE)) {

			super.serveResource(resourceRequest, resourceResponse);
		}
	}
	
	public static final String PARAM_PICKINGS ="PARAM_PICKINGS";
	public static final String ATTR_PICKINGS ="ATTR_PICKINGS";
}
