package com.wtsintegration.adsi.model;

import java.math.BigDecimal;

public class DrugReactionCorrelation {

	private Drug drug;
	private Reaction reaction;
	
	private BigDecimal reportingOddsRatio;
	private BigDecimal proportionalReportingRatio;
	private BigDecimal relativeReportingRatio;
	
	public DrugReactionCorrelation() { }
	
	public DrugReactionCorrelation(Drug drug, Reaction reaction) {
		this.drug = drug;
		this.reaction = reaction;
	}
	
	public DrugReactionCorrelation(Drug drug, Reaction reaction, BigDecimal reportingOddsRatio, BigDecimal proportionalReportingRatio, BigDecimal relativeReportingRatio) {
		this.drug = drug;
		this.reaction = reaction;
		this.reportingOddsRatio = reportingOddsRatio;
		this.proportionalReportingRatio = proportionalReportingRatio;
		this.relativeReportingRatio = relativeReportingRatio;
	}
	
	public Drug getDrug() {
		return drug;
	}
	
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	
	public Reaction getReaction() {
		return reaction;
	}
	
	public void setReaction(Reaction reaction) {
		this.reaction = reaction;
	}
	
	public BigDecimal getReportingOddsRatio() {
		return reportingOddsRatio;
	}
	
	public void setReportingOddsRatio(BigDecimal reportingOddsRatio) {
		this.reportingOddsRatio = reportingOddsRatio;
	}
	
	public BigDecimal getProportionalReportingRatio() {
		return proportionalReportingRatio;
	}
	
	public void setProportionalReportingRatio(BigDecimal proportionalReportingRatio) {
		this.proportionalReportingRatio = proportionalReportingRatio;
	}
	
	public BigDecimal getRelativeReportingRatio() {
		return relativeReportingRatio;
	}
	
	public void setRelativeReportingRatio(BigDecimal relativeReportingRatio) {
		this.relativeReportingRatio = relativeReportingRatio;
	}
}