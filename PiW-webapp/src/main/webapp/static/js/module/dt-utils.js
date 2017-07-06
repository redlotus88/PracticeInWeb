require.config({
	baseUrl: "/static/js/",
	paths: {
		// jQuery Js
		"jquery":["//cdn.bootcss.com/jquery/3.2.1/jquery.min", "//cdn.bootcss.com/jquery/3.2.1/jquery"],
		"datatables.net": "//cdn.bootcss.com/datatables/1.10.15/js/jquery.dataTables",
		"bootstrapDT": "//cdn.bootcss.com/datatables/1.10.15/js/dataTables.bootstrap",
	},
});

define(["jquery", "bootstrapDT", "datatables.net"], function($, dt, dtnet) {
	"use strict"
	return {
		/*
		 * 定义一些公共的方法。
		 */
		init : function(selector) {
			$(selector).DataTable();
		}
	};
});