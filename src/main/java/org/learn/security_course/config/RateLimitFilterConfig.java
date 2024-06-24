package org.learn.security_course.config;

import org.learn.security_course.dos.RateLimitFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateLimitFilterConfig {

    // Assigning filter to specific api
    @Bean
    public FilterRegistrationBean<RateLimitFilter> blueRateLimit() {
        var registrationBean = new FilterRegistrationBean<RateLimitFilter>();
        registrationBean.setFilter(new RateLimitFilter(10));
        registrationBean.setName("Blue Rate Limit");
        registrationBean.addUrlPatterns("/dos/v1/blue");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<RateLimitFilter> redRateLimit() {
        var registrationBean = new FilterRegistrationBean<RateLimitFilter>();
        registrationBean.setFilter(new RateLimitFilter(5));
        registrationBean.setName("Red Rate Limit");
        registrationBean.addUrlPatterns("/dos/v1/red");

        return registrationBean;
    }
}
