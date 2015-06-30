package com.wtsintegration.openfda.model;

import junit.framework.TestCase;

public class FdaReactionTest extends TestCase {

	FdaReaction fdaReaction;

	public void setUp() throws Exception {
		super.setUp();
		fdaReaction = new FdaReaction();

	}

	public void tearDown() throws Exception {
		fdaReaction = null;
	}

	public void testGetReactionmeddrapt() throws Exception {
        String reactionmeddrapt = "reactionmeddrapt";
        fdaReaction.setReactionmeddrapt(reactionmeddrapt);
        assertEquals(reactionmeddrapt, fdaReaction.getReactionmeddrapt());
    }

    public void testSetReactionmeddrapt() throws Exception {
        String reactionmeddrapt = "reactionmeddrapt";
        fdaReaction.setReactionmeddrapt(reactionmeddrapt);
        assertEquals(reactionmeddrapt, fdaReaction.getReactionmeddrapt());
    }
    
    public void testGetReactionmeddraversionpt() throws Exception {
        String reactionmeddraversionpt = "reactionmeddraversionpt";
        fdaReaction.setReactionmeddraversionpt(reactionmeddraversionpt);
        assertEquals(reactionmeddraversionpt, fdaReaction.getReactionmeddraversionpt());
    }

    public void testSetReactionmeddraversionpt() throws Exception {
        String reactionmeddraversionpt = "reactionmeddraversionpt";
        fdaReaction.setReactionmeddraversionpt(reactionmeddraversionpt);
        assertEquals(reactionmeddraversionpt, fdaReaction.getReactionmeddraversionpt());
    }
    
    public void testGetReactionoutcome() throws Exception {
        String reactionoutcome = "reactionoutcome";
        fdaReaction.setReactionoutcome(reactionoutcome);
        assertEquals(reactionoutcome, fdaReaction.getReactionoutcome());
    }

    public void testSetReactionoutcome() throws Exception {
        String reactionoutcome = "reactionoutcome";
        fdaReaction.setReactionoutcome(reactionoutcome);
        assertEquals(reactionoutcome, fdaReaction.getReactionoutcome());
    }
    
    public void testToString() throws Exception {
    	String s = fdaReaction.toString();
		assertNotNull(s);
		assertTrue(s.length() > 0);
    }

}
