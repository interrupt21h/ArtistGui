/*
 * The ARTist Project (https://artist.cispa.saarland)
 *
 * Copyright (C) 2017 CISPA (https://cispa.saarland), Saarland University
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
 *
 */

package saarland.cispa.artist.artistgui.appdetails;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import saarland.cispa.artist.artistgui.database.Package;
import saarland.cispa.artist.artistgui.base.BasePresenter;
import saarland.cispa.artist.artistgui.base.BaseView;

interface AppDetailsDialogContract {
    interface View extends BaseView<AppDetailsDialogContract.Presenter> {
        void setAppIcon(Drawable appIcon);

        void setLastInstrumentationText(String lastInstrumented);

        void updateKeepInstrumentedViews(boolean enable, Package app);

        void updateInstrumentationButton(boolean instrumented);

        void updateRemoveInstrumentationButton(boolean isInstrumented);

        void showInstrumentationProgress();
    }

    interface Presenter extends BasePresenter {
        void loadAppIcon();

        void determineInstrumentationStatusAndUpdateViews();

        void startInstrumentation();

        void removeInstrumentation();

        void handleInstrumentationResult(boolean isSuccess);

        void saveInstanceState(Bundle outState);

        void setSelectedPackage(Package selectedPackage);
    }
}