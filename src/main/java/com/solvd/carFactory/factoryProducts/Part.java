package com.solvd.carFactory.factoryProducts;

import java.util.HashMap;

public class Part extends Product{
		private String description;
		private String material;
		private Integer warranty;
		private HashMap<String,String> otherCharacteristics;//characteristic key, value
		
		public Part() {
			otherCharacteristics = new HashMap<String,String>();
		}
		
		public String getDescription() {
			return description;
		}
		
		public String getMaterial() {
			return material;
		}
		
		public Integer getWarranty() {
			return warranty;
		}
		
		public void setDescription(String description) {
			this.description = description;
		}
		
		public void setMaterial(String material) {
			this.material = material;
		}
		
		public void setWarranty(Integer warranty) {
			this.warranty = warranty;
		}		
		
		public HashMap<String, String> getOtherCharacteristics() {
			return otherCharacteristics;
		}
		
		public void addOtherCharacteristics(String key, String value) {
			this.otherCharacteristics.put(key, value);
		}
}
