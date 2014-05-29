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

package at.graphes.jforum.services.domain;

import at.graphes.jforum.entities.Board;
import at.graphes.jforum.entities.Topic;
import at.graphes.jforum.entities.User;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author valerian
 */
public class TopicDAOHibernateImpl implements TopicDAO {

    @Inject
    Session s;    
    
    @Override
    public List<Topic> findByBoard(Board b) {
        throw new UnsupportedOperationException("Not supported yet.");  
    }

    @Override
    public List<Topic> findByBoard(Board b, Integer page) {
        throw new UnsupportedOperationException("Not supported yet.");  
    }

    @Override
    public List<Topic> findByUser(User u) {
        throw new UnsupportedOperationException("Not supported yet.");  
    }

    @Override
    public Integer getPageCount() {
        throw new UnsupportedOperationException("Not supported yet.");  
    }

    @Override
    public Topic save(Topic t) {
        s.persist(t);
        s.flush();
        s.refresh(t);
        return t;
    }
    
}
