/**
 * role.js
 * 
 * @author Dragon.Wang
 * 
 * 
 */

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
	
	var _tableRole;
	
	function getTableSelectedData() {
		return _tableRole.rows('.selected').data();
	}
	
	function autoHideMessage(milli) {
		clearTimeout(timeoutEvent);
		timeoutEvent = setTimeout(function() {
							$("#message").hide(1000);
							$("#message").html("");
							$("#message").show();
							$("#message").attr('style', 'display:block');
						}, milli || 5000);
	}
	
	return {
		/*
		 * 全局管理 - 账号管理页面的初始化
		 */
		initFunction : function() {
			// 列表初始化
			_tableRole = $("#dt_role_list").dataTable({
				stateSave: true,
				autowidth: true,
				ajax: {
			        "url": '/admin/mgr/role',
			        "type": 'POST',
			    },
				columns : [
					// 后台属性名字
		            { "data": "id" },
		            { "data": "code"},
		            { "data": "description"},
		        ],
		        
		        columnDefs : [
		              {
		                "targets": [ 0 ],
		                "visible": false,
		                "searchable": false
		              },
                ]
			});
		}
	};
});
