package com.wtsintegration.adsi.model;

import java.math.BigDecimal;

public class DrugReactionCorrelation {

	private Drug drug;
	private Reaction reaction;

	private BigDecimal total;
	private BigDecimal totalForDrug;
	private BigDecimal totalForReaction;
	private BigDecimal totalForDrugAndReaction;
	private BigDecimal totalForDrugExcludeReaction;
	private BigDecimal totalForReactionExcludeDrug;
	private BigDecimal totalExcludeDrugAndReaction;
	
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

	public BigDecimal getTotalForDrugAndReaction() {
		return totalForDrugAndReaction;
	}

	public void setTotalForDrugAndReaction(BigDecimal totalForDrugAndReaction) {
		this.totalForDrugAndReaction = totalForDrugAndReaction;
	}

	public BigDecimal getTotalForDrugExcludeReaction() {
		return totalForDrugExcludeReaction;
	}

	public void setTotalForDrugExcludeReaction(BigDecimal totalForDrugExcludeReaction) {
		this.totalForDrugExcludeReaction = totalForDrugExcludeReaction;
	}

	public BigDecimal getTotalForReactionExcludeDrug() {
		return totalForReactionExcludeDrug;
	}

	public void setTotalForReactionExcludeDrug(BigDecimal totalForReactionExcludeDrug) {
		this.totalForReactionExcludeDrug = totalForReactionExcludeDrug;
	}

	public BigDecimal getTotalExcludeDrugAndReaction() {
		return totalExcludeDrugAndReaction;
	}

	public void setTotalExcludeDrugAndReaction(BigDecimal totalExcludeDrugAndReaction) {
		this.totalExcludeDrugAndReaction = totalExcludeDrugAndReaction;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTotalForDrug() {
		return totalForDrug;
	}

	public void setTotalForDrug(BigDecimal totalForDrug) {
		this.totalForDrug = totalForDrug;
	}

	public BigDecimal getTotalForReaction() {
		return totalForReaction;
	}

	public void setTotalForReaction(BigDecimal totalForReaction) {
		this.totalForReaction = totalForReaction;
	}
	
	public String toString() {
	StringBuffer stringBuffer = new StringBuffer();
	
	// drug, reaction rrr, prr, ror
	stringBuffer.append("[");
	
	stringBuffer.append("\n\t\"");
	stringBuffer.append(getDrug().getName());
	stringBuffer.append("\",");	
	
	stringBuffer.append("\n\t\"");
	stringBuffer.append(getReaction().getPreferredTerm());
	stringBuffer.append("\",");	
	
	stringBuffer.append("\n\t\"");
	stringBuffer.append(getRelativeReportingRatio());
	stringBuffer.append("\",");	
	
	stringBuffer.append("\n\t\"");
	stringBuffer.append(getProportionalReportingRatio());
	stringBuffer.append("\",");
	
	stringBuffer.append("\n\t\"");
	stringBuffer.append(getReportingOddsRatio());
	stringBuffer.append("\"");
	
	stringBuffer.append("\n]");
	
	
	return stringBuffer.toString();
}
}