import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class BatchRun {

	public static void main(String [] args) {
		String skolemDirName = args[0];
		String lustreDirName = args[1]; 
		File skolemDir = new File(skolemDirName);
		File lustreDir = new File(lustreDirName);
		
		try {
			for (File skolem: skolemDir.listFiles()) {
				if (!skolem.getName().endsWith(".smt2"))
					continue;
				
				System.out.println("Generating jkind file for: " + skolem.getCanonicalPath());
				String truename = skolem.getName().substring(0, skolem.getName().lastIndexOf("_"));
				File contractFile = new File(lustreDir, truename + ".lus");
				System.out.println("Using contract file: " + contractFile.getCanonicalPath());
				String [] s2largs = new String [3]; 
				s2largs[0] = "-observer"; 
				s2largs[1] = contractFile.getCanonicalPath();
				s2largs[2] = skolem.getCanonicalPath(); 
				try {
					SMTLib2Lustre.main(s2largs);
				} catch (Throwable e) {
					System.out.println("FAILED FOR MODEL: " + skolem.getCanonicalPath());
				}
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
	}
}
