/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package liferaysavvy.mvn.clayform.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import liferaysavvy.mvn.clayform.constants.MVNClayFormPortletKeys;

/**
 * @author Brian Wing Shun Chan
 * @author Wilson S. Man
 * @author Thiago Moreira
 * @author Juan Fernández
 * @author Zsolt Berentey
 * @author Levente Hudák
 */

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + MVNClayFormPortletKeys.MVNCLAYFORM,
			"mvc.command.name=/clayfrom/edit_employee"
	},
	service = MVCActionCommand.class
)
public class EditEmployeeMVCActionCommand extends BaseMVCActionCommand {

	
	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		updateEntry(actionRequest,actionResponse);
	}
	protected void updateEntry(ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		// Get form values from request object
		String gender = ParamUtil.getString(actionRequest, "gender");
		String country = ParamUtil.getString(actionRequest, "country");
		String[] hobbies = ParamUtil.getParameterValues(actionRequest, "hobbies", null);
		
		// Display logs in console for debug
		_log.info("gender"+gender);
		_log.info("gender"+hobbies.toString());
		_log.info("gender"+country);
		
		//Preparing object to send to JSP page.
		Map<String, String> employeeObject = new HashMap();
		employeeObject.put("gender", gender);
		employeeObject.put("country", country);
		//set View details object in request object.
        actionRequest.setAttribute("employeeObject", employeeObject);
        List<String> hobbiesList = new ArrayList();
        hobbiesList = ListUtil.toList(hobbies);
      //set View details object in request object.
        actionRequest.setAttribute("hobbiesList", hobbiesList);
        //Navigation to view employee details JSP page.
		actionResponse.setRenderParameter("mvcRenderCommandName", "/clayform/view_employee");
	}

	
	

	private static final Log _log = LogFactoryUtil.getLog(
		EditEmployeeMVCActionCommand.class);

}