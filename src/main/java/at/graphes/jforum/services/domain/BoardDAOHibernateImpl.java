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
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author valerian
 */
public class BoardDAOHibernateImpl implements BoardDAO {

    static String FIND_ALL_QUERY = "SELECT b FROM Board b ORDER BY b.name";
    static String BY_NAME_QUERY  = "SELECT b FROM Board b WHERE b.name = :n";
    @Inject
    Session s;
    

    @Override
    public List<Board> findAll() {
        return s.createQuery(FIND_ALL_QUERY).list();
    }

    @Override
    public Board findByName(String name) {
        return (Board) s.createQuery(BY_NAME_QUERY).setParameter("n", name).uniqueResult();
    }

    @Override
    public Board findById(Integer id){
        return (Board) s.get(Board.class, id );
    }
    
    
    @Override
    public Board save(Board b) {
       s.persist(b);
       s.flush();
       s.refresh(b);
       return b;
    }
    
}
