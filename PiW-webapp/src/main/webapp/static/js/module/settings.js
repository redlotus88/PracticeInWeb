require.config({
	baseUrl: "/static/js",
	paths: {
		// jQuery Js
		"jquery":["//cdn.bootcss.com/jquery/3.2.1/jquery.min", "//cdn.bootcss.com/jquery/3.2.1/jquery"],
		"bootstrap":["//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min"],
		"metisMenu":["//cdn.bootcss.com/metisMenu/2.7.0/metisMenu.min"],
		"eve":["//cdn.bootcss.com/eve.js/0.8.4/eve.min"],
		"raphael":["//cdn.bootcss.com/raphael/2.2.7/raphael"],
		"morris":["//cdn.bootcss.com/morris.js/0.5.1/morris"],
		"custom":["./module/custom"],
	},
	
	shim: {
		'eve' : {
			exports : 'eve'
		},
		
		'raphael' : {
			deps: ['eve', 'jquery'],
			exports: 'Raphael'
		},
		
		'bootstrap' : {
			deps: ['jquery'],
			exports: 'bootstrap'
		},
		
		'metisMenu' : {
			deps: ['jquery'],
			exports: 'metisMenu'
		},
		
		'morris' : {
			deps: ['raphael', 'jquery'],
			exports: 'Morris'
		},
		
		'custom' : {
			deps: ['jquery', 'morris', 'raphael'],
			exports: 'custom'
		}
	}
})

require(['jquery', 'eve', 'bootstrap', 'metisMenu', 'raphael', 'morris', 'custom'], 
		function($, eve, bootstrap, metisMenu, raphael, morris, custom) {
	$(document).ready(function() {
		window.Raphael = raphael;
		custom.initFunction();
	});
});
