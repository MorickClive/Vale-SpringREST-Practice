package com.mc.notetracker.util;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ModelUtility {

	public static void mergeNotNull(Object source, Object target) {
		BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
	}

	private static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);

		Set<String> names = new HashSet<>();
		
		for (PropertyDescriptor pd : src.getPropertyDescriptors()) {
			if (src.getPropertyValue(pd.getName()) == null) {
				names.add(pd.getName());
			}
		}
		
		return names.toArray(new String[names.size()]);
	}

}
