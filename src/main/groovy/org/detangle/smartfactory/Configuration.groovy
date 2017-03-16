package org.detangle.smartfactory

/**
 */
class Configuration implements Map<Class, Object>{

    @Delegate
    Map<Class, Object> definitions = new Hashtable<Class, Object>()

    Class put(Class key, value){
        if(!(value instanceof Closure)){
            return definitions.put(key, {return value})
        }

        return definitions.put(key, value)
    }


}
