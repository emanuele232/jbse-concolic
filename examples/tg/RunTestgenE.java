package tg;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import common.Settings;
import exec.Main;
import exec.Options;

public class RunTestgenE {
	public static void main(String[] s) throws IOException {
		final String className = "tg/TestgenE";
		final String parametersSignature = "(IIIIIIII)Z";
		final String methodName  = "getBool";
		final String testClass = "tg/TestE";
		final String testMethodSignature = "()V";
		final String testMethod = "test0";
		final int maxDepth = 50;
		final int numOfThreads = 5;
		final long timeBudgetDuration = 10;
		final TimeUnit timeBudgetTimeUnit = TimeUnit.MINUTES;
		
		final Options o = new Options();
		o.setTargetMethod(className, parametersSignature, methodName);
		o.setInitialTestCase(testClass, testMethodSignature, testMethod);
		o.setMaxDepth(maxDepth);
		o.setNumOfThreads(numOfThreads);
		o.setTmpDirectoryBase(Settings.TMP_BASE_PATH);
		o.setZ3Path(Settings.Z3_PATH);
		o.setJBSELibraryPath(Settings.JBSE_PATH);
		o.setJREPath(Settings.JRE_PATH);
		o.setClassesPath(Settings.BIN_PATH);
		o.setOutDirectory(Settings.OUT_PATH);
		o.setSushiLibPath(Settings.SUSHI_LIB_PATH);
		o.setEvosuitePath(Settings.EVOSUITE_MOSA_PATH);
		o.setUseMOSA(true);
		o.setNumMOSATargets(1);
		o.setGlobalTimeBudgetDuration(timeBudgetDuration);
		o.setGlobalTimeBudgetUnit(timeBudgetTimeUnit);
	
		final Main m = new Main(o);
		m.start();
	}
}
