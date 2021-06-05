/*
 * Copyright 2021 German Vekhorev (DarksideCode)
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

package me.darksidecode.jminima.phase;

import me.darksidecode.jminima.JMinima;

public interface PhaseExecutionWatcher<T> {

    default void handleNoExcept(Object object, PhaseExecutionException error) {
        try {
            if (object != null) handle((T) object, error);
            else                handle(null, error);
        } catch (Exception ex) {
            if (JMinima.debug) ex.printStackTrace();
        }
    }

    void handle(T object, PhaseExecutionException error) throws Exception;

}
