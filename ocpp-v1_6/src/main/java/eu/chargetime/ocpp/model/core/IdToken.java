package eu.chargetime.ocpp.model.core;

import eu.chargetime.ocpp.PropertyConstraintException;
import eu.chargetime.ocpp.model.Validatable;
import eu.chargetime.ocpp.utilities.ModelUtil;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * ChargeTime.eu - Java-OCA-OCPP
 *
 * MIT License
 *
 * Copyright (C) 2016 Thomas Volden <tv@chargetime.eu>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Contains the identifier to use for authorization.
 * It is a case insensitive string.
 * <p>
 * In future releases this may become a complex type to support multiple forms of identifiers.
 */
@XmlRootElement
public class IdToken implements Validatable {
    private String idToken;

    @Override
    public boolean validate() {
        return isValidIdToken(idToken);
    }

    /**
     * IdToken is case insensitive.
     *
     * @return Identification of the token.
     */
    public String getIdToken() {
        return idToken;
    }

    /**
     * Required. IdToken is case insensitive.
     *
     * @param idToken                       String, max 20 characters.
     * @throws PropertyConstraintException  Value exceeds 20 characters.
     */
    @XmlElement
    public void setIdToken(String idToken) throws PropertyConstraintException {
        if (!isValidIdToken(idToken))
            throw new PropertyConstraintException("idToken", idToken);

        this.idToken = idToken;
    }

    private boolean isValidIdToken(String idToken) {
        return ModelUtil.validate(idToken, 20);
    }
}
