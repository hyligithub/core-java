package com.core.collection.iteratorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2016/9/26.
 */
public class ChannelCollectionImpl implements ChannelCollection {
    List<Channel> list;

    public ChannelCollectionImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public void addChannel(Channel channel) {
        this.list.add(channel);
    }

    @Override
    public void removeChannel(Channel channel) {
        boolean b = this.list.remove(channel);
        System.out.println(b);
    }

    @Override
    public ChannelIterator iterator(ChannelEnum type) {
        return new ChannelIteratorImpl(list, type);
    }

    private class ChannelIteratorImpl implements ChannelIterator {

        private List<Channel> list;
        private ChannelEnum channelEnum;
        private int position;

        public ChannelIteratorImpl(List<Channel> list, ChannelEnum type) {
            this.list = list;
            this.channelEnum = type;
        }

        @Override
        public boolean hasNext() {
            while (position < list.size()) {
                Channel channel = list.get(position);
                if (channel.getChannelEnum().equals(channelEnum))
                    return true;
                else position++;
            }
            return false;
        }

        @Override
        public Channel next() {
            Channel c = list.get(position);
            position++;
            return c;
        }
    }
}
