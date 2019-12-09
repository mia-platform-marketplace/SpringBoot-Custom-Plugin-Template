/*
 * Copyright 2019 Mia srl
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

package eu.miaplatform.customplugin.springboot.lib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.function.Consumer;
import java.util.function.Function;

public class CPDecorator {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String filter = "filter";
    private int number = 1;

    protected FilterRegistrationBean addPrePostDecorator(String path,
                                                         Function<CPRequestWrapper, CPRequestWrapper> preHandler,
                                                         Consumer<CPResponseWrapper> postHandler) {

        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter((servletRequest, servletResponse, filterChain) -> {

            CPRequestWrapper requestWrapper = preHandler.apply(new CPRequestWrapper((HttpServletRequest) servletRequest));
            CPResponseWrapper responseWrapper = new CPResponseWrapper((HttpServletResponse) servletResponse);

            filterChain.doFilter(requestWrapper, responseWrapper);

            postHandler.accept(responseWrapper);
        });
        registration.setName(filter + number);
        number++;
        registration.addUrlPatterns(path);
        return registration;
    }


    protected FilterRegistrationBean addPreDecorator(String path, Function<CPRequestWrapper, CPRequestWrapper> preHandler) {

        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter((servletRequest, servletResponse, filterChain) -> {
            CPRequestWrapper requestWrapper = preHandler.apply(new CPRequestWrapper((HttpServletRequest) servletRequest));
            filterChain.doFilter(requestWrapper, servletResponse);
        });
        registration.setName(filter + number);
        number++;
        registration.addUrlPatterns(path);
        return registration;
    }

    protected FilterRegistrationBean addPostDecorator(String path, Consumer<CPResponseWrapper> postHandler) {

        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter((servletRequest, servletResponse, filterChain) -> {
            CPResponseWrapper responseWrapper = new CPResponseWrapper((HttpServletResponse) servletResponse);
            filterChain.doFilter(servletRequest, responseWrapper);
            postHandler.accept(responseWrapper);
        });
        registration.setName(filter + number);
        number++;
        registration.addUrlPatterns(path);
        return registration;
    }
}
