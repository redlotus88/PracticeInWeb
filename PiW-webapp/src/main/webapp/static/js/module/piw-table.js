require.config({
	// define required js.
	baseUrl: "/static/js",
	paths: {
		"jquery":["//cdn.bootcss.com/jquery/3.2.1/jquery.min", "//cdn.bootcss.com/jquery/3.2.1/jquery"],
	}
})

define(["jquery"], function($) {
	"use strict"
	return {
		// write method. for usage.
		test : function() {
			
		}
	};
})
