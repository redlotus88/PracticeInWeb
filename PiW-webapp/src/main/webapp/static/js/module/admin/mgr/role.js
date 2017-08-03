/**
 * role.js
 * 
 * 类似于account.js
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
	var timeoutEvent;
	
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
	
	function disabledButtons() {
		$("#btnDelete").attr('disabled',"true");
        $("#btnUpdate").attr('disabled',"true");
	}
	
	return {
		/*
		 * 全局管理 - 账号管理页面的初始化
		 */
		initFunction : function() {
			// 列表初始化
			_tableRole = $("#dt_role_list").DataTable({
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
			
			$('#dt_role_list tbody').on( 'click', 'tr', function () {
				// 移除所有选择的行
				$('#dt_role_list tbody .selected').each(function() {
					$(this).removeClass('selected');
				});
				
				// 选中当前点击的行 
		        $(this).toggleClass('selected');
		        
		        // 解除更新和删除的禁用状态
		        $("#btnDelete").removeAttr('disabled');
		        $("#btnUpdate").removeAttr('disabled');
		    });
			
			// add模态框 
			$("#addModal").on("shown.bs.modal", function() {
				$("#roleCode").focus();
			});
			
			// update模态框
			$("#updateModal").on("shown.bs.modal", function() {
				var rows = getTableSelectedData();
				if (rows.length < 1) {
					$("#updateModal").modal('hide');
				}
				
				$("#updateDescription").focus();
				$("#updateCode").val(rows[0].code);
				$("#updateDescription").val(rows[0].description);
			});
			
			// delete模态框 
			$("#deleteModal").on("shown.bs.modal", function() {
				var rows = getTableSelectedData();
				if (rows.length < 1) {
					$("#deleteModal").modal('hide');
				}
				
				$("#deleteCode").val(rows[0].code);
				$("#deleteDescription").val(rows[0].description);
			});
			
			autoHideMessage();
			disabledButtons();
		}
	};
});
