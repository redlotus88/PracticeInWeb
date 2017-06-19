
// ┌─────────────────────────────────────────────────────────────────────┐ \\
// │ "Raphaël 2.0.2" - JavaScript Vector Library                         │ \\
// ├─────────────────────────────────────────────────────────────────────┤ \\
// │ Copyright (c) 2008-2011 Dmitry Baranovskiy (http://raphaeljs.com)   │ \\
// │ Copyright (c) 2008-2011 Sencha Labs (http://sencha.com)             │ \\
// │ Licensed under the MIT (http://raphaeljs.com/license.html) license. │ \\
// └─────────────────────────────────────────────────────────────────────┘ \\
                                                                             
// This module combines the core raphael module with the svg and vml modules
// to return a complete raphael object. Apps that want to use Raphaël as an 
// AMD module should reference this file.
// 
// Apps that want to load a plain old script that exports window.raphael 
// should use the combined raphael.js file.
require.config({
	paths: {
		"jquery":["//cdn.bootcss.com/jquery/3.2.1/jquery.min", "//cdn.bootcss.com/jquery/3.2.1/jquery"],
		"eve":["//cdn.bootcss.com/eve.js/0.8.4/eve.min"],
		"raphaelCore":["//cdn.bootcss.com/raphael/2.2.7/raphael"],
	},

	shim: {
		'eve' : {
			exports : 'eve'
		},
		
		'raphaelCore' : {
			deps: ['eve', 'jquery'],
			exports: 'raphaelCore'
		},
	}
})

define(['raphaelCore'], function (R) {  
    return R.ninja();
})