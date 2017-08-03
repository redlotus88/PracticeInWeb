/**
 * 关于AMD规范： https://github.com/amdjs/amdjs-api/wiki/AMD
 */

require.config({
	// define required js.
	baseUrl: "/static/js",
	paths: {
		"jquery":["//cdn.bootcss.com/jquery/3.2.1/jquery.min", "//cdn.bootcss.com/jquery/3.2.1/jquery"],
	}
})

require(['jquery'], function($) {
	$(document).ready(function() {
		// write any javascript..
	});
})

/**
 * Sets up the module with ID of "alpha", that uses require, exports and the module with ID of "beta":
 */
define("alpha", ["require", "exports", "beta"], function (require, exports, beta) {
       exports.verb = function() {
           return beta.verb();
           //Or:
           return require("beta").verb();
       }
   });

//匿名定义函数
define(["jquery"], function($) {
	"use strict"
	return {
		// write method. for usage.
		test : function() {
			
		}
	};
})