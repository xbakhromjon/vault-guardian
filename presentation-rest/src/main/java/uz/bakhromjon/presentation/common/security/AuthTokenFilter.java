package uz.bakhromjon.presentation.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.bakhromjon.application.token.application.port.out.LoadAccessTokenPort;
import uz.bakhromjon.application.token.domain.AccessToken;
import uz.bakhromjon.application.user.domain.User;
import uz.bakhromjon.presentation.common.ErrorMessage;
import uz.bakhromjon.presentation.common.ErrorResponse;
import uz.bakhromjon.presentation.common.GenericResponse;

import java.io.IOException;
import java.util.Arrays;


public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private LoadAccessTokenPort loadAccessTokenPort;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String accessToken = request.getHeader("Authorization");

        if (accessToken == null || !accessToken.startsWith("Bearer")) {
            UnauthorizedException exception = new UnauthorizedException(ErrorMessage.ACCESS_TOKEN_REQUIRED_THIS_RESOURCE, null);
            sendError(new ErrorResponse("", request.getRequestURI(), ErrorMessage.ACCESS_TOKEN_REQUIRED_THIS_RESOURCE, null), response);
            return;
        }
        accessToken = accessToken.substring(7);
        AccessToken accessTokenObj;
        try {
            accessTokenObj = loadAccessTokenPort.loadByToken(accessToken);
        } catch (Exception e) {
            sendError(new ErrorResponse("", request.getRequestURI(), ErrorMessage.WRONG_ACCESS_TOKEN, null), response);
            return;
        }
        if (accessTokenObj.isExpired()) {
            sendError(new ErrorResponse("", request.getRequestURI(), ErrorMessage.ACCESS_TOKEN_EXPIRED, null), response);
            return;
        }
        User user = accessTokenObj.getUser();
        UserDetailsImpl userDetails = UserDetailsImpl.build(user);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails,
                        null,
                        null);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private void sendError(ErrorResponse errorResponse, HttpServletResponse httpServletResponse) throws IOException {
        GenericResponse<ErrorResponse> genericResponse = new GenericResponse<>(errorResponse, HttpStatus.UNAUTHORIZED);
        ObjectMapper objectMapper = new ObjectMapper();
        httpServletResponse.setHeader("Content-Type", "application/json");
        httpServletResponse.getWriter().print(objectMapper.writeValueAsString(genericResponse));
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return Arrays.stream(SecurityConfiguration.WHITE_LIST)
                .anyMatch(e -> new AntPathMatcher().match(e, request.getServletPath()));
    }
}
