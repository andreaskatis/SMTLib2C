import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

public class SMTLib2CArgumentParser extends ArgumentParser {
    private static final String CHARNESS = "c_harness";
    private static final String LUSTREC = "lustrec_harness";
    private static final String RNGVALUES = "rngvalues";
    private static final String NODENAME = "lustrecnode";
    private static final String ITERATION = "iter";


    private final SMTLib2CSettings settings;

    private SMTLib2CArgumentParser() {
        this("SMTLib2C", new SMTLib2CSettings());
    }

    private SMTLib2CArgumentParser(String name, SMTLib2CSettings settings) {
        super(name, settings);
        this.settings = settings;
    }

    @Override
    protected Options getOptions() {
        Options options = super.getOptions();
        options.addOption(CHARNESS, false, "generate harness code for implementation");
        options.addOption(LUSTREC, false, "currently not usable");
        options.addOption(RNGVALUES, false, "incorporate a RNG function to program (fuzzer synthesis)");
        options.addOption(NODENAME, true, "name of main node in original lustre file (have to use with lustrec_harness)");
        options.addOption(ITERATION, true, "determine number of iterations for harness code (have to use with either" +
                "c_harness or lustrec_harness");
        return options;
    }

    public static SMTLib2CSettings parse(String[] args) {
        SMTLib2CArgumentParser parser = new SMTLib2CArgumentParser();
        parser.parseArguments(args);
        return parser.settings;
    }

    @Override
    protected void parseCommandLine(CommandLine line) {
        if (line.hasOption(VERSION)) {
            Output.println(name + " " + Main.VERSION);
            System.exit(0);
        }

        super.parseCommandLine(line);

        ensureInclusive(line, CHARNESS, ITERATION);
        ensureInclusive(line, LUSTREC, ITERATION);
        ensureInclusive(line, LUSTREC, NODENAME);

        if (line.hasOption(CHARNESS)) {
            settings.harnessC = true;
        }

        if (line.hasOption(LUSTREC)) {
            settings.harnessLustreC = true;
        }

        if (line.hasOption(RNGVALUES)) {
            settings.rngvalues = true;
        }

        if (line.hasOption(ITERATION)) {
            settings.iteration = parseNonnegativeInt(line.getOptionValue(ITERATION));
        }

        if (line.hasOption(NODENAME)) {
            settings.lustrecnode = line.getOptionValue(NODENAME);
        }
    }
}
