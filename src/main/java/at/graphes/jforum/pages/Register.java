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

package at.graphes.jforum.pages;

import at.graphes.jforum.entities.User;
import at.graphes.jforum.services.auth.AuthenticationException;
import at.graphes.jforum.services.auth.AuthenticationService;
import at.graphes.jforum.services.domain.UserDAO;
import java.util.Date;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.HibernateException;

/**
 *
 * @author valerian
 */
public class Register  {
    @Component 
    private Form registerForm;
    
    @Inject
    private UserDAO userDAO;
    
    @Inject
    private AuthenticationService auth;
    
    @Property private String nickname;
    @Property private String email;
    @Property private String password;
    @Property private String passwordConfirmation;
    
    @InjectComponent("password") private PasswordField passwordField;
    @InjectComponent("passwordConfirmation") private PasswordField passwordConfirmationField;
    
    
    void onValidateFromRegisterForm() {
        if(!password.equals(passwordConfirmation)) {
            registerForm.recordError("Password and confirmation do not match.");
        }
        
        User u = new User();
        u.setNickname(nickname);
        u.setEmail(email);
        u.setRegDate(new Date());
        u.setType(User.Type.USER);
        
        try {
            u.setPassHash(new String(auth.computeHash(password)));
        userDAO.save(u);
        } catch(AuthenticationException | HibernateException e) {
            registerForm.recordError(e.getMessage());
        }
    }
}
