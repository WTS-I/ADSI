package com.wtsintegration.openfda.model;

import org.codehaus.jackson.annotate.*;

/**
 * Calls used to represent the FDA reaction JSON object
 * @author John Oo
 *
 */
@org.codehaus.jackson.annotate.JsonAutoDetect(value = org.codehaus.jackson.annotate.JsonMethod.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FdaReaction {
    
	@org.codehaus.jackson.annotate.JsonProperty
	private String reactionmeddrapt;
	
	@org.codehaus.jackson.annotate.JsonProperty
	private String reactionmeddraversionpt;
	
	@org.codehaus.jackson.annotate.JsonProperty
	private String reactionoutcome;

	public String getReactionmeddrapt() {
		return reactionmeddrapt;
	}

	public void setReactionmeddrapt(String reactionmeddrapt) {
		this.reactionmeddrapt = reactionmeddrapt;
	}

	public String getReactionmeddraversionpt() {
		return reactionmeddraversionpt;
	}

	public void setReactionmeddraversionpt(String reactionmeddraversionpt) {
		this.reactionmeddraversionpt = reactionmeddraversionpt;
	}

	public String getReactionoutcome() {
		return reactionoutcome;
	}

	public void setReactionoutcome(String reactionoutcome) {
		this.reactionoutcome = reactionoutcome;
	}

	@Override
	public String toString() {
		return "FdaReaction [reactionmeddrapt=" + reactionmeddrapt
				+ ", reactionmeddraversionpt=" + reactionmeddraversionpt
				+ ", reactionoutcome=" + reactionoutcome + "]";
	}
	
	
	
}
