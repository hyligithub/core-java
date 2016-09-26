package com.core.collection.iteratorpattern;

import java.io.Serializable;

/**
 * Created by lihuiyan on 2016/9/26.
 */
public class Channel implements Serializable {
    private double frequency;
    private ChannelEnum channelEnum;

    public Channel(double frequency, ChannelEnum channelEnum) {
        this.frequency = frequency;
        this.channelEnum = channelEnum;
    }

    public double getFrequency() {
        return frequency;
    }

    public ChannelEnum getChannelEnum() {
        return channelEnum;
    }

    @Override
    public boolean equals(Object channel) {
        if (this == channel)
            return true;
        if (channel == null)
            return false;
        Channel c = (Channel) channel;
        if (c.getFrequency() == this.frequency && c.getChannelEnum().equals(this.getChannelEnum()))
            return true;
        return false;
    }

    public String toString() {
        return "frequency = " + frequency + ",channleEnum = " + channelEnum;
    }
}
