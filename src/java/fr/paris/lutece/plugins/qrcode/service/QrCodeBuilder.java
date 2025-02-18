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

import java.util.HashMap;
import java.util.Map;

import fr.paris.lutece.plugins.qrcode.IQrCodeGenerator;

/**
 * Builder class for constructing instances of {@link QrCodeGenerator}.
 * <p>
 * This class provides a fluent API for setting various properties of the QR code generator, such as the message, additional parameters, error correction level,
 * and logo. The builder pattern ensures that the configuration of the QR code generator can be customized step by step before the final object is created.
 * </p>
 */
public class QrCodeBuilder
{

    /**
     * The message that will be encoded in the QR code.
     */
    protected String message;

    /**
     * A map containing parameters to be appended to the message in the QR code. These parameters are included in the URL query string.
     */
    protected Map<String, String> parameters = new HashMap<>( );

    /**
     * Flag indicating whether the QR code should include additional parameters. Defaults to {@code false}.
     */
    protected boolean withParameters = false;

    /**
     * The error correction level to be used for the QR code. Defaults to {@link CorrectionLevel#MEDIUM}.
     */
    protected CorrectionLevel correctionLevel = CorrectionLevel.MEDIUM;

    /**
     * An instance of {@link LogoQrCode} that manages logo handling for the QR code. Defaults to {@code null}.
     */
    protected LogoQrCode logo = null;

    /**
     * Constructs a new {@link QrCodeBuilder} with the specified message.
     * 
     * @param message
     *            The message that will be encoded in the QR code.
     */
    public QrCodeBuilder( String message )
    {
        this.message = message;
    }

    /**
     * Adds a single parameter to be included in the QR code's message. The parameter will be appended to the URL query string in the format {@code key=value}.
     * 
     * @param key
     *            The key for the parameter.
     * @param value
     *            The value for the parameter.
     * @return The current {@link QrCodeBuilder} instance for method chaining.
     */
    public QrCodeBuilder addParameter( String key, String value )
    {
        this.withParameters = true;
        parameters.put( key, value );
        return this;
    }

    /**
     * Adds multiple parameters to be included in the QR code's message. These parameters will be appended to the URL query string.
     * 
     * @param parameters
     *            A map of parameters to be added.
     * @return The current {@link QrCodeBuilder} instance for method chaining.
     */
    public QrCodeBuilder addParameters( Map<String, String> parameters )
    {
        this.withParameters = true;
        this.parameters.putAll( parameters );
        return this;
    }

    /**
     * Sets the error correction level to be used when generating the QR code. The error correction level affects how much data can be corrected if the QR code
     * is damaged or incomplete.
     * 
     * @param correctionLevel
     *            The desired error correction level.
     * @return The current {@link QrCodeBuilder} instance for method chaining.
     */
    public QrCodeBuilder withCorrectionLevel( CorrectionLevel correctionLevel )
    {
        this.correctionLevel = correctionLevel;
        return this;
    }

    /**
     * Sets a {@link LogoQrCode} for embedding a logo in the center of the QR code. This allows for customization of the logo's scale and provides the logo
     * image.
     * 
     * @param logoHandler
     *            The {@link LogoQrCode} instance containing logo settings.
     * @return The current {@link QrCodeBuilder} instance for method chaining.
     */
    public QrCodeBuilder addLogo( LogoQrCode logoHandler )
    {
        this.logo = logoHandler;
        return this;
    }

    /**
     * Builds and returns an instance of {@link QrCodeGenerator} based on the current builder configuration. The configuration includes the message, parameters,
     * error correction level, and logo handler.
     * 
     * @return A new {@link QrCodeGenerator} instance configured according to the builder's properties.
     */
    public IQrCodeGenerator build( )
    {
        return new QrCodeGenerator( this );
    }
}
