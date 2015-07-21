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
package com.speedment.core;

import com.speedment.core.annotations.Api;

/**
 * A <code>Buildable</code> provides a generic builder interface.
 *
 * @author pemi
 * @param <T> The type that can be built
 */
@Api(version = "2.0")
public interface Buildable<T> {

    /**
     * Creates and returns a new immutable instance of type T.
     *
     * @return a new immutable instance of type T
     */
    T build();

}
