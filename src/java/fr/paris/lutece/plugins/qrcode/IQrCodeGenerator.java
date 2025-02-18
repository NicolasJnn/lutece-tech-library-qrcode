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
package fr.paris.lutece.plugins.qrcode;

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;

import fr.paris.lutece.plugins.qrcode.service.CorrectionLevel;

/**
 * Interface representing a QR code generator. This interface defines the methods needed for creating a QR code and adding a logo to it.
 */
public interface IQrCodeGenerator
{

    /**
     * Returns the message encoded in the QR code.
     *
     * @return The message to encode in the QR code.
     */
    String getMessage( );

    /**
     * Indicates whether the QR code should include additional parameters.
     *
     * @return true if the QR code should include parameters, false otherwise.
     */
    boolean isWithParameters( );

    /**
     * Returns the error correction level of the QR code.
     *
     * @return The error correction level (LOW, MEDIUM, HIGH, etc.).
     */
    CorrectionLevel getCorrectionLevel( );

    /**
     * Generates the QR code image.
     *
     * @return The generated QR code image with default values.
     * @throws UnsupportedEncodingException
     *             If text encoding fails.
     */
    BufferedImage toImage( ) throws Exception;

}
