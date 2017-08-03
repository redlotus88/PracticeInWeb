require.config({
	baseUrl: "/static/js",
	paths: {
		"jquery":["//cdn.bootcss.com/jquery/3.2.1/jquery.min", "//cdn.bootcss.com/jquery/3.2.1/jquery"],
	}
})

define(["jquery"], function($) {
	"use strict"
	return {
		ajax_get : function(_url) {
			return $.ajax({
						type : 'GET',
						url : _url,
						data : 'json',
				   });
		},
		
		ajax_post : function(_url) {
			return $.ajax({
				type : 'POST',
				url : _url,
				data : 'json',
		    });
		},
		
		ajax_delete : function(_url) {
			return $.ajax({
				type : 'DELETE',
				url : _url,
				data : 'json',
		    });
		},
	};
});