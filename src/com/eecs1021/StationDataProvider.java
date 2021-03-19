package com.eecs1021;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.Closeable;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.Instant;
import java.util.stream.Stream;

public class StationDataProvider implements Closeable {
    private static final String[] HEADERS = {
            "ID",
            "Date",
            "Water Level / Niveau d'eau (m)"
    };

    private static final CSVFormat CUSTOM_CSV_FORMAT = CSVFormat.DEFAULT
            .withHeader(HEADERS)
            .withSkipHeaderRecord();

    private static WaterLevel parseRecord(CSVRecord record) {
        /*
        TODO: Implement this method. Specifically, this method should:
         1. Get the raw date and water level values of `record`, using `record.get()`
         2. If either value is `null`, return `null`.
         3. Parse both values. To parse an `Instant`, one can use `Instant.parse()`. To parse a `Double`, one can use `Double.parseDouble()`
         4. Create and return a new `WaterLevel` instance from these values.
         */
        return null;
    }

    private final CSVParser csvParser;

    public StationDataProvider(URL source) throws IOException {
        this.csvParser = CSVParser.parse(source, Charset.defaultCharset(), CUSTOM_CSV_FORMAT);
    }

    public Stream<WaterLevel> getData() throws IOException {
        /*
        TODO: Implement this method. This method should use Java Streams to convert the list of records of the parser
         to a `Stream` of `WaterLevel`s.
         */
        return null;
    }

    @Override
    public void close() throws IOException {
        csvParser.close();
    }
}
