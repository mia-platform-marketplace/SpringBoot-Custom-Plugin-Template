/*
 * Copyright 2020 Mia srl
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

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Status Routes")
public class StatusController extends CPStatusController {
    /**
     *  Customize methods below to perform specific behaviours
     */

    @Override
    public ResponseEntity readinessHandler(CPRequest cpRequest) {
        return super.readinessHandler(cpRequest);
    }

    @Override
    public ResponseEntity healthinessHandler(CPRequest cpRequest) {
        return super.healthinessHandler(cpRequest);
    }

    @Override
    public ResponseEntity checkUpHandler(CPRequest cpRequest) {
        return super.checkUpHandler(cpRequest);
    }
}