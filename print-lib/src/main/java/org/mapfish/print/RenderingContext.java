/*
 * Copyright (C) 2008  Camptocamp
 *
 * This file is part of MapFish Server
 *
 * MapFish Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MapFish Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with MapFish Server.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mapfish.print;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import org.mapfish.print.config.Config;
import org.mapfish.print.config.layout.Layout;
import org.mapfish.print.utils.PJsonObject;

/**
 * Holds some "per rendering request" information.
 */
public class RenderingContext {
    private final Document document;
    private final PdfWriter writer;
    private final Config config;
    private final PJsonObject globalParams;
    private final String configDir;
    private final PDFCustomBlocks customBlocks;
    private final Layout layout;

    public RenderingContext(Document document, PdfWriter writer, Config config, PJsonObject globalParams, String configDir, Layout layout) {
        this.document = document;
        this.writer = writer;
        this.config = config;
        this.globalParams = globalParams;
        this.configDir = configDir;
        this.layout = layout;
        customBlocks = new PDFCustomBlocks(writer, this);
    }

    public PDFCustomBlocks getCustomBlocks() {
        return customBlocks;
    }

    public Document getDocument() {
        return document;
    }

    public Config getConfig() {
        return config;
    }

    public PdfWriter getWriter() {
        return writer;
    }

    public PdfContentByte getDirectContent() {
        return writer.getDirectContent();
    }

    public PJsonObject getGlobalParams() {
        return globalParams;
    }

    public String getConfigDir() {
        return configDir;
    }

    public Layout getLayout() {
        return layout;
    }

    public void addError(Exception e) {
        customBlocks.addError(e);
    }
}
