//Ejemplo de una clase para Configurar la disposicion de los Nodos.

package com.blu.imdg;

import org.apache.ignite.IgniteException;
import org.apache.ignite.lifecycle.LifecycleBean;
import org.apache.ignite.lifecycle.LifecycleEventType;

public class CustomLifecycleBean implements LifecycleBean {
  
    private LifecycleEventType lifecycleEventType;

    @Override
    public void onLifecycleEvent(LifecycleEventType lifecycleEventType) throws IgniteException {
    
        if (lifecycleEventType == LifecycleEventType.AFTER_NODE_START) {
            // ...
        }
        if(lifecycleEventType == LifecycleEventType.BEFORE_NODE_START) {
            // ...
        }
        if(lifecycleEventType == LifecycleEventType.AFTER_NODE_STOP) {
            // ...
        }
        if(lifecycleEventType == LifecycleEventType.BEFORE_NODE_STOP) {
            // ...
        }
    
    }
}