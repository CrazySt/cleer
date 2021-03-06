package pro.trousev.cleer.commands;

import java.io.PrintStream;
import java.util.List;

import pro.trousev.cleer.Plugin.Interface;
import pro.trousev.cleer.tests.TestDatabase;

public class SystemCommands {
	public static class GarbageCollection extends Command
	{

		@Override
		public String name() {
			return "gc";
		}

		@Override
		public String help(boolean is_short) {
			return "Perform garbage collection manually";
		}

		@Override
		public boolean main(List<String> args, PrintStream stdout,
				Interface iface) {
			System.gc();
			return true;
		}
		
	}
	public static class PerformTests extends Command
	{
		@Override
		public String name()
		{
			return "test";
		}

		@Override
		public String help(boolean is_short) {
			return "Perform autotests";
		}

		@Override
		public boolean main(List<String> args, PrintStream stdout,
				Interface iface) {
			new TestDatabase(iface.storage()).run();
			return true;
		}
		
	}
}
