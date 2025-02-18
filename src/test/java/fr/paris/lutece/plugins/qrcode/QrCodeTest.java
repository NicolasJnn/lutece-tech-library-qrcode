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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import fr.paris.lutece.plugins.qrcode.service.CorrectionLevel;
import fr.paris.lutece.plugins.qrcode.service.LogoQrCode;
import fr.paris.lutece.plugins.qrcode.service.QrCodeBuilder;
import fr.paris.lutece.plugins.qrcode.service.QrCodeGenerator;
import fr.paris.lutece.test.LuteceTestCase;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class QrCodeTest extends TestCase
{

    public static BufferedImage generatesRandomLogo( )
    {
        int width = 640, height = 320;

        Random rd = new Random( );

        // Create buffered image object
        BufferedImage img = null;
        img = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );

        // create random values pixel by pixel
        for ( int y = 0; y < height; y++ )
        {
            for ( int x = 0; x < width; x++ )
            {
                // generating values less than 256
                int a = (int) ( rd.nextInt( 256 ) );
                int r = (int) ( rd.nextInt( 256 ) );
                int g = (int) ( rd.nextInt( 256 ) );
                int b = (int) ( rd.nextInt( 256 ) );

                // pixel
                int p = ( a << 24 ) | ( r << 16 ) | ( g << 8 ) | b;

                img.setRGB( x, y, p );
            }
        }

        return img;
    }

    public void testQrCode( )
    {
        QrCodeBuilder builder = new QrCodeBuilder( "Hello World" );
        QrCodeGenerator qr = (QrCodeGenerator) builder.withCorrectionLevel( CorrectionLevel.HIGH ).build( );
        File file = new File( "./src/test/java/fr/paris/lutece/plugins/qrcode/qr.png" );
        try
        {
            ImageIO.write( qr.toImage( ), "png", file );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
        assertTrue( file.exists( ) );
        assertTrue( file.length( ) != 0L );
        file.delete( );
    }

    public void testQrCodeWithParameter( )
    {
        QrCodeBuilder builder = new QrCodeBuilder( "Hello World" );
        QrCodeGenerator qr = (QrCodeGenerator) builder.withCorrectionLevel( CorrectionLevel.HIGH ).addParameter( "parameter1", "result1" )
                .addParameter( "parameter2", "result2" ).addParameter( "parameter3", "result3" ).build( );
        File file = new File( "./src/test/java/fr/paris/lutece/plugins/qrcode/qr.png" );
        try
        {
            ImageIO.write( qr.toImage( ), "png", file );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
        assertTrue( file.exists( ) );
        assertTrue( file.length( ) != 0L );
        file.delete( );
    }

    public void testQrCodeWithParameters( )
    {
        QrCodeBuilder builder = new QrCodeBuilder( "Hello World" );
        Map<String, String> map = new HashMap<>( );
        map.put( "parameter1", "result1" );
        map.put( "parameter2", "result2" );
        map.put( "parameter3", "result3" );
        QrCodeGenerator qr = (QrCodeGenerator) builder.withCorrectionLevel( CorrectionLevel.HIGH ).addParameters( map ).build( );
        File file = new File( "./src/test/java/fr/paris/lutece/plugins/qrcode/qr.png" );
        try
        {
            ImageIO.write( qr.toImage( ), "png", file );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
        assertTrue( file.exists( ) );
        assertTrue( file.length( ) != 0L );
        file.delete( );
    }

    public void testQrCodeWithLogo( )
    {
        BufferedImage logo = generatesRandomLogo( );
        ByteArrayOutputStream os = new ByteArrayOutputStream( );
        try
        {
            ImageIO.write( logo, "png", os );
        }
        catch( IOException e )
        {
            e.printStackTrace( );
        }
        InputStream is = new ByteArrayInputStream( os.toByteArray( ) );
        QrCodeBuilder builder = new QrCodeBuilder( "Hello World" );
        QrCodeGenerator qr = (QrCodeGenerator) builder.withCorrectionLevel( CorrectionLevel.HIGH ).addLogo( new LogoQrCode( is ) ).build( );
        File file = new File( "./src/test/java/fr/paris/lutece/plugins/qrcode/qr.png" );
        try
        {
            ImageIO.write( qr.toImage( ), "png", file );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
        assertTrue( file.exists( ) );
        assertTrue( file.length( ) != 0L );
        file.delete( );
    }
}
