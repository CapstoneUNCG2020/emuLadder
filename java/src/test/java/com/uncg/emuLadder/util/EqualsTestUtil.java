package com.uncg.emuLadder.util;

import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Assert;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

public final class EqualsTestUtil {
    private static final Random rand = new SecureRandom();
    private static final int NUM_2000 = 2000;
    private static final int NUM_10000000 = 10000000;
    private static final int NUM_20 = 20;

    private EqualsTestUtil() {
    }

    public static <T> void testEquals(Class<T> testedClass) throws AssertionError {
        try {
            T obj = testedClass.newInstance();
            T other = testedClass.newInstance();
            Assert.assertEquals(obj, obj);
            Assert.assertNotEquals(obj, (Object)null);
            Assert.assertNotEquals(obj, 1);
            Assert.assertEquals(obj, other);
            List<Field> fields = getFields(testedClass);
            Iterator var4 = fields.iterator();

            while(var4.hasNext()) {
                Field f = (Field)var4.next();
                Object value;
                Object opposite;
                if (StringUtils.equals("boolean", f.getType().getSimpleName())) {
                    value = true;
                    opposite = false;
                } else {
                    value = getRandomValue(f.getType());

                    do {
                        opposite = getRandomValue(f.getType());
                    } while(Objects.equals(value, opposite));
                }

                ReflectionTestUtils.setField(other, f.getName(), value);
                Assert.assertNotEquals(obj, other);
                ReflectionTestUtils.setField(obj, f.getName(), opposite);
                Assert.assertNotEquals(obj, other);
                ReflectionTestUtils.setField(obj, f.getName(), value);
                Assert.assertEquals(obj, other);
            }
        } catch (Exception var8) {
            Assert.fail("Failed equals test because of exception " + ExceptionUtils.getStackTrace(var8));
        }

    }

    private static List<Field> getFields(Class<?> clazz) {
        List<Field> fields = new LinkedList();

        for(Class cls = clazz; cls != null; cls = cls.getSuperclass()) {
            fields.addAll((Collection)Arrays.stream(cls.getDeclaredFields()).filter((field) -> {
                return !StringUtils.startsWith(field.getName(), "$");
            }).collect(Collectors.toList()));
        }

        return fields;
    }

    private static Object getRandomValue(Class<?> type) {
        if (type.isEnum()) {
            return type.getEnumConstants()[rand.nextInt(type.getEnumConstants().length)];
        } else {
            String var1 = type.getSimpleName();
            byte var2 = -1;
            switch(var1.hashCode()) {
                case -1808118735:
                    if (var1.equals("String")) {
                        var2 = 0;
                    }
                    break;
                case -1325958191:
                    if (var1.equals("double")) {
                        var2 = 3;
                    }
                    break;
                case 77116:
                    if (var1.equals("Map")) {
                        var2 = 6;
                    }
                    break;
                case 104431:
                    if (var1.equals("int")) {
                        var2 = 1;
                    }
                    break;
                case 3327612:
                    if (var1.equals("long")) {
                        var2 = 2;
                    }
                    break;
                case 64711720:
                    if (var1.equals("boolean")) {
                        var2 = 4;
                    }
                    break;
                case 1153828870:
                    if (var1.equals("LocalDateTime")) {
                        var2 = 5;
                    }
            }

            switch(var2) {
                case 0:
                    return RandomStringUtils.randomAlphabetic(rand.nextInt(20));
                case 1:
                case 2:
                    return rand.nextInt(2000);
                case 3:
                    return rand.nextDouble();
                case 4:
                    return rand.nextBoolean();
                case 5:
                    return LocalDateTime.ofEpochSecond((long)rand.nextInt(10000000), 0, ZoneOffset.UTC);
                case 6:
                    return Collections.singletonMap(Mockito.mock(Object.class), Mockito.mock(Object.class));
                default:
                    return Mockito.mock(type);
            }
        }
    }
}
