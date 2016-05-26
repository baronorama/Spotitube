
package ica.oose.spotitube.services.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import ica.oose.spotitube.services.TrackServiceInterface;


/**
 * Created by Vincent on 12-12-2015.
 */

public class GuiceServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new AppBinding());
    }
}

