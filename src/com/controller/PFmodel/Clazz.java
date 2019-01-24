package com.controller.PFmodel;

import java.util.List;
	public  class Clazz {
		private String name; 
		private String type; 
		private String clazz; 
		private List<Param> variables; 
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getClazz() {
			return clazz;
		}

		public void setClazz(String clazz) {
			this.clazz = clazz;
		}

		public List<Param> getVariables() {
			return variables;
		}

		public void setVariables(List<Param> variables) {
			this.variables = variables;
		}

	}