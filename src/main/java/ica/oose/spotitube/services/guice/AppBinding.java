
/* bind that shit together man */

package ica.oose.spotitube.services.guice;

import com.google.inject.servlet.ServletModule;
import ica.oose.spotitube.presentation.controller.UserPageController;
import ica.oose.spotitube.presentation.controller.PlaylistPageController;
import ica.oose.spotitube.presentation.controller.TrackPageController;

/**
 * @author Vincent Heemskerk
 * @version 0.1
*/

public class AppBinding extends ServletModule {
    @Override
    protected final void configureServlets() {
        super.configureServlets();
        serve("/tracks").with(TrackPageController.class);
        serve("/playlists").with(PlaylistPageController.class);
        serve("/users").with(UserPageController.class);

//        bind(TrackServiceInterface.class).to(TrackService.class);
//        bind(TrackService.class).to(TrackService.class);
//        bind(TrackDAO.class).to(TrackDAO.class);
//        bind(TrackServiceInterface.class).to(TestTrackService.class);
    }
}

