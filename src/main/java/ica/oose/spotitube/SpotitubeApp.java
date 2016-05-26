/* This is for JAX-RS / REST */
package ica.oose.spotitube;

import com.google.inject.Guice;
// import ica.oose.spotitube.services.guice.AppBinding;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


/**
 * Created by Vincent on 12-11-2015.
 */

@ApplicationPath("/spotitube")
public class SpotitubeApp extends Application {

}


/*

@ApplicationPath("/spotitube")
public class SpotitubeApp extends ResourceConfig {
    @Inject
    public SpotitubeApp(ServiceLocator serviceLocator) {
        packages("ica.oose.spotitube.services");
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(Guice.createInjector(new AppBinding()));
    }
}*/
