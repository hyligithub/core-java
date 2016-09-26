package com.core.collection.iteratorpattern;

/**
 * Created by lihuiyan on 2016/9/26.
 */
public interface ChannelCollection {

    void addChannel(Channel channel);

    void removeChannel(Channel channel);

    public ChannelIterator iterator(ChannelEnum channelEnum);
}
