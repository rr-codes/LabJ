package com.eecs1021;

import org.apache.commons.cli.*;
import org.knowm.xchart.BitmapEncoder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    private static Options buildCLIOptions() {
        var options = new Options();

        var modeGroup = new OptionGroup();
        modeGroup.addOption(new Option("g", "graph", false, "creates a graph"));
        modeGroup.addOption(new Option("a", "average", false, "prints the average level"));

        options.addOptionGroup(modeGroup);
        options.addOption("h", "help", false, "help");

        return options;
    }

    private static URL getUrl(String stationCode) throws MalformedURLException {
        /*
        TODO: Compose a URL object for the data URL of the specified station code.
         If the code is `ABC`, then the URL string would be `https://dd.weather.gc.ca/hydrometric/csv/ON/daily/ON_ABC_daily_hydrometric.csv`
         */
        return null;
    }

    public static void main(String[] args) throws ParseException {
        var cliParser = new DefaultParser();
        var options = buildCLIOptions();
        var cmd = cliParser.parse(options, args);

        if (cmd.hasOption('h')) {
            var helpFormatter = new HelpFormatter();
            helpFormatter.printHelp("./labj [-ag] [station]", options);
            System.exit(0);
        }

        var stationCode = cmd.getArgList().get(cmd.getArgList().size() - 1);

        URL url;

        try {
            url = getUrl(stationCode);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try (var provider = new StationDataProvider(url)) {
            System.out.println("Processing...");

            var data = provider.getData();
            var analyzer = new StationAnalyzer(data);

            /*
            TODO: If the user uses the '-a' flag (ie, `cmd.hasOption('a')`), then print the average water level
             to the standard output, and `return`.
             */

            /*
            TODO: If the user uses the `-g` flag (ie, `cmd.hasOption('g')`), then create and save the chart to a file.
             To save the chart, use `BitmapEncoder.saveBitmapWithDPI(chart, "mychart.png", BitmapEncoder.BitmapFormat.PNG, 300);`,
             where `chart` is the name of the chart, `mychart.png` is the name of the file, and `300` is the image DPI.
             */

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
