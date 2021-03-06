/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.openmessaging.internal;

import io.openmessaging.KeyValue;
import io.openmessaging.MessagingAccessPoint;
import io.openmessaging.OMS;
import io.openmessaging.OMSBuiltinKeys;
import io.openmessaging.ResourceManager;
import io.openmessaging.consumer.PullConsumer;
import io.openmessaging.consumer.PushConsumer;
import io.openmessaging.consumer.StreamingConsumer;
import io.openmessaging.producer.Producer;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MessagingAccessPointAdapterTest {
    @Test
    public void getMessagingAccessPoint() throws Exception {
        String testURI = "oms:test-vendor://alice@rocketmq.apache.org/us-east:default_space";

        KeyValue keyValue = OMS.newKeyValue();
        keyValue.put(OMSBuiltinKeys.DRIVER_IMPL, "io.openmessaging.internal.TestVendor");
        MessagingAccessPoint messagingAccessPoint = OMS.getMessagingAccessPoint(testURI, keyValue);
        assertThat(messagingAccessPoint).isExactlyInstanceOf(TestVendor.class);
    }
}

class TestVendor implements MessagingAccessPoint {

    public TestVendor(KeyValue keyValue) {
    }

    @Override
    public String implVersion() {
        return OMS.specVersion;
    }

    @Override
    public KeyValue attributes() {
        return null;
    }

    @Override
    public Producer createProducer() {
        return null;
    }

    @Override
    public Producer createProducer(final KeyValue attributes) {
        return null;
    }

    @Override
    public PushConsumer createPushConsumer() {
        return null;
    }

    @Override
    public PushConsumer createPushConsumer(final KeyValue attributes) {
        return null;
    }

    @Override
    public PullConsumer createPullConsumer() {
        return null;
    }

    @Override
    public PullConsumer createPullConsumer(final KeyValue attributes) {
        return null;
    }

    @Override
    public StreamingConsumer createStreamingConsumer() {
        return null;
    }

    @Override
    public StreamingConsumer createStreamingConsumer(final KeyValue attributes) {
        return null;
    }

    @Override
    public ResourceManager resourceManager() {
        return null;
    }

    @Override
    public void startup() {

    }

    @Override
    public void shutdown() {

    }
}