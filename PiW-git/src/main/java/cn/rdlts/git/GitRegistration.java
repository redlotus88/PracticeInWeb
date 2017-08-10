package cn.rdlts.git;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.Assert;

public class GitRegistration {
	
	private static Map<String, PiWGit> gits = new ConcurrentHashMap<>();
	
	private GitRegistration() {
	}
	
	public static PiWGit getGit(String name) {
		return gits.get(name);
	}
	
	public static void register(PiWGit git) {
		Assert.notNull(git);
		gits.put(git.getUri(), git);
	}
}
