/*
 * Copyright (C) 2014 valerian
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package at.graphes.jforum.services.auth;

import java.io.IOException;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.runtime.Component;
import org.apache.tapestry5.services.*;

/**
 *
 * @author valerian
 */
public class RequiresAuthenticationFilter implements ComponentRequestFilter {

  private final PageRenderLinkSource renderLinkSource;

  private final ComponentSource componentSource;

  private final Response response;

  private final AuthenticationService authService;

  public RequiresAuthenticationFilter(PageRenderLinkSource renderLinkSource,
      ComponentSource componentSource, Response response,
      AuthenticationService authService) {
    this.renderLinkSource = renderLinkSource;
    this.componentSource = componentSource;
    this.response = response;
    this.authService = authService;
  }

  @Override
  public void handleComponentEvent(
      ComponentEventRequestParameters parameters,
      ComponentRequestHandler handler) throws IOException {

    if (dispatchedToLoginPage(parameters.getActivePageName())) {
      return;
    }

    handler.handleComponentEvent(parameters);

  }

  @Override
  public void handlePageRender(PageRenderRequestParameters parameters,
      ComponentRequestHandler handler) throws IOException {

    if (dispatchedToLoginPage(parameters.getLogicalPageName())) {
      return;
    }

    handler.handlePageRender(parameters);
  }

  private boolean dispatchedToLoginPage(String pageName) throws IOException {

    if (authService.isLoggedIn()) {
      return false;
    }

    Component page = componentSource.getPage(pageName);

    if (! page.getClass().isAnnotationPresent(RequiresAuthentication.class)) {
      return false;
    }

    Link link = renderLinkSource.createPageRenderLink("Login");

    response.sendRedirect(link);

    return true;
  }
}