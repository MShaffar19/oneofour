/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.oneofour.asdu.message;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.oneofour.ProtocolOptions;
import org.eclipse.oneofour.asdu.ASDUHeader;
import org.eclipse.oneofour.asdu.types.ASDU;
import org.eclipse.oneofour.asdu.types.InformationEntry;
import org.eclipse.oneofour.asdu.types.InformationObjectAddress;
import org.eclipse.oneofour.asdu.types.InformationStructure;
import org.eclipse.oneofour.asdu.types.Value;

@ASDU ( id = 13, name = "M_ME_NC_1", informationStructure = InformationStructure.SINGLE )
public class MeasuredValueShortFloatingPointSingle extends AbstractMeasuredValueFloatingPoint
{
    private MeasuredValueShortFloatingPointSingle ( final ASDUHeader header, final List<InformationEntry<Float>> entries )
    {
        super ( header, entries, false );
    }

    public static MeasuredValueShortFloatingPointSingle parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        return new MeasuredValueShortFloatingPointSingle ( header, parseEntries ( options, length, data, false ) );
    }

    public static MeasuredValueShortFloatingPointSingle create ( final ASDUHeader header, final InformationObjectAddress address, final Value<Float> value )
    {
        return createInternal ( header, Collections.singletonList ( new InformationEntry<> ( address, value ) ) );
    }

    public static MeasuredValueShortFloatingPointSingle create ( final ASDUHeader header, final List<InformationEntry<Float>> values )
    {
        if ( values.size () > MAX_INFORMATION_ENTRIES )
        {
            throw new IllegalArgumentException ( String.format ( "A maximum of %s values can be transmitted", MAX_INFORMATION_ENTRIES ) );
        }
        return createInternal ( header, new ArrayList<> ( values ) );
    }

    private static MeasuredValueShortFloatingPointSingle createInternal ( final ASDUHeader header, final List<InformationEntry<Float>> values )
    {
        return new MeasuredValueShortFloatingPointSingle ( header, values );
    }

}
