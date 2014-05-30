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

package at.graphes.jforum.pages.board;

import at.graphes.jforum.entities.Board;
import at.graphes.jforum.entities.Topic;
import org.apache.tapestry5.annotations.ActivationRequestParameter;
import org.apache.tapestry5.annotations.Property;

/**
 *
 * @author valerian
 */
public class BoardIndex {

    @Property
    @ActivationRequestParameter
    private Board b;
    
    
    @Property
    private Topic t;
}
