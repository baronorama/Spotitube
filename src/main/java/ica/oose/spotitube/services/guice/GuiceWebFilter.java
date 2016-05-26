package ica.oose.spotitube.services.guice;

        import com.google.inject.servlet.GuiceFilter;

        import javax.servlet.FilterChain;
        import javax.servlet.ServletException;
        import javax.servlet.ServletRequest;
        import javax.servlet.ServletResponse;
        import javax.servlet.annotation.WebFilter;
        import java.io.IOException;

/**
 * Created by Vincent on 12-12-2015.
 */
@WebFilter("/*")
public class GuiceWebFilter extends GuiceFilter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        super.doFilter(servletRequest, servletResponse, filterChain);

    }
}
