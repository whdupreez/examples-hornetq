package com.willydupreez.examples.hornetq;

public class JmsProperties {

	private boolean jmsPersistenceEnabled = false;
	private String jmsJournalDirectory = "build/data/journal";
	private boolean jmsSecurityEnabled = false;

	public boolean isJmsPersistenceEnabled() {
		return jmsPersistenceEnabled;
	}

	public void setJmsPersistenceEnabled(boolean jmsPersistenceEnabled) {
		this.jmsPersistenceEnabled = jmsPersistenceEnabled;
	}

	public String getJmsJournalDirectory() {
		return jmsJournalDirectory;
	}

	public void setJmsJournalDirectory(String jmsJournalDirectory) {
		this.jmsJournalDirectory = jmsJournalDirectory;
	}

	public boolean isJmsSecurityEnabled() {
		return jmsSecurityEnabled;
	}

	public void setJmsSecurityEnabled(boolean jmsSecurityEnabled) {
		this.jmsSecurityEnabled = jmsSecurityEnabled;
	}

}
