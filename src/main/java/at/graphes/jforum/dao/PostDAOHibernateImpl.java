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

import at.graphes.jforum.entities.Post;
import at.graphes.jforum.entities.Topic;
import at.graphes.jforum.entities.User;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author valerian
 */
public class PostDAOHibernateImpl implements PostDAO {

    
    static String BY_TOPIC_QUERY = "SELECT p FROM Post p WHERE p.parent = :t ORDER BY p.postDate";
    static String BY_USER_QUERY  = "SELECT p FROM Post p WHERE p.author = :u ORDER BY p.postDate";
    
    @Inject
    private Session s;
    
    
    @Override
    public Post find(long id) {
        return (Post) s.get(Post.class, id);
    }

    @Override
    public List<Post> findByTopic(Topic t) {
        return s.createQuery(BY_TOPIC_QUERY).setParameter("t", t).list();
    }

    @Override
    public List<Post> findByUser(User u) {
        return s.createQuery(BY_USER_QUERY).setParameter("u", u).list();
    }

    @Override
    public Post save(Post p) {
        s.persist(p);
        s.flush();
        s.refresh(p);
        return p;
    }

    @Override
    public void delete(Post p) {
        s.delete(p);
    }
    
}
