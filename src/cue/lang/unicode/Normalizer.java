/*
   Copyright 2009 IBM Corp

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package cue.lang.unicode;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Feinberg <jdf@us.ibm.com>
 *
 */
public abstract class Normalizer {

    public static Normalizer getInstance() {
        return INSTANCE;
    }

    abstract public String normalize(final String s);

    private static final Normalizer INSTANCE;

    static {
        try {
            INSTANCE = (Normalizer) Class.forName(getNormalizerClass())
                    .getConstructor().newInstance();
        } catch (final ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getNormalizerClass() {

        try {
            Class.forName("java.text.Normalizer");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Normalizer.class.getName()).log(Level.SEVERE, null, ex);
        }
            return "cue.lang.unicode.Normalizer6";        
    }
}
