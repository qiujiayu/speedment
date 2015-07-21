/**
 *
 * Copyright (c) 2006-2015, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.speedment.core.platform.component;

import com.speedment.core.annotations.Api;
import com.speedment.core.platform.Platform;
import java.util.Optional;

/**
 * An Entity Manager can be used to handle persistence for any Entity.
 *
 * @author pemi
 */
@Api(version = "2.0")
public interface EntityManager extends Component {

    @Override
    default Class<EntityManager> getComponentClass() {
        return EntityManager.class;
    }

    // Persistence
    <ENTITY> Optional<ENTITY> persist(ENTITY entity);

    <ENTITY> Optional<ENTITY> update(ENTITY entity);

    <ENTITY> Optional<ENTITY> remove(ENTITY entity);

    public static EntityManager get() {
        return Platform.get().get(EntityManager.class);
    }

}
