require.config({
	baseUrl: "static/js",
	paths: {
		"jquery":["//cdn.bootcss.com/jquery/3.2.1/jquery.min", "//cdn.bootcss.com/jquery/3.2.1/jquery"],
		"vue":["//cdn.bootcss.com/vue/2.3.3/vue"],
	}
})

require(['jquery','vue'], function($, vue) {
	vue.el = '#login_web_app';
	vue.data = {message : "hello Vue!"};
	
	$(document).ready(function() {
		console.log("加载login.js");
	});
})
