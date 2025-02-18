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
 * Exception class used for handling errors during QR code generation. This exception is thrown when there is an issue with generating a QR code or adding a
 * logo. It provides constructors for specifying an error message and/or the cause of the error.
 */
public class QrCodeGeneratorException extends Exception
{

    /**
     * A unique identifier for this class version. This is used for serializing instances of this class if needed.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new QrCodeGeneratorException with the specified error message.
     * 
     * @param message
     *            The detail message, which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public QrCodeGeneratorException( String message )
    {
        super( message );
    }

    /**
     * Constructs a new QrCodeGeneratorException with the specified error message and cause.
     * 
     * @param message
     *            The detail message, which is saved for later retrieval by the {@link #getMessage()} method.
     * @param cause
     *            The cause of the exception (which can be retrieved later using {@link #getCause()}).
     */
    public QrCodeGeneratorException( String message, Throwable cause )
    {
        super( message, cause );
    }
}
