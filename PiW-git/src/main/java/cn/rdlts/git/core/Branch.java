package cn.rdlts.git.core;

public class Branch {
	
	/**
	 * Branch remote name : refs/heads/master
	 */
	private String name;
	
	/**
	 * objectId for branch : d51129a94d7a31f06b768c715614b10f886dce28
	 */
	private String objectId;
	
	public Branch() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
}
