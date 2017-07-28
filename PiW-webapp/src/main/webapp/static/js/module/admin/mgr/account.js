/**
 * Account.js
 * 
 * @author Dragon.Wang
 * 
 * JS文件使用的插件如下：
 * Bootstrap modal, datatables, select2,
 * 
 * 使用的技术：
 * 表单POST提交。
 * ajax: GET，DELETE方法异步更新。
 * 
 */

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
	var _selectorRole;
	var timeoutEvent;
	
	function loadRoles(selector, checked) {
		$.ajax({ // make the request for the selected data object
			type : 'GET',
			url : '/admin/mgr/roles',
			dataType : 'json'
		}).then(function(data) {
			_selectorRole = selector.select2({
				placeholder : '选择角色',
				allowClear: true,
				data:data,
			});
			
			if (!(checked == undefined || checked == "")) {
				_selectorRole.val(checked).trigger("change");
			}
		});	
	}
	
	function resolveCheckedRoles(checked) {
		if (checked == undefined || checked == "" || checked.length < 3) {
			return checked;
		}
		return checked.substring(1, checked.length - 1).split(',');
	}
	
	function updateAccountRole(_id, roles) {
		$.ajax({
			type: 'POST',
			url: '/usermgr/globalAccount/' + _id,
			dataType: 'json',
			data: {"roles" : roles},
			success: function(result) {
				$("#message").html('<div class="alert alert-' + result.data.bootstrapType + '">' + result.data.content + '</div>');
			},
			
			error: function(result) {
				$("#message").html('<div class="alert alert-danger">Ajax执行错误，更新角色失败。</div>');
			},
		
			complete: function(result) {
				$("#updateModal").modal('hide');
				// 强制刷新table
				_tableAccount.ajax.reload();
				disabledButtons();
				autoHideMessage();
			}
		})
	}
	
	function deleteAccount(_id) {
		$.ajax({
			type: 'DELETE',
			url: '/usermgr/globalAccount/' + _id,
			dataType: 'json',
			success: function(result) {
				$("#message").html('<div class="alert alert-' + result.data.bootstrapType + '">' + result.data.content + '</div>');
				$("#message").show();
			},
			
			error: function(data) {
				$("#message").html('<div class="alert alert-danger">Ajax执行错误，删除失败。</div>');
			}, 
			
			complete: function() {
				$("#deleteModal").modal('hide');
				// 强制刷新table
				_tableAccount.ajax.reload();
				disabledButtons();
				autoHideMessage();
			}
		});
	}
	
	function getTableSelectedData() {
		return _tableAccount.rows('.selected').data();
	}
	
	function autoHideMessage(milli) {
		clearTimeout(timeoutEvent);
		timeoutEvent = setTimeout(function() {
							$("#message").hide(1000);
							$("#message").html("");
							$("#message").show();
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
			autoHideMessage();
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
		            { "data": "roles"},
		            { "data": "publicEmail"},
		            { "data": "company"},
		            { "data": "lastLoginTime", "width": "20%"},
		            { "data": "lastModifyTime", "width": "20%"},
		        ]
			});
			
			$('#dt_account_list tbody').on( 'click', 'tr', function () {
				// 移除所有选择的行
				$('#dt_account_list tbody .selected').each(function() {
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
				loadRoles($("#addRole"));
				$("#accountName").focus();
			});
			
			// update模态框
			$("#updateModal").on("shown.bs.modal", function() {
				var rows = getTableSelectedData();
				if (rows.length < 1) {
					$("#updateModal").modal('hide');
				}
				
				$("#btnUpdateModal").on('click', function() {
					updateAccountRole(rows[0].id, _selectorRole.select2("val"));
				});
				
				$("#updateAccountName").val(rows[0].accountName);
				loadRoles($("#updateRole"), resolveCheckedRoles(rows[0].roles));
			});
			
			// delete模态框 
			$("#deleteModal").on("shown.bs.modal", function() {
				var rows = getTableSelectedData();
				if (rows.length < 1) {
					$("#deleteModal").modal('hide');
				}
				
				// 使用ajax异步删除元素
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
