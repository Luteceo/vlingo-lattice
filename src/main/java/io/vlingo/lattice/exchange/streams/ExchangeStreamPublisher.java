// Copyright © 2012-2020 VLINGO LABS. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.lattice.exchange.streams;

import io.vlingo.lattice.exchange.Exchange;
import io.vlingo.lattice.exchange.ExchangeReceiver;
import io.vlingo.reactivestreams.PublisherConfiguration;
import io.vlingo.reactivestreams.StreamPublisher;
import io.vlingo.reactivestreams.Streams;

/**
 * This class receives messages from an {@link Exchange} and streams them using {@link StreamPublisher} capabilities.
 * This class requires careful {@link PublisherConfiguration}, especially {@link Streams.OverflowPolicy} since inappropriate overflow policy
 * may fill up {@link ExchangeStreamSource} source.
 *
 * @param <T> Type of the message.
 */
public class ExchangeStreamPublisher<T> extends StreamPublisher<T> implements ExchangeReceiver<T> {
    private final ExchangeStreamSource<T> source;

    public ExchangeStreamPublisher(ExchangeStreamSource<T> source, PublisherConfiguration configuration) {
        super(source, configuration);
        this.source = source;
    }

    @Override
    public void receive(T message) {
        source.add(message);
    }
}
