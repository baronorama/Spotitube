/* bind that shit together man */

package ica.oose.spotitube.services.guice;

import com.google.inject.servlet.ServletModule;
import ica.oose.spotitube.datasource.util.TrackDAO;
import ica.oose.spotitube.presentation.controller.TrackPageController;
import ica.oose.spotitube.services.TestTrackService;
import ica.oose.spotitube.services.TrackService;
import ica.oose.spotitube.services.TrackServiceInterface;

/*
**
**  Created by Vincent on 12-12-2015.
*/

public class AppBinding extends ServletModule {
    @Override
    protected void configureServlets() {
        super.configureServlets();
        serve("/tracks").with(TrackPageController.class);

//        bind(TrackServiceInterface.class).to(TrackService.class);
//        bind(TrackService.class).to(TrackService.class);
//        bind(TrackDAO.class).to(TrackDAO.class);
//        bind(TrackServiceInterface.class).to(TestTrackService.class);
    }
}

