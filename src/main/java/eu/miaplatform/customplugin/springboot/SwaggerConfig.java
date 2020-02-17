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

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends CPSwaggerConfig {

    @Override
    public String getTitle() {
        return "Custom Plugin Spring Boot REST API";
    }

    @Override
    public String getDescription() {
        return "An example of a Custom Plugin Spring Boot REST API";
    }

    @Override
    public String getVersion() {
        return "0.0.1-SNAPSHOT";
    }

    @Override
    public String getLicense() {
        return "Apache License Version 2.0";
    }

    @Override
    public String getLicenseUrl() {
        return "https://www.apache.org/licenses/LICENSE-2.0";
    }

    @Override
    public String getContactName() {
        return "Mia Platform";
    }

    @Override
    public String getContactUrl() {
        return "https://www.mia-platform.eu";
    }

    @Override
    public String getContactEmail() {
        return "info@mia-platform.eu";
    }

}
