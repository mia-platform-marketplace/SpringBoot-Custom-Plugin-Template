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

import eu.miaplatform.customplugin.CustomPluginHeadersPropagator;
import eu.miaplatform.customplugin.HeadersPropagatorFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class CPRequest implements RequestPlatformInfo {

    private HttpServletRequest request;
    private Options options;
    private Map<String, String> headers;
    private CustomPluginHeadersPropagator headersPropagator;

    public CPRequest(HttpServletRequest request, Options options) {
        this.request = request;
        this.options = options;
        this.headers = Utils.getHeadersInfo(request);
        this.headersPropagator = HeadersPropagatorFactory.getCustomPluginHeadersPropagator();
        headers.forEach(headersPropagator::add);
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public CustomPluginHeadersPropagator getHeadersPropagator() {
        return headersPropagator;
    }

    public String getUserId() {
        return Utils.getUserId(options, headers);
    }

    @Override
    public List<String> getGroups() {
        return Utils.getGroups(this.options, this.headers);
    }

    @Override
    public String getClientType() {
        return Utils.getClientType(this.options, this.headers);
    }

    @Override
    public boolean isFromBackOffice() {
        return Utils.isFromBackOffice(this.options, this.headers);
    }
}
