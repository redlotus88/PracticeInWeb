require.config({
	paths: {
		// jQuery Js
		"jquery":["//cdn.bootcss.com/jquery/3.2.1/jquery.min", "//cdn.bootcss.com/jquery/3.2.1/jquery"],
		"datatables.net": "//cdn.bootcss.com/datatables/1.10.15/js/jquery.dataTables",
		"bootstrapDT": "//cdn.bootcss.com/datatables/1.10.15/js/dataTables.bootstrap",
		"select2": "//cdn.bootcss.com/select2/4.0.3/js/select2.min",
	},
});

define(['jquery', 'datatables.net', 'bootstrapDT', 'select2'], 
		function($, dtnet, dataTable, select2) {
	"use strict"
	
	var _tableAccount;
	
	function loadRoles(selector) {
		$.ajax({ // make the request for the selected data object
			type : 'GET',
			url : '/admin/mgr/roles',
			dataType : 'json'
		}).then(function(data) {
			selector.select2({
				placeholder : '选择角色',
				allowClear: true,
				data:data,
			})
		});	
	}
	
	function deleteAccount(_id) {
		$.ajax({
			type: 'DELETE',
			url: '/usermgr/globalAccount/' + _id,
			dataType: 'json',
			success: function(result) {
				$("#message").html('<div class="alert alert-' + result.data.bootstrapType + '">' + result.data.content + '</div>');
			},
			
			error: function(data) {
				$("#message").html('<div class="alert alert-danger">Ajax执行错误，删除失败。</div>');
			}, 
			
			complete: function() {
				$("#deleteModal").modal('hide');
				console.log(_tableAccount);
				/* 强制刷新页面 */
				_tableAccount.ajax.reload();
			}
		});
	}
	
	return {
		/*
		 * 全局管理 - 账号管理页面的初始化
		 */
		initFunction : function() {
			// 列表初始化
			_tableAccount = $("#dt_account_list").DataTable({
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
			
			$('#dt_account_list tbody').on( 'click', 'tr', function () {
				/** 移除所有选择的行 */
				$('#dt_account_list tbody .selected').each(function() {
					$(this).removeClass('selected');
				});
				
				/** 选中当前点击的行 */
		        $(this).toggleClass('selected');
		        
		        $("#btnDelete").removeAttr('disabled');
		    });
			
			$("#addModal").on("shown.bs.modal", function() {
				loadRoles($(".modal-role-selection"));
				$("#accountName").focus();
			});
			
			$("#deleteModal").on("shown.bs.modal", function() {
				var rows = _tableAccount.rows('.selected').data();
				if (rows.length < 1) {
					$("#deleteModal").modal('hide');
				}
				
				/** 使用ajax异步删除元素 */
				$("#btnDelModal").on('click', function() {
					deleteAccount(rows[0].id);
				});
				
				$("#deleteId").val(rows[0].id);
				$("#deleteAccountName").val(rows[0].accountName);
				$("#deleteProfileName").val(rows[0].profileName);
			});
		},
	};
});
