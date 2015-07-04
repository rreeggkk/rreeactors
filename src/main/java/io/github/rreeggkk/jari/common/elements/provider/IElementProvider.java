package io.github.rreeggkk.jari.common.elements.provider;

import java.util.Map;

public interface IElementProvider {
	public double getNeutronHitChance(boolean isThermalNeutron);

	public double getNeutronAbsorbChance(boolean isThermalNeutron);

	public double getNeutronFissionChance(boolean isThermalNeutron);

	/**
	 * Get the chance that this element will spontaneously fission (No neutron used) per gram
	 * 
	 * @return [0-1] percent chance to fission/kg (Defines how much matter fissions) (By kilogram)
	 */
	public double getSpontaneousFissionChance();

	/**
	 * Get the amount of RF generated per gram of the substance fissioned
	 * 
	 * @return RF/g fission output energy
	 */
	public double getFissionEnergy();

	public double getOutputNeutrons(boolean isThermalNeutron);

	public Map<String, Double> doFission(boolean absorbed,
			double amountFissioned);

	public double getFusionEnergy();

	public Map<String, Double> getFusionRequirements();

	public double getFusionOutputEnergy();

	public Map<String, Double> getFusionOutput();
	
	public double getMolarMass();

	public abstract class BaseProvider implements IElementProvider {

		protected double spontFiss, fissEn;
		protected double fusEnReq, fusEnOut;

		public BaseProvider() {
		}

		public BaseProvider(double spontFiss, double fissEn, double fusEnReq,
				double fusEnOut) {
			this.spontFiss = spontFiss;
			this.fissEn = fissEn;
			this.fusEnReq = fusEnReq;
			this.fusEnOut = fusEnOut;
		}

		@Override
		public double getSpontaneousFissionChance() {
			return spontFiss;
		}

		@Override
		public double getFissionEnergy() {
			return fissEn;
		}

		@Override
		public double getFusionEnergy() {
			return fusEnReq;
		}

		@Override
		public double getFusionOutputEnergy() {
			return fusEnOut;
		}
	}
}