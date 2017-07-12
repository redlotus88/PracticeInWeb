require.config({
	paths: {
		// jQuery Js
		"jquery":["//cdn.bootcss.com/jquery/3.2.1/jquery.min", "//cdn.bootcss.com/jquery/3.2.1/jquery"],
		"datatables.net": "//cdn.bootcss.com/datatables/1.10.15/js/jquery.dataTables",
		"bootstrapDT": "//cdn.bootcss.com/datatables/1.10.15/js/dataTables.bootstrap",
	},
});

define(['jquery', 'datatables.net', 'bootstrapDT'], function($, dtnet, dataTable) {
	"use strict"
	return {
		/*
		 * 全局管理 - 账号管理页面的初始化
		 */
		initFunction : function() {
			// 列表初始化
			$("#dt_account_list").dataTable({
				stateSave: true,
				scrollX: "150%",
				ajax: {
			        "url": '/admin/mgr/account',
			        "type": 'POST',
			    },
				columns : [
					// 后台属性名字
		            { "data": "id" },
		            { "data": "accountName" },
		            { "data": "profileName" },
		            { "data": "publicEmail"},
		            { "data": "company"},
		            { "data": "lastLoginTime", "width": "20%"},
		            { "data": "lastModifyTime", "width": "20%"},
		        ]
			});
		}
	};
});
