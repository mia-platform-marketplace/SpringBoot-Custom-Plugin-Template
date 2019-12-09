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

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

class Utils {

    static String getUserId(Options options, Map<String, String> headers) {
        return headers.get(options.getUserIdHeaderKey());
    }

    static List<String> getGroups(Options options, Map<String, String> headers) {
        String header = headers.get(options.getGroupsHeaderKey());
        String[] groupHeaders = header != null ? header.split(",") : new String[]{};
        return Arrays.stream(groupHeaders).filter(s -> s.length() > 0).collect(Collectors.toList());
    }

    static String getClientType(Options options, Map<String, String> headers) {
        return headers.get(options.getClientTypeHeaderKey());
    }

    static boolean isFromBackOffice(Options options, Map<String, String> headers) {
        String header = headers.get(options.getBackofficeHeaderKey());
        return header != null ? header.length() > 0 : false;
    }

    static Map<String, String> getHeadersInfo(HttpServletRequest request) {

        Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }
}
