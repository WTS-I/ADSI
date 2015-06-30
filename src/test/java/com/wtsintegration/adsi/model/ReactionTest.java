package com.wtsintegration.adsi.model;

import junit.framework.TestCase;

public class ReactionTest extends TestCase {

	Reaction reaction;

	public void setUp() throws Exception {
		super.setUp();
		reaction = new Reaction();

	}

	public void tearDown() throws Exception {
		reaction = null;
	}
	
	public void testGetPreferredTerm() throws Exception {
        String preferredTerm = "preferredTerm";
        reaction.setPreferredTerm(preferredTerm);
        assertEquals(preferredTerm, reaction.getPreferredTerm());
    }

    public void testSetPreferredTerm() throws Exception {
        String preferredTerm = "preferredTerm";
        reaction.setPreferredTerm(preferredTerm);
        assertEquals(preferredTerm, reaction.getPreferredTerm());
    }
    
    public void testGetName() throws Exception {
        String preferredTerm = "preferredTerm";
        reaction.setPreferredTerm(preferredTerm);
        assertEquals(preferredTerm, reaction.getName());
    }

}
