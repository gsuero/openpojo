/**
 * Copyright (C) 2010 Osman Shoukry
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.openpojo.validation.affirm;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.reflection.exception.ReflectionException;

/**
 *
 * @author oshoukry
 *
 */
public class JUnitAssertAffirmation implements Affirmation {
    static {
        try {
            Class.forName("org.junit.Assert");
        } catch (ClassNotFoundException e) {
            throw ReflectionException.getInstance("org.junit.Assert class not found");
        }
    }


    private JUnitAssertAffirmation() {
    }

    public void fail(final String message) {
        org.junit.Assert.fail(message);
    }

    public void affirmTrue(final String message, final boolean condition) {
        org.junit.Assert.assertTrue(message, condition);
    }

    public void affirmFalse(final String message, final boolean condition) {
        org.junit.Assert.assertFalse(message, condition);
    }

    public void affirmNotNull(final String message, final Object object) {
        org.junit.Assert.assertNotNull(message, object);
    }

    public void affirmNull(final String message, final Object object) {
        org.junit.Assert.assertNull(message, object);
    }

    public void affirmEquals(final String message, final Object first, final Object second) {
        org.junit.Assert.assertEquals(message, first, second);
    }

    @Override
    public String toString() {
        return BusinessIdentity.toString(this);
    }
}