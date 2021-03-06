/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nanoframework.concurrent.scheduler.longwait;

import org.junit.Assert;
import org.junit.Test;
import org.nanoframework.concurrent.scheduler.SchedulerFactory;

/**
 *
 * @author yanghe
 * @since 1.3.15
 */
public class SchedulerTest extends PluginLoaderInit {

    @Test
    public void schedulerTest() throws InterruptedException {
        // wait scheduler to running status
        Thread.sleep(1500);

        final SchedulerFactory factory = SchedulerFactory.getInstance();
        try {
            Assert.assertEquals(factory.getStartedSchedulerSize(), 1);
        } catch (final Throwable e) {
            factory.getStartedScheduler().forEach(s -> LOGGER.debug(s.getConfig().getId()));
            throw e;
        }

        factory.close(LongWaitScheduler.class.getSimpleName() + "-0");

        Thread.sleep(3000);

        Assert.assertEquals(factory.getStartedSchedulerSize(), 0);
        Assert.assertEquals(factory.getStoppingSchedulerSize(), 0);
    }

}
