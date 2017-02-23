/*
 * Mule ESB Maven Tools
 * <p>
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.tools.artifact.archiver.internal.type;

import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mule.tools.artifact.archiver.api.PackageBuilder;
import org.mule.tools.artifact.archiver.internal.packaging.type.PackagingType;
import org.mule.tools.artifact.archiver.internal.packaging.type.SourcesType;

import java.io.File;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.mockito.Mockito.*;

public class SourcesTypeTest {

    private PackagingType packagingType = new SourcesType();

    @Test
    public void validateListDirectories() {
        assertThat("Directories set should not be null", packagingType.listDirectories(), notNullValue());
        assertThat("Directories set is not as expected", packagingType.listDirectories(),
                   containsInAnyOrder(PackageBuilder.MULE_SRC_FOLDER));
    }

    @Test
    public void validateListFiles() {
        assertThat("Files set should not be null", packagingType.listFiles(), notNullValue());
        assertThat("Files set should be empty", packagingType.listFiles(), empty());
    }


    @Test
    public void applyPackagingTest() {
        PackageBuilder packageBuilderMock = mock(PackageBuilder.class);

        //        when(packageBuilderMock.withMetaInf(ArgumentMatchers.any())).thenReturn(packageBuilderMock);

        Map<String, File> fileMapMock = mock(Map.class);

        packagingType.applyPackaging(packageBuilderMock, fileMapMock);

        verify(packageBuilderMock, times(0)).withClasses(ArgumentMatchers.any());
        verify(packageBuilderMock, times(0)).withMule(ArgumentMatchers.any());
        //        verify(packageBuilderMock, times(1)).withMetaInf(ArgumentMatchers.any());
    }
} 