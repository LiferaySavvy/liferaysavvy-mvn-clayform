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

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import liferaysavvy.mvn.clayform.constants.MVNClayFormPortletKeys;

/**
 * @author Sergio González
 * @author Roberto Díaz
 */
@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + MVNClayFormPortletKeys.MVNCLAYFORM,
			"mvc.command.name=/clayform/edit_employee"
	},
	service = MVCRenderCommand.class
)
public class EditEmployeeMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		return "/edit_employee.jsp";
	}
}