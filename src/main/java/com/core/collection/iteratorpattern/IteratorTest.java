package com.core.collection.iteratorpattern;

/**
 * Created by lihuiyan on 2016/9/26.
 */
public class IteratorTest {
    public static void main(String[] args) {
        ChannelCollection cs = initChannel();
        cs.removeChannel(new Channel(98.5,ChannelEnum.CHINA));
        ChannelIterator iterator = cs.iterator(ChannelEnum.CHINA);
        while (iterator.hasNext()) {
            Channel c = iterator.next();
            System.out.println(c.toString());
        }
    }

    private static ChannelCollection initChannel() {
        ChannelCollection cs = new ChannelCollectionImpl();
        cs.addChannel(new Channel(98.5, ChannelEnum.CHINA));
        cs.addChannel(new Channel(100.1, ChannelEnum.ENGLISH));
        cs.addChannel(new Channel(76.3, ChannelEnum.FRENCH));
        cs.addChannel(new Channel(100.00, ChannelEnum.ALL));
        return cs;
    }
}
