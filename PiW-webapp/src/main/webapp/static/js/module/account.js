define(function() {
	return {
		
		/**
		 * contains方法测试str2是否是str1的子字符串，
		 * str1 == str2会返回true.
		 */
		contains : function(str1, str2) {
			if (str1 === undefined || str2 === undefined || str1.length == 0 || str2.length == 0) {
				return false;
			}
			
			if (str1.indexOf(str2) > -1) {
				return true;
			}
			
			return false;
		}
	};
});
