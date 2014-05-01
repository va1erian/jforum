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

package at.graphes.jforum.dao;

import at.graphes.jforum.entities.Message;
import at.graphes.jforum.entities.User;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author valerian
 */
public class UserDAOHibernateImpl implements UserDAO{

    static String BY_MESSAGE_QUERY = "SELECT u FROM User u WHERE :p.author = u";
    
    @Inject
    private Session s;
    
    @Override
    public User findByNickname(String nick) {
        return (User) s.get(User.class, nick);
    }

    @Override
    public User findByMessage(Message m) {
        return (User) s.createQuery(BY_MESSAGE_QUERY).setParameter("p", m).uniqueResult();
    }

    @Override
    public User save(User u) {
        s.persist(u);
        s.flush();
        s.refresh(u);
        return u;
    }
    
}
