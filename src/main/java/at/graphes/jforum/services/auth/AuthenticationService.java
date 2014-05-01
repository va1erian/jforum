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

import at.graphes.jforum.dao.UserDAO;
import at.graphes.jforum.entities.User;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author valerian
 */
public class AuthenticationService {
    
    @Inject
    UserDAO userDAO;
        
    public void tryLogin(String nick, String pass) throws AuthenticationException {
        User u = userDAO.findByNickname(nick);
        if(u == null)
            throw new AuthenticationException("Unknown user");
      
        if(!u.getPassHash().equals(computeHash(pass)))
            throw new AuthenticationException("Incorrect password.");
    }
    
    public byte[] computeHash(String pass) throws AuthenticationException {
        char[] chars = pass.toCharArray();
        byte[] secret = null;
        PBEKeySpec keyspec = new PBEKeySpec(chars, null, 500);
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            secret = factory.generateSecret(keyspec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new AuthenticationException("An error occured during the authentication process");
        }
        
         return secret;
    }
    
    public boolean isLoggedIn() {
        return true;
    }
}
