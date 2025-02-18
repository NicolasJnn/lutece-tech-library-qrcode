/*
 * Copyright (c) 2002-2025, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.qrcode.service;

/**
 * Enum representing the error correction levels for a QR code. The error correction level determines the amount of redundancy (error protection) in the QR
 * code. A higher error correction level allows the QR code to be read correctly even if part of the code is damaged.
 */
public enum CorrectionLevel
{
    /**
     * The QR Code can tolerate about 7% erroneous codewords.
     */
    LOW( 1 ),

    /**
     * The QR Code can tolerate about 15% erroneous codewords.
     */
    MEDIUM( 0 ),

    /**
     * The QR Code can tolerate about 25% erroneous codewords.
     */
    QUARTILE( 3 ),

    /**
     * The QR Code can tolerate about 30% erroneous codewords.
     */
    HIGH( 2 );

    /**
     * The integer value representing the error correction level. This value is used internally to configure the error correction behavior in the QR code.
     */
    private final int value;

    /**
     * Constructs a {@link CorrectionLevel} with the specified integer value.
     * 
     * @param value
     *            The integer value representing the error correction level.
     */
    CorrectionLevel( int value )
    {
        this.value = value;
    }

    /**
     * Returns the integer value associated with this error correction level.
     * 
     * @return The integer value of the error correction level.
     */
    public int getValue( )
    {
        return value;
    }
}
