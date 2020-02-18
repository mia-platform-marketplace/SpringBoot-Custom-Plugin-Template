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

package eu.miaplatform.customplugin.springboot;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class CPRequestTest {

    private CPRequest cpRequest;
    private Options options = new Options();
    private String id = "1234";
    private String type = "admin";
    private boolean backoffice = true;
    private String groupsString = "group1,group2";
    private List<String> groups = Arrays.asList("group1","group2");

    @Before
    public void setUp() {
        cpRequest = new CPRequest(getRequest(options), options);
    }

    @Test
    public void checkPlatformHeaders() {
        assertEquals(id, cpRequest.getUserId());
        assertEquals(type, cpRequest.getClientType());
        assertEquals(backoffice, cpRequest.isFromBackOffice());
        for (int i = 0; i < groups.size(); ++i) {
            assertEquals(groups.get(i), cpRequest.getGroups().get(i));
        }

    }

    private HttpServletRequest getRequest(Options options) {

        MockHttpServletRequest req = new MockHttpServletRequest();

        req.addHeader(options.getUserIdHeaderKey(), id);
        req.addHeader(options.getClientTypeHeaderKey(), type);
        req.addHeader(options.getBackofficeHeaderKey(), backoffice);
        req.addHeader(options.getGroupsHeaderKey(), groupsString);

        return req;
    }
}
