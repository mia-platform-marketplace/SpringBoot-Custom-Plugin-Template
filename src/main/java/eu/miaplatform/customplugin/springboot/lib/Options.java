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

public class Options {
    private String userIdHeaderKey;
    private String groupsHeaderKey;
    private String clientTypeHeaderKey;
    private String backofficeHeaderKey;
    private String microserviceGatewayServiceName;

    public Options() {
        this.userIdHeaderKey = "USERID_HEADER_KEY";
        this.groupsHeaderKey = "GROUPS_HEADER_KEY";
        this.clientTypeHeaderKey = "CLIENTTYPE_HEADER_KEY";
        this.backofficeHeaderKey = "BACKOFFICE_HEADER_KEY";
        this.microserviceGatewayServiceName = "MICROSERVICE_HEADER_KEY";
    }
    public Options(String userIdHeaderKey, String groupsHeaderKey, String clientTypeHeaderKey, String backofficeHeaderKey, String microserviceGatewayServiceName) {
        this.userIdHeaderKey = userIdHeaderKey;
        this.groupsHeaderKey = groupsHeaderKey;
        this.clientTypeHeaderKey = clientTypeHeaderKey;
        this.backofficeHeaderKey = backofficeHeaderKey;
        this.microserviceGatewayServiceName = microserviceGatewayServiceName;
    }

    public String getUserIdHeaderKey() {
        return userIdHeaderKey;
    }

    public String getGroupsHeaderKey() {
        return groupsHeaderKey;
    }

    public String getClientTypeHeaderKey() {
        return clientTypeHeaderKey;
    }

    public String getBackofficeHeaderKey() {
        return backofficeHeaderKey;
    }

    public String getMicroserviceGatewayServiceName() {
        return microserviceGatewayServiceName;
    }
}
