/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xu.qiwei.com.marketlist.util.inject;

import android.content.Context;
import android.support.annotation.NonNull;

import xu.qiwei.com.marketlist.data.MarketListRepository;
import xu.qiwei.com.marketlist.data.local.ListLocalDataSource;
import xu.qiwei.com.marketlist.util.schedulers.BaseSchedulerProvider;
import xu.qiwei.com.marketlist.util.schedulers.SchedulerProvider;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Enables injection of mock implementations for
 * {@link ListLocalDataSource} at compile time. This is useful for testing, since it allows us to use
 * a fake instance of the class to isolate the dependencies and run a test hermetically.
 */
public class Injection {

    public static MarketListRepository provideTasksRepository(@NonNull Context context) {
        checkNotNull(context);
        return MarketListRepository.getInstance(ListLocalDataSource.getInstance(context,provideSchedulerProvider()));
    }

    public static BaseSchedulerProvider provideSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }
}
