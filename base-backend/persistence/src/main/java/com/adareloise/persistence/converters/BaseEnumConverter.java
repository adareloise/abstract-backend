package com.adareloise.persistence.converters;

import javax.persistence.AttributeConverter;
import com.adareloise.utils.types.BaseEnum;

public class BaseEnumConverter <T extends BaseEnum> implements AttributeConverter<T, Integer> {

	private final Class<T> tClass;

	public BaseEnumConverter (Class<T> tClass) {
		this.tClass = tClass;
	}

	@Override
	public Integer convertToDatabaseColumn (T constant) {
		return constant != null ? constant.intValue () : null;
	}

	@Override
	public T convertToEntityAttribute (Integer value) {
		return BaseEnum.fromValue (this.tClass, value);
	}
}
