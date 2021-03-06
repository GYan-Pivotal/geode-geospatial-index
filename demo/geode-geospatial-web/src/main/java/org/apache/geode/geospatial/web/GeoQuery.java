/*
 * Copyright [2016] Charlie Black
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

package org.apache.geode.geospatial.web;

import org.apache.geode.geospatial.function.GeoQueryFunction;
import org.apache.geode.pdx.PdxInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Charlie Black on 9/23/16.
 */
@RestController
public class GeoQuery {
    private static final Logger logger = LoggerFactory.getLogger(GeoQuery.class);

    @RequestMapping(value = "/query", method = RequestMethod.GET, produces = "application/json")
    public List<PdxInstance> query(String wktPolygon) {
        logger.info("the wkt - {}", wktPolygon);
        List<PdxInstance> result = GeoQueryFunction.query(wktPolygon);
        logger.info("result size  = {}", result.size());
        return result;
    }
}
