package common;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class Settings {
	/*Pietro's settings
	public static final Path JBSE_PATH      = Paths.get("/Users", "pietro", "git", "sushi", "jbse", "target", "classes");
	public static final Path EVOSUITE_PATH  = Paths.get("/Users", "pietro", "git", "jbse-concolic", "lib", "evosuite-shaded-1.0.3.jar");
	public static final Path EVOSUITE_MOSA_PATH = Paths.get("/Users", "pietro", "git", "jbse-concolic", "lib", "evosuite-shaded-1.0.6-SNAPSHOT.jar");
	public static final Path SUSHI_LIB_PATH = Paths.get("/Users", "pietro", "git", "sushi", "runtime" , "target", "classes");
	public static final Path Z3_PATH        = Paths.get("/opt", "local", "bin", "z3");
	public static final Path WORKSPACE      = Paths.get("/Users/pietro/git/jbse-concolic/");
	*/
	
	//Emanuele's settings
		public static final Path JBSE_PATH      = Paths.get("/home", "emanuele", "Documenti","scuola", "Tesi", "sushi", "sushi", "jbse", "target", "classes");
		public static final Path EVOSUITE_PATH  = Paths.get("/home", "emanuele", "git", "jbse-concolic", "lib", "evosuite-shaded-1.0.3.jar");
		public static final Path EVOSUITE_MOSA_PATH = Paths.get("/home", "emanuele", "git", "jbse-concolic", "lib", "evosuite-shaded-1.0.6-SNAPSHOT.jar");
		public static final Path SUSHI_LIB_PATH = Paths.get("/home", "emanuele", "Documenti","scuola", "Tesi", "sushi", "sushi", "runtime" , "target", "classes");
		public static final Path Z3_PATH        = Paths.get("/home", "emanuele", "bin", "z3", "build", "z3");
		public static final Path WORKSPACE      = Paths.get("/home/emanuele/git/jbse-concolic/");
	
	
	//these are good for everyone
	public static final Path SRC_PATH       = WORKSPACE.resolve("src");
	public static final Path BIN_PATH       = WORKSPACE.resolve("bin");
	public static final Path OUT_PATH       = WORKSPACE.resolve("testCase");
	public static final Path TMP_BASE_PATH  = WORKSPACE.resolve("tmp");
	public static final Path JRE_PATH       = JBSE_PATH.resolve("../../data/jre/rt.jar");
}
