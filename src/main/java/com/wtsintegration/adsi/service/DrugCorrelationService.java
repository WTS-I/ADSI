package com.wtsintegration.adsi.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.wtsintegration.adsi.client.DrugClient;
import com.wtsintegration.adsi.model.Drug;
import com.wtsintegration.adsi.model.DrugReactionCorrelation;
import com.wtsintegration.adsi.model.Reaction;

public class DrugCorrelationService {

	private DrugClient drugClient;
	private Drug drug;
	private Reaction reaction;
	private BigDecimal total;
	private BigDecimal totalForDrug;
	private BigDecimal totalForReaction;
	private BigDecimal totalForDrugAndReaction;
	private BigDecimal totalForDrugExcludeReaction;
	private BigDecimal totalForReactionExcludeDrug;
	private BigDecimal totalExcludeDrugAndReaction;
	
	public DrugCorrelationService(Drug drug, Reaction reaction) {
		this.drugClient = new DrugClient();
		this.drug = drug;
		this.reaction = reaction;
		total = null;
		totalForDrug = null;
		totalForReaction = null;
		totalForDrugAndReaction = null;
		totalForDrugExcludeReaction = null;
		totalForReactionExcludeDrug = null;
		totalExcludeDrugAndReaction = null;
	}
	
	public DrugReactionCorrelation generateCorrelation() {
		DrugReactionCorrelation correlation = new DrugReactionCorrelation(drug, reaction);
		correlation.setReportingOddsRatio(getROR());
		correlation.setProportionalReportingRatio(getPRR());
		correlation.setRelativeReportingRatio(getRRR());
		
		return correlation;
	}
	
	public BigDecimal getROR() {
		BigDecimal ror = null;
		
		if (getTotalForDrugAndReaction() != null
				&& getTotalForDrugExcludeReaction() != null
				&& getTotalForReactionExcludeDrug() != null
				&& getTotalExcludeDrugAndReaction() != null) {
			
			BigDecimal nom = getTotalForDrugAndReaction().multiply(getTotalExcludeDrugAndReaction());
			BigDecimal denom = getTotalForDrugExcludeReaction().multiply(getTotalForReactionExcludeDrug());
			if (denom.compareTo(new BigDecimal(0)) != 0) {
				ror = nom.divide(denom, 2, RoundingMode.HALF_UP);
			}
		}
		
		System.out.println(ror);
		return ror;
	}
	
	public BigDecimal getPRR() {
		BigDecimal prr = null;
		
		if (getTotalForDrugAndReaction() != null
				&& getTotalForDrugExcludeReaction() != null
				&& getTotalForReactionExcludeDrug() != null
				&& getTotalExcludeDrugAndReaction() != null) {
			
			BigDecimal nom = getTotalForDrugAndReaction().multiply( 
					getTotalForReactionExcludeDrug().add(getTotalExcludeDrugAndReaction()));
			BigDecimal denom = getTotalForReactionExcludeDrug().multiply(
					getTotalForDrugAndReaction().add(getTotalForDrugExcludeReaction()));
					
			if (denom.compareTo(new BigDecimal(0)) != 0) {
				prr = nom.divide(denom, 2, RoundingMode.HALF_UP);
			}
		}
		
		System.out.println(prr);
		
		return prr;
	}
	
	public BigDecimal getRRR() {
		BigDecimal rrr = null;
		
		if (getTotal() != null 
				&& getTotalForDrugAndReaction() != null
				&& getTotalForDrugExcludeReaction() != null
				&& getTotalForReactionExcludeDrug() != null) {
			
			BigDecimal nom = getTotalForDrugAndReaction().multiply(getTotal());
			BigDecimal denom = (getTotalForDrugAndReaction().add(getTotalForDrugExcludeReaction()))
					.multiply(getTotalForDrugAndReaction().add(getTotalForReactionExcludeDrug()));
					
			if (denom.compareTo(new BigDecimal(0)) != 0) {
				rrr = nom.divide(denom, 2, RoundingMode.HALF_UP);
			}
		}
		System.out.println(rrr);
		return rrr;
	}

	public DrugClient getDrugClient() {
		return drugClient;
	}

	public void setDrugClient(DrugClient drugClient) {
		this.drugClient = drugClient;
	}

	public Drug getDrug() {
		return drug;
	}

	public Reaction getReaction() {
		return reaction;
	}

	public BigDecimal getTotal() {
		if (total == null) {
			total = new BigDecimal(drugClient.getCountAllRecords());
		}
		return total;
	}

	public BigDecimal getTotalForDrug() {
		if (totalForDrug == null) {
			totalForDrug = new BigDecimal(drugClient.getCountByDrug(drug));
		}
		return totalForDrug;
	}
	
	public BigDecimal getTotalForReaction() {
		if (totalForReaction == null) {
			totalForReaction = new BigDecimal(drugClient.getCountByReaction(reaction));
		}
		return totalForReaction;
	}

	public BigDecimal getTotalForDrugAndReaction() {
		if (totalForDrugAndReaction == null) {
			totalForDrugAndReaction = new BigDecimal(drugClient.getCountByDrugAndReaction(drug, reaction));
		}
		return totalForDrugAndReaction;
	}

	public BigDecimal getTotalForDrugExcludeReaction() {
		if (totalForDrugExcludeReaction == null) {
			if (getTotalForDrug() != null && getTotalForDrugAndReaction() != null) {
				totalForDrugExcludeReaction = getTotalForDrug().subtract(getTotalForDrugAndReaction());
			}
		}
		return totalForDrugExcludeReaction;
	}

	public BigDecimal getTotalForReactionExcludeDrug() {
		if (totalForReactionExcludeDrug == null) {
			if (getTotalForReaction() != null && getTotalForDrugAndReaction() != null) {
				totalForReactionExcludeDrug = getTotalForReaction().subtract(getTotalForDrugAndReaction());
			} 
		}
		return totalForReactionExcludeDrug;
	}

	public BigDecimal getTotalExcludeDrugAndReaction() {
		if (totalExcludeDrugAndReaction == null) {
			if (getTotal() != null && getTotalForDrug() != null && getTotalForReaction() != null && getTotalForDrugAndReaction() != null) {
				totalExcludeDrugAndReaction = getTotal().subtract(getTotalForDrug().add(getTotalForReaction()).add(getTotalForDrugAndReaction()));
			} 
		}
		return totalExcludeDrugAndReaction;
	}
	
	
}
