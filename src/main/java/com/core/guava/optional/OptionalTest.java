package com.core.guava.optional;

import com.core.PrintUtil;
//import com.google.common.base.Optional;
//import org.junit.Test;

import java.util.Set;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Optional;


/**
 * Created by lihuiyan on 2017/2/15.
 */
public class OptionalTest {
//
//    @Test
//    public void testOptional() {
//        Optional<Integer> optional = Optional.of(6);
//        Optional<Integer> absentOpt = Optional.absent();
//        Optional<Integer> NullableOpt = Optional.fromNullable(null);
//        Optional<Integer> NoNullableOpt = Optional.fromNullable(10);
//
//        if (optional.isPresent()) {
//            PrintUtil.print(optional.get());
//        }
//        if (absentOpt.isPresent()) {
//            PrintUtil.print(absentOpt.get());
//        }
//        if (NullableOpt.isPresent()) {
//            PrintUtil.print(NullableOpt.get());
//        }
//        if (NoNullableOpt.isPresent()) {
//            PrintUtil.print(NoNullableOpt.get());
//        }
//    }
//
//    @Test
//    public void testMethodReturn() {
//        Optional<Long> optional = method();
//        if (!optional.isPresent()) {
//            PrintUtil.print("optional return is null");
//            optional.or(-12L);
//            PrintUtil.print(optional.or(-12L));
//        }
//        PrintUtil.print(optional.orNull());
//
//        Optional<Long> value = methodNotNull();
//
//        if (value.isPresent()) {
//            Set<Long> set = value.asSet();
//            PrintUtil.print("set size = " + set.size());
//            PrintUtil.print(value.get());
//        }
//
//        PrintUtil.print(value.orNull());
//
//    }
//
//    private Optional<Long> method() {
//        return Optional.fromNullable(null);
//    }
//
//    private Optional<Long> methodNotNull() {
//        return Optional.fromNullable(15L);
//    }
}
