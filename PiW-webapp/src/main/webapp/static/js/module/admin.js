require.config({
	baseUrl: "/static/js/",
	paths: {
		// jQuery Js
		"jquery":["//cdn.bootcss.com/jquery/3.2.1/jquery.min", "//cdn.bootcss.com/jquery/3.2.1/jquery"],
		"bootstrap": "//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min",
		"metisMenu": "//cdn.bootcss.com/metisMenu/2.7.0/metisMenu.min",
		"datatables.net": "//cdn.bootcss.com/datatables/1.10.15/js/jquery.dataTables",
		"bootstrapDT": "//cdn.bootcss.com/datatables/1.10.15/js/dataTables.bootstrap",
		
		// custom javascript
		"dashboard": "/js/module/dashboard",
		"stringutils":"/js/module/stringutils"

	},
	
	shim: {
		'bootstrap' : {
			deps: ['jquery'],
			exports: 'bootstrap'
		},
		
		'metisMenu' : {
			deps: ['jquery'],
			exports: 'metisMenu'
		},
	}
})

require(['jquery', 'stringutils', 'bootstrap', 'metisMenu', 'datatables.net', 'bootstrapDT'], 
		function($, stringutils, bootstrap, metisMenu, DTnet, bootDT) {
	$(document).ready(function() {
		// 得到当前的uri.
		var pathname = window.location.pathname;
		
		initMenu(pathname);
		
		if (pathname === "/admin/dashboard") {
			// 加载dashboard
			require(['dashboard'], function(dashboard){
				dashboard.initFunction();
			});
		};
		
		if (pathname == "admin/mgr/account") {
			// 加载全局账号管理js
			$('#dataTables-example').dataTable();
		}
	});
	
	function initMenu(pathname) {
        /*MENU initilization
        ------------------------------------*/
		// 根据uri展开当前菜单
		$('a[data-selected-link]').each(function() {
			var link = $(this).data('selected-link');
			if (link === pathname) {
				$(this).parent('li').addClass('active-menu');
			} else if (stringutils.contains(pathname, link)) {
				$(this).parent('li').addClass('active');
			}
		});
		
		$('#main-menu').metisMenu();
		
		$(window).bind("load resize", function () {
            if ($(this).width() < 768) {
                $('div.sidebar-collapse').addClass('collapse')
            } else {
                $('div.sidebar-collapse').removeClass('collapse')
            }
        });
	}
});
