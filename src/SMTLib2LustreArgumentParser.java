import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

public class SMTLib2LustreArgumentParser extends ArgumentParser {
    private static final String NODENAME = "main";
    private static final String OBSERVER = "observer";


    private final SMTLib2LustreSettings settings;

    private SMTLib2LustreArgumentParser() {
        this("SMTLib2Lustre", new SMTLib2LustreSettings());
    }

    private SMTLib2LustreArgumentParser(String name, SMTLib2LustreSettings settings) {
        super(name, settings);
        this.settings = settings;
    }

    @Override
    protected Options getOptions() {
        Options options = super.getOptions();
        options.addOption(NODENAME, true, "name of main node in lustre contract file (default: 'main') ");
        options.addOption(OBSERVER, true, "file name for lustre file containing synchronous observer contract to use as harness (default: null)");
        return options;
    }

    public static SMTLib2LustreSettings parse(String[] args) {
        SMTLib2LustreArgumentParser parser = new SMTLib2LustreArgumentParser();
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

        ensureInclusive(line, NODENAME, OBSERVER);

        if (line.hasOption(NODENAME)) {
            settings.main = line.getOptionValue(NODENAME);
        }
        
        if (line.hasOption(OBSERVER)) {
        	settings.observer = line.getOptionValue(OBSERVER);
        }
    }
}
