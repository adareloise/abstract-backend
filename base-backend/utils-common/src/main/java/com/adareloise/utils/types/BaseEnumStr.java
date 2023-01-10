package com.adareloise.utils.types;

public interface BaseEnumStr {

	String strValue ();

	String name ();

	static <T extends BaseEnumStr> T fromValue (Class<T> clazz, String value) {
		if (value == null) {
			return null;
		}

		T[] constants = clazz.getEnumConstants ();
		for (T constant : constants) {
			if (constant.strValue () == value) {
				return constant;
			}
		}
		return null;
	}

	static <T extends BaseEnumStr> T fromName (Class<T> clazz, String name) {
		if (name == null) {
			return null;
		}

		T[] constants = clazz.getEnumConstants ();
		for (T constant : constants) {
			if (constant.name ().equalsIgnoreCase (name)) {
				return constant;
			}
		}
		return null;
	}

}

