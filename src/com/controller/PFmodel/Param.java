package com.controller.PFmodel;
	//参数
	public class Param {
		private String name; // 对象字段名程 属性名
		private String label;// 对象字段描述
		private String type; // 对象字段类型 如String Boolean
		private String defaultValue;// 对象的字段值
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getDefaultValue() {
			return defaultValue;
		}

		public void setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
		}

	}
