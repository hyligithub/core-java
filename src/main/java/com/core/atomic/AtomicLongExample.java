package com.core.atomic;

import com.core.PrintUtil;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lihuiyan on 2016/10/31.
 */
public class AtomicLongExample {
    public static void main(String[] args) {
        AtomicLong mAtoLong = new AtomicLong();
        mAtoLong.set(0x0123456789ABCDEFL);
        PrintUtil.printf("%20s : 0x%016X\n", "get()", mAtoLong.get());
        PrintUtil.printf("%20s : 0x%016X\n", "intValue()", mAtoLong.intValue());
        PrintUtil.printf("%20s : 0x%016X\n", "longValue()", mAtoLong.longValue());
        PrintUtil.printf("%20s : %s\n", "doubleValue()", mAtoLong.doubleValue());
        PrintUtil.printf("%20s : %s\n", "floatValue()", mAtoLong.floatValue());

        PrintUtil.printf("%20s : 0x%016X\n", "getAndDecrement()", mAtoLong.getAndDecrement());
        PrintUtil.printf("%20s : 0x%016X\n", "decrementAndGet()", mAtoLong.decrementAndGet());
        PrintUtil.printf("%20s : 0x%016X\n", "getAndIncrement()", mAtoLong.getAndIncrement());
        PrintUtil.printf("%20s : 0x%016X\n", "incrementAndGet()", mAtoLong.incrementAndGet());

        PrintUtil.printf("%20s : 0x%016X\n", "addAndGet(0x10)", mAtoLong.addAndGet(0x10));
        PrintUtil.printf("%20s : 0x%016X\n", "getAndAdd(0x10)", mAtoLong.getAndAdd(0x10));

        PrintUtil.printf("\n%20s : 0x%016X\n", "get()", mAtoLong.get());

        PrintUtil.printf("%20s : %s\n", "compareAndSet()", mAtoLong.compareAndSet(0x12345679L, 0xFEDCBA9876543210L));
        PrintUtil.printf("%20s : 0x%016X\n", "get()", mAtoLong.get());
    }
}
