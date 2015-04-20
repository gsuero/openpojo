/*
 * Copyright (c) 2010-2015 Osman Shoukry
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as published by
 *    the Free Software Foundation, either version 3 of the License or any
 *    later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.openpojo.random.map;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

import com.openpojo.random.exception.RandomGeneratorException;
import com.openpojo.random.impl.SomeEnum;
import com.openpojo.random.map.util.AbstractMapRandomGenerator;
import com.openpojo.random.map.util.MapHelper;
import com.openpojo.random.util.SerializableComparableObject;
import com.openpojo.reflection.Parameterizable;

/**
 * @author oshoukry
 */
public class EnumMapRandomGenerator extends AbstractMapRandomGenerator {
    private static final Class<?>[] TYPES = new Class<?>[] { EnumMap.class };

    public static EnumMapRandomGenerator getInstance() {
        return Instance.INSTANCE;
    }

    public Collection<Class<?>> getTypes() {
        return Arrays.asList(TYPES);
    }

    @Override
    protected Map getBasicInstance(Class<?> type) {
        throwExceptionIfNotExpectedType(type);
        return MapHelper.buildMap(new EnumMap<SomeEnum, SerializableComparableObject>(SomeEnum.class), SomeEnum.class,
                SerializableComparableObject.class);
    }

    @SuppressWarnings("unchecked")
    public Map doGenerate(Parameterizable parameterizedType) {
        throwExceptionIfNotExpectedType(parameterizedType.getType());

        Class<?> type = (Class<?>) parameterizedType.getParameterTypes().get(0);
        EnumMap returnedMap = new EnumMap(type);
        return MapHelper.buildMap(returnedMap, parameterizedType.getParameterTypes().get(0),
                parameterizedType.getParameterTypes().get(1));
    }

    private void throwExceptionIfNotExpectedType(Class<?> type) {
        if (!isExpectedType(type))
            throw RandomGeneratorException.getInstance("Invalid type requested [" + type + "]");
    }

    private EnumMapRandomGenerator() {
    }

    private static class Instance {
        private static final EnumMapRandomGenerator INSTANCE = new EnumMapRandomGenerator();
    }
}