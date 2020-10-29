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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StatusControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void defaultReadinessRoute() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/-/ready"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"name\":\"Custom Plugin Spring Boot REST API\",\"version\":\"0.0.1-SNAPSHOT\",\"status\":\"OK\"}"
                ));
    }

    @Test
    public void defaultLivenessRoute() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/-/healthz"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"name\":\"Custom Plugin Spring Boot REST API\",\"version\":\"0.0.1-SNAPSHOT\",\"status\":\"OK\"}"
                ));
    }

    @Test
    public void defaultCheckUpRoute() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/-/check-up"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"name\":\"Custom Plugin Spring Boot REST API\",\"version\":\"0.0.1-SNAPSHOT\",\"status\":\"OK\"}"
                ));
    }
}
