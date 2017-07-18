require.config({
	paths: {
		// jQuery Js
		"jquery":["//cdn.bootcss.com/jquery/3.2.1/jquery.min", "//cdn.bootcss.com/jquery/3.2.1/jquery"],
		"datatables.net": "//cdn.bootcss.com/datatables/1.10.15/js/jquery.dataTables",
		"bootstrapDT": "//cdn.bootcss.com/datatables/1.10.15/js/dataTables.bootstrap",
		"bootstrap-select": "//cdn.bootcss.com/bootstrap-select/1.12.3/js/bootstrap-select.min",
	},
});

define(['jquery', 'datatables.net', 'bootstrapDT', 'bootstrap-select'], function($, dtnet, dataTable, btselect) {
	"use strict"
	
	function loadRoles(selector) {
		selector.selectpicker({
			'selectedText': 'admin',
			'size': 8,
		});
	}
	
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
			
			$("#addModal").on("shown.bs.modal", function() {
				loadRoles($("#roleType"));
			});
		},
	};
});
