package com.adareloise.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.adareloise.model.AbstractData;

public interface ORMEntity extends Serializable {
	
	AbstractData toDto ();

	default AbstractData toDto (boolean includeChildren) {
		return this.toDto ();
	}

	default <T extends AbstractData, Y extends ORMEntity> List<T> toVOList (Class<T> type, List<Y> entities) {
		List<T> dtos= new ArrayList<> ();
		if ((entities == null) || (entities.isEmpty ())) {
			return dtos;
		}

		for (ORMEntity entity : entities) {
			dtos.add (type.cast (entity.toDto ()));
		}

		return dtos;
	}
}
