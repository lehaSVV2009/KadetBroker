package com.kadet.kadetBroker.to;

import java.io.Serializable;

/**
 * Date: 25.05.14
 * Time: 11:42
 *
 * @author SarokaA
 */
public interface Entity <I> extends Serializable {

    public I getId ();
    public void setId(I id);

}
