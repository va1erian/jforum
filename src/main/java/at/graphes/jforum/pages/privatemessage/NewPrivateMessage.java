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

package at.graphes.jforum.pages.privatemessage;

import at.graphes.jforum.entities.PrivateMessage;
import at.graphes.jforum.entities.User;
import at.graphes.jforum.services.auth.AuthenticationService;
import at.graphes.jforum.services.auth.RequiresAuthentication;
import at.graphes.jforum.services.domain.UserDAO;
import java.util.Date;
import org.apache.tapestry5.annotations.ActivationRequestParameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author valerian
 */

@RequiresAuthentication
public class NewPrivateMessage {
    
    @ActivationRequestParameter
    @Property
    private User recipient;
    
    @Inject
    private AuthenticationService auth;
    
    @Inject
    private UserDAO userDAO;
    
    @Property private String title;
    @Property private String content;
    
    @Property private Form privateMessageForm;
    
    @CommitAfter
    void onSuccess() {
        PrivateMessage pm = new PrivateMessage();
        pm.setTitle(title);
        pm.setContent(content);
        pm.setPostDate(new Date());
        pm.setAuthor(auth.getLoggedUser());
        pm.setRecipient(recipient);
        
        recipient.getPrivateMessages().add(pm);
        userDAO.save(recipient);
    }
}
