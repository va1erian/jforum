package at.graphes.jforum.pages.topic;

import at.graphes.jforum.services.domain.TopicDAO;
import at.graphes.jforum.entities.Board;
import at.graphes.jforum.entities.Topic;
import at.graphes.jforum.services.auth.RequiresAuthentication;
import java.util.Date;
import org.apache.tapestry5.annotations.ActivationRequestParameter;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

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

/**
 *
 * @author valerian
 */
@RequiresAuthentication
public class CreateTopic {
    
    @Property
    @ActivationRequestParameter
    private Board board;
    
    @Property
    private Topic newTopic;
    
    @Inject
    private TopicDAO topicDAO;
    
    @Log
    Object onSuccess() {
        newTopic.setBoard(board);
        newTopic.setPostDate(new Date());
        topicDAO.save(newTopic);
        
        return null;
    }
}
